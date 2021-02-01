package com.michelAdrien.AMTT0121.Tool.Data


import com.michelAdrien.AMTT0121.Model.UserProfile
import com.michelAdrien.AMTT0121.Model.device.IDevice

interface dataManager {

    fun getProfile() : UserProfile
    fun getDeviceList() : ArrayList<IDevice>
    fun <E> getDevice(id:Int): E
    fun save(id:Int)
    fun delete(id:Int)
}