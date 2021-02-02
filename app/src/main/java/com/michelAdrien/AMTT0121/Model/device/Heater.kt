package com.michelAdrien.AMTT0121.Model.device

class Heater ( id: Int, deviceName:String, val temperature:Int, val mode: Boolean): IDevice(id, deviceName) {

    companion object{
        val MAX_HEAT = 28
        val MIN_HEAT = 7
    }


}