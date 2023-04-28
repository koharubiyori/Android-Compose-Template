package xxx.xxx.android_compose_template.initialization

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import xxx.xxx.android_compose_template.util.Globals

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun OnComposeWillCreate(
  content: @Composable (NavHostController) -> Unit
) {
  val themeColors = MaterialTheme.colors
  val navController = rememberAnimatedNavController()
  LaunchedEffect(true) {
    Globals.navController = navController

    onComposeCreated()
  }

  CompositionLocalProvider(

  ) {
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(themeColors.background)
    ) {
      content(navController)
    }
  }
}