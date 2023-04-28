package xxx.xxx.android_compose_template.screen.article

import xxx.xxx.android_compose_template.util.RouteArguments
import xxx.xxx.android_compose_template.util.RouteName

@RouteName("home")
class ArticleRouteArguments (
  val id: Int,
  val title: String? = null,
) : RouteArguments() {
  constructor() : this(-1)
}