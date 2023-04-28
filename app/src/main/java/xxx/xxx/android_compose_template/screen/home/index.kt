package xxx.xxx.android_compose_template.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import xxx.xxx.android_compose_template.compable.StatusBar
import xxx.xxx.android_compose_template.screen.article.ArticleRouteArguments
import xxx.xxx.android_compose_template.util.Globals
import xxx.xxx.android_compose_template.util.navigate

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
  Scaffold(
    topBar = {
      StatusBar {
        TopAppBar(
          title = { Text(text = "Home") }
        )
      }
    }
  ) {
    Column() {
      Text(
        text = "Hello World!"
      )

      AsyncImage(
        model = "https://bn1302files.storage.live.com/y4meAs82SLn1J0nYxN49RYg487VNNRI6IfTj6yQYbgFXjQy0l0epUKismPOGEowPPfc5UtrlHcDsxq5bfDQDBm5OM_O2RmjuK0efTsmfEtxGMAzAJ0UJHDXm6uUg-rGK8c1auhHND4MUgJjvm9QjSDvlgAfXd-yASat-xT6_DdI4vQJjc9bJdFK9oD9rfqpw81U?width=1024&height=724&cropmode=none",
        contentDescription = null
      )

      Button(
        onClick = {
          Globals.navController.navigate(ArticleRouteArguments(2, "From Home"))
        }
      ) {
        Text("Goto Article")
      }
    }
  }
}