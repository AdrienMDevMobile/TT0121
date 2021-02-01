package com.michelAdrien.AMTT0121.Tool.Data


import com.michelAdrien.AMTT0121.Model.UserProfile
import com.michelAdrien.AMTT0121.Model.device.IDevice

interface DataManager {

    fun getProfile() : UserProfile
    fun getDeviceList() : ArrayList<IDevice>
    fun getDevice(id:Int): IDevice?
    //fun save(device:IDevice)
    //fun delete(id:Int)
}