package com.michelAdrien.AMTT0121.Model.device

import com.michelAdrien.AMTT0121.Model.device.IDevice

class RollerShutter(id:Int, deviceName:String, val position:Int) : IDevice(id, deviceName){

    companion object{
        val MAX_POSITION = 100
        val MIN_POSITION = 0
    }

}