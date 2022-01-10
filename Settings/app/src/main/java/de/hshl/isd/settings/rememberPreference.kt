package de.hshl.isd.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.preference.PreferenceManager

@Composable
fun <T> rememberPreference(
    key: String,
    defaultValue: T,
): MutableState<T> {
    val context = LocalContext.current
    val prefs = PreferenceManager.getDefaultSharedPreferences(context)

    val state = remember {
        with(prefs) {
            val res: Any = when (defaultValue) {
                is Long -> getLong(key, defaultValue)
                is String -> getString(key, defaultValue) ?: defaultValue
                is Int -> getInt(key, defaultValue)
                is Boolean -> getBoolean(key, defaultValue)
                is Float -> getFloat(key, defaultValue)
                else -> throw IllegalArgumentException("This type can't be saved into Preferences")
            }
            res as T
        }
    }

    return remember {
        object : MutableState<T> {
            override var value: T
                get() = state
                set(value) {
                    with(prefs.edit()) {
                        when (value) {
                            is Long -> putLong(key, value)
                            is String -> putString(key, value)
                            is Int -> putInt(key, value)
                            is Boolean -> putBoolean(key, value)
                            is Float -> putFloat(key, value)
                            else -> throw IllegalArgumentException("This type can't be saved into Preferences")
                        }.apply()
                    }
                }

            override fun component1() = value
            override fun component2(): (T) -> Unit = { value = it }
        }
    }
}

