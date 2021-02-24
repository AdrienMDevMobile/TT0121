package com.michelAdrien.AMTT0121.Model.device

//I tried implementing data classe for all the Idevices. Unfortunatly, data class are not able to handle inheritance.
//Data class does not help with our current need (using inheritence and making sure all device have id and name)
abstract class IDevice(val id:Int, val deviceName:String) {

}