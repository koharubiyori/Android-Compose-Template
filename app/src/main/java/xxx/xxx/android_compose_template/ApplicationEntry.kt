package xxx.xxx.android_compose_template

import android.app.Application
import xxx.xxx.android_compose_template.initialization.initializeOnCreate
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class ApplicationEntry : Application() {
  override fun onCreate() {
    super.onCreate()
    initializeOnCreate()
  }
}

