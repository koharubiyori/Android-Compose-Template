package xxx.xxx.android_compose_template.compable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import xxx.xxx.android_compose_template.util.InitRef

@Composable
fun DoSideEffect(
  effect: () -> Unit
) {
  val doneFlag = remember { InitRef(false) }

  if (!doneFlag.value) {
    effect()
    doneFlag.value = true
  }

  SideEffect(effect)
}