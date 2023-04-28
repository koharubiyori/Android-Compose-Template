package xxx.xxx.android_compose_template.initialization

import android.os.Build
import androidx.activity.ComponentActivity
import xxx.xxx.android_compose_template.util.Globals

fun ComponentActivity.initializeOnCreate() {
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
    window.decorView.isForceDarkAllowed = false
  }

  val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
  val density = resources.displayMetrics.density
  val statusBarHeight = resources.getDimensionPixelSize(resourceId) / density

  Globals.statusBarHeight = statusBarHeight
}