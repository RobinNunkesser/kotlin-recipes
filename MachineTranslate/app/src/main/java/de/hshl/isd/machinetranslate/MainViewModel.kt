package de.hshl.isd.machinetranslate

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var sourceText by mutableStateOf("")
    var translatedText by mutableStateOf("")
    var count = 0

    fun translate() {
        count++
        translatedText = count.toString()
    }

}
