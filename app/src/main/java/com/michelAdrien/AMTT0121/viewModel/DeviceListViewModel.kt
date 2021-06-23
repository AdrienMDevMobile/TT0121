package com.michelAdrien.AMTT0121.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.michelAdrien.AMTT0121.model.device.IDevice
import com.michelAdrien.AMTT0121.viewModel.tool.data.IRepository
import com.michelAdrien.AMTT0121.view.TabOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.ArrayList
import javax.inject.Inject

@HiltViewModel
class DeviceListViewModel @Inject constructor(val iRepository : IRepository)  : ViewModel() {
    //private val _filter = MutableLiveData<Int>()

    private val _timerLiveData = MutableLiveData<ArrayList<IDevice>>()
    val timerLiveData: LiveData<ArrayList<IDevice>> = _timerLiveData

    fun setIndex(filter: Int) {
        viewModelScope.launch(Dispatchers.IO){
            _timerLiveData.postValue(iRepository.getDeviceListFiltered(TabOrder.filters[filter-1]))
        }
    }

}