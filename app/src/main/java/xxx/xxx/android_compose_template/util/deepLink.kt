package xxx.xxx.android_compose_template.util

import android.content.Intent
import java.net.URLDecoder

val Intent.deepLink get(): DeepLink? {
  val deepLinkStr = this.dataString?.let { URLDecoder.decode(it, "utf-8") } ?: return null
  return PageNameDeepLink("")
}

sealed class DeepLink

class PageNameDeepLink(
  val id: String,
) : DeepLink()
