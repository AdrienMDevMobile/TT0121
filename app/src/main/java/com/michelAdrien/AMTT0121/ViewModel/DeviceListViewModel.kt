package com.michelAdrien.AMTT0121.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.michelAdrien.AMTT0121.Tool.Data.DataManager

class DeviceListViewModel(val dataManager : DataManager)  : ViewModel() {
    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Hello world from factory: $it"
    }

    fun setIndex(index: Int) {
        _index.value = index
    }

}