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

@HiltViewModel
class RollerShutterViewModel  @Inject constructor(private val repository : IRepository) : ViewModel(), DeviceViewModelAbs {
    private val _name_device = MutableLiveData<String>()

    //val name : LiveData<String> = _name
    val name_device: LiveData<String> = _name_device

    override fun setId(id:String){
        viewModelScope.launch(Dispatchers.IO){
            _name_device.postValue(repository.getDevice(id.toInt())?.deviceName)
        }
    }
}