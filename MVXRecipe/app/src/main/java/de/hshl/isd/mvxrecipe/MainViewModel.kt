package de.hshl.isd.mvxrecipe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var forename by mutableStateOf("")
    var surname by mutableStateOf("")

    fun reset() {
        forename = ""
        surname = ""
    }

}
