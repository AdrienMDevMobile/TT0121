package com.michelAdrien.AMTT0121.viewModel.tool.data


import com.michelAdrien.AMTT0121.model.UserProfile
import com.michelAdrien.AMTT0121.model.device.IDevice

//The interface will ease future change (for instance using a Repository tool that uses database)
interface IRepository {

    fun getProfile() : UserProfile
    fun getDeviceList() : ArrayList<IDevice>
    fun getDeviceListFiltered(filter : String): ArrayList<IDevice>
    fun getDevice(id:Int): IDevice?
}