package com.michelAdrien.AMTT0121.viewModel.device

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.michelAdrien.AMTT0121.viewModel.tool.data.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

interface DeviceViewModelAbs {

    fun setId(id:String)

    /*fun setName(name:String) {
        _name_device.value = name
    }*/
    // TODO: Implement the ViewModel
}