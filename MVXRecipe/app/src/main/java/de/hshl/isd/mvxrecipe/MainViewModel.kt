package de.hshl.isd.mvxrecipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    // Two way bindable values
    val forename = MutableLiveData("f")
    val surname = MutableLiveData("s")

    // One way bindable value
    private val _name = MutableLiveData("")
    val name: LiveData<String>
        get() = _name

    // Mediated value
    val mediatorName: MediatorLiveData<String> by lazy {
        MediatorLiveData<String>()
    }

    init {
        mediatorName.addSource(forename,
            { mediatorName.value = """${forename.value} ${surname.value}""" })
        mediatorName.addSource(surname,
            { mediatorName.value = """${forename.value} ${surname.value}""" })
    }

    fun computeName() {
        _name.value = """${forename.value} ${surname.value}"""
        forename.value = "Detlef"
    }

}
