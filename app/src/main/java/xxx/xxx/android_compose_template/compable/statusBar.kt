package xxx.xxx.android_compose_template.compable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import xxx.xxx.android_compose_template.util.Globals
import xxx.xxx.android_compose_template.util.useFreeStatusBarLayout
import xxx.xxx.android_compose_template.util.useStickyStatusBarLayout

@Composable
fun StatusBar(
  mode: StatusBarMode = StatusBarMode.VISIBLE,
  sticky: Boolean = false,
  backgroundColor: Color = Color.Transparent,
  darkIcons: Boolean = false,
  layoutPlaceholder: Boolean = true,
  content: (@Composable () -> Unit)? = null,
) {
  val theme = MaterialTheme.colors
  val systemUiController = rememberSystemUiController()
  val refStatusBarLocked = statusBarLocked   // state必须出现在composable函数的上下文中，才能正确触发组件重渲染

  fun syncConfig() {
    when(mode) {
      StatusBarMode.VISIBLE -> {
        Globals.activity.useFreeStatusBarLayout()
        systemUiController.isStatusBarVisible = true
      }
      StatusBarMode.HIDE -> systemUiController.isStatusBarVisible = false
      StatusBarMode.STICKY -> {
        Globals.activity.useStickyStatusBarLayout()
      }
    }
    systemUiController.setStatusBarColor(
      color = backgroundColor,
      darkIcons = darkIcons
    )

    CachedStatusBarConfig.mode = mode
    CachedStatusBarConfig.sticky = sticky
    CachedStatusBarConfig.backgroundColor = backgroundColor
    CachedStatusBarConfig.darkIcons = darkIcons
  }

  LaunchedEffect(
    mode,
    backgroundColor,
    darkIcons,
    refStatusBarLocked
  ) {
    if (refStatusBarLocked) return@LaunchedEffect
    syncConfig()
  }

  LifecycleEventEffect(
    onResume = {
      if (refStatusBarLocked) return@LifecycleEventEffect
      syncConfig()
    }
  )

  Column() {
    if (layoutPlaceholder) {
      Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(Globals.statusBarHeight.dp)
        .background(theme.primary)
      )
    }

    content?.invoke()
  }
}

var statusBarLocked by mutableStateOf(false)
object CachedStatusBarConfig {
  var mode = StatusBarMode.VISIBLE
  var sticky = false
  var backgroundColor = Color.Transparent
  var darkIcons = false
}

enum class StatusBarMode {
  VISIBLE,
  HIDE,
  STICKY
}