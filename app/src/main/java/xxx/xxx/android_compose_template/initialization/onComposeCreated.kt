package xxx.xxx.android_compose_template.initialization

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private val coroutineScope = CoroutineScope(Dispatchers.Main)

fun onComposeCreated() {
  coroutineScope.launch { checkShortcutIntent() }
  checkDeepLink()
}

private fun checkDeepLink() {

}

private fun checkShortcutIntent() {

}

