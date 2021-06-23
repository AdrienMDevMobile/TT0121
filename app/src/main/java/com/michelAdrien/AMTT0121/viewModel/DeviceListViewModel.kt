package com.michelAdrien.AMTT0121.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.michelAdrien.AMTT0121.model.device.IDevice
import com.michelAdrien.AMTT0121.viewModel.tool.data.IRepository
import com.michelAdrien.AMTT0121.view.TabOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.ArrayList
import javax.inject.Inject

@HiltViewModel
class DeviceListViewModel @Inject constructor(val IRepository : IRepository)  : ViewModel() {
    //private val _filter = MutableLiveData<Int>()

    private val _timerLiveData = MutableLiveData<ArrayList<IDevice>>()
    val timerLiveData: LiveData<ArrayList<IDevice>> = _timerLiveData

    fun setIndex(filter: Int) {
        _timerLiveData.value = IRepository.getDeviceListFiltered(TabOrder.filters[filter-1])
        //_filter.value = filter
    }

}