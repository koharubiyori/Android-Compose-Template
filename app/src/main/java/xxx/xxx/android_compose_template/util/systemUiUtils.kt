package xxx.xxx.android_compose_template.util

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowManager


fun Activity.useFreeStatusBarLayout() {
  // 删除默认的顶部状态栏高度偏移
  window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
  window.decorView.systemUiVisibility =
    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
      View.SYSTEM_UI_FLAG_LAYOUT_STABLE
}

fun Activity.useStickyStatusBarLayout() {
  window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
  window.decorView.systemUiVisibility =
    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
      View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
      View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
      View.SYSTEM_UI_FLAG_FULLSCREEN
}

fun Activity.useFullScreenLayout() {
  window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
  window.decorView.systemUiVisibility =
    View.SYSTEM_UI_FLAG_FULLSCREEN or
    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
    View.SYSTEM_UI_FLAG_IMMERSIVE
}