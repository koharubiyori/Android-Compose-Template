package xxx.xxx.android_compose_template.util

import android.annotation.SuppressLint
import android.content.Context
import androidx.activity.ComponentActivity
import androidx.navigation.NavHostController

// 专门存放全局延后赋值的变量
@SuppressLint("StaticFieldLeak")
object Globals {
  lateinit var activity: ComponentActivity
  lateinit var context: Context
  var statusBarHeight = 24F
  lateinit var navController: NavHostController
//  lateinit var room:
}