package xxx.xxx.android_compose_template.util

import kotlin.reflect.KProperty

class InitRef<T>(var value: T)

operator fun InitRef<*>.getValue(thisRef: InitRef<*>?, property: KProperty<*>) = value
operator fun <T> InitRef<T>.setValue(thisRef: InitRef<*>?, property: KProperty<*>, newValue: T) {
  value = newValue
}