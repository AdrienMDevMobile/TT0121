package com.michelAdrien.AMTT0121.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.michelAdrien.AMTT0121.Model.device.IDevice
import com.michelAdrien.AMTT0121.Tool.Data.IRepository
import com.michelAdrien.AMTT0121.Tool.TabOrder
import java.util.ArrayList

class DeviceListViewModel(val IRepository : IRepository)  : ViewModel() {
    //private val _filter = MutableLiveData<Int>()

    private val _timerLiveData = MutableLiveData<ArrayList<IDevice>>()
    val timerLiveData: LiveData<ArrayList<IDevice>> = _timerLiveData

    /*
    val text: LiveData<String> = Transformations.map(_filter) {
        "Hello world from filter: $it"
    } */

    fun setIndex(filter: Int) {
        _timerLiveData.value = IRepository.getDeviceListFilter(TabOrder.filters[filter-1])
        //_filter.value = filter
    }

}