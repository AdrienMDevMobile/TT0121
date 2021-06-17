package com.michelAdrien.AMTT0121.Tool.Data


import com.michelAdrien.AMTT0121.Model.UserProfile
import com.michelAdrien.AMTT0121.Model.device.IDevice

//The interface will ease future change (for instance using a Repository tool that uses database)
interface IRepository {

    fun getProfile() : UserProfile
    fun getDeviceList() : ArrayList<IDevice>
    fun getDeviceListFilter(filter : String): ArrayList<IDevice>
    fun getDevice(id:Int): IDevice?
}