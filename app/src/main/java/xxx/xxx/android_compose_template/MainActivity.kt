package xxx.xxx.android_compose_template

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import xxx.xxx.android_compose_template.initialization.OnComposeWillCreate
import xxx.xxx.android_compose_template.initialization.initializeOnCreate
import dagger.hilt.android.AndroidEntryPoint
import xxx.xxx.android_compose_template.screen.article.ArticleRouteArguments
import xxx.xxx.android_compose_template.screen.article.ArticleScreen
import xxx.xxx.android_compose_template.screen.home.HomeScreen
import xxx.xxx.android_compose_template.ui.theme.ThemeContainer
import xxx.xxx.android_compose_template.util.*
import xxx.xxx.android_compose_template.util.RouteArguments.Companion.formattedArguments
import xxx.xxx.android_compose_template.util.RouteArguments.Companion.formattedRouteName

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class,
    ExperimentalAnimationApi::class
  )
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Globals.activity = this
    Globals.context = applicationContext

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
      window.attributes.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
    }

    initializeOnCreate()
    useFreeStatusBarLayout()

    @Composable
    fun ContentBody() {
      ThemeContainer {
        OnComposeWillCreate {
          Box(
            modifier = Modifier
              .fillMaxSize()
          ) {
            Routes(it)
          }
        }
      }
    }

    setContent { ContentBody() }
  }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun Routes(navController: NavHostController) {
  AnimatedNavHost(navController = navController, startDestination = "home") {
    animatedComposable(
      route = "home"
    ) {
      HomeScreen()
    }

    animatedComposable(
      route = ArticleRouteArguments::class.java.formattedRouteName,
      arguments = ArticleRouteArguments::class.java.formattedArguments,
    ) {
      ArticleScreen(it.arguments!!.toRouteArguments())
    }
  }
}