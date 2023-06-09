package xxx.xxx.android_compose_template.util

import android.content.Intent
import xxx.xxx.android_compose_template.util.Globals

val Intent.shortcutAction get(): ShortcutAction? {
  val intentAction = Globals.activity.intent.action ?: ""
  val regexPackageName = Regex.escape(Globals.context.packageName)
  val getShortcutActionRegex = Regex("""^$regexPackageName\.(.+)$""")

  return if (intentAction.contains(getShortcutActionRegex)){
    val shortcutAction = getShortcutActionRegex.find(intentAction)!!.groupValues[1]
    ShortcutAction.valueOf(shortcutAction)
  } else {
    null
  }
}

enum class ShortcutAction {
  SEARCH,
  CONTINUE_READ,
  RANDOM
}