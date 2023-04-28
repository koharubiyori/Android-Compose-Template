package xxx.xxx.android_compose_template.screen.article

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.hilt.navigation.compose.hiltViewModel
import xxx.xxx.android_compose_template.compable.StatusBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ArticleScreen(arguments: ArticleRouteArguments) {
  val model: ArticleScreenModel = hiltViewModel()

  SideEffect {
    model.routeArguments = arguments
  }

  Scaffold(
    topBar = {
      StatusBar {
        TopAppBar(
          title = { Text(text = arguments.title ?: "Article") }
        )
      }
    }
  ) {
    Text(
      text = "ID:${arguments.id}"
    )
  }
}