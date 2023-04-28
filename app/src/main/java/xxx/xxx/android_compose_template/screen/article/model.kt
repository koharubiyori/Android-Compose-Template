package xxx.xxx.android_compose_template.screen.article

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticleScreenModel @Inject constructor() : ViewModel() {
  var content by mutableStateOf("")
  lateinit var routeArguments: ArticleRouteArguments
}