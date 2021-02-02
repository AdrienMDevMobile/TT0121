package com.michelAdrien.AMTT0121.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.michelAdrien.AMTT0121.Model.device.IDevice
import com.michelAdrien.AMTT0121.Tool.Data.DataManager
import java.util.ArrayList

class DeviceListViewModel(val dataManager : DataManager)  : ViewModel() {
    private val _filter = MutableLiveData<Int>()
    private val listDevice = dataManager.getDeviceList()

    private val _timerLiveData = MutableLiveData<ArrayList<IDevice>>()
    val timerLiveData: LiveData<ArrayList<IDevice>> = _timerLiveData

    val text: LiveData<String> = Transformations.map(_filter) {
        "Hello world from filter: $it"
    }

    init{
        _timerLiveData.value = listDevice
    }

    fun setIndex(filter: Int) {
        _filter.value = filter
    }

}