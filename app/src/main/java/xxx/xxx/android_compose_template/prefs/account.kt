package xxx.xxx.android_compose_template.prefs

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import xxx.xxx.android_compose_template.DataStoreName
import xxx.xxx.android_compose_template.util.Globals

object AccountPref {
  private val Context.dataStore by preferencesDataStore(DataStoreName.ACCOUNT.name)
  private val dataStore get() = Globals.context.dataStore
  private val dataStoreKeys = object {
    val userName = stringPreferencesKey("userName")
  }

  val userName get() = dataStore.data.map { it[dataStoreKeys.userName] }
}