package com.michelAdrien.AMTT0121.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.michelAdrien.AMTT0121.Tool.Data.DataManager

class ListViewModelFactory(val dataManager : DataManager) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(DeviceListViewModel::class.java)) {
            return DeviceListViewModel(dataManager) as T
        }
        if (modelClass.isAssignableFrom(LightViewModel::class.java)) {
            return LightViewModel(dataManager) as T
        }
        if (modelClass.isAssignableFrom(HeaterViewModel::class.java)) {
            return HeaterViewModel(dataManager) as T
        }
        if (modelClass.isAssignableFrom(RollerShutterViewModel::class.java)) {
            return RollerShutterViewModel(dataManager) as T
        }
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return LightViewModel(dataManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")


    }

}