package com.michelAdrien.AMTT0121.Model.device

class Light( id: Int, deviceName:String, val intensity:Int, val mode: Boolean): IDevice(id, deviceName) {

    companion object{
        val MAX_INTENSITY = 100
        val MIN_INTENSITY = 0
    }

}