package de.hshl.isd.machinetranslate

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.hshl.isd.machinetranslate.infra.MLKitTranslator
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var sourceText by mutableStateOf("")
    var translatedText by mutableStateOf("")
    var count = 0
    val translator = MLKitTranslator()

    fun translate() {
        viewModelScope.launch {
        kotlin.runCatching {
            translator.translate(sourceText, "en", "de")
        }.onSuccess { translatedText = it }
        }
    }

}
