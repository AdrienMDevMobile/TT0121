package com.michelAdrien.AMTT0121.viewModel.tool.data


import com.michelAdrien.AMTT0121.model.UserProfile
import com.michelAdrien.AMTT0121.model.device.IDevice

//The interface will ease future change (for instance using a Repository tool that uses database)
interface IRepository {

    suspend fun getProfile() : UserProfile
    suspend fun getDeviceList() : ArrayList<IDevice>
    suspend fun getDeviceListFiltered(filter : String): ArrayList<IDevice>
    suspend fun getDevice(id:Int): IDevice?
}