package com.michelAdrien.AMTT0121.Tool.Data

import android.content.Context
import com.michelAdrien.AMTT0121.Model.Adress
import com.michelAdrien.AMTT0121.Model.UserProfile
import com.michelAdrien.AMTT0121.Model.device.Heater
import com.michelAdrien.AMTT0121.Model.device.IDevice
import com.michelAdrien.AMTT0121.Model.device.Light
import com.michelAdrien.AMTT0121.Model.device.RollerShutter
import com.michelAdrien.AMTT0121.Tool.JsonReader
import com.michelAdrien.AMTT0121.Tool.TabOrder
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class JsonRepository(val context: Context) : IRepository {

    val file_name="data"

    override fun getProfile(): UserProfile {
        return getProfileFromFile()
    }

    override fun getDeviceList(): ArrayList<IDevice> {
        return getDeviceListFromFile()
    }

    override fun getDeviceListFilter(filter : String): ArrayList<IDevice> {
        return filterDeviceList(filter, getDeviceListFromFile())
    }

    fun filterDeviceList(filter : String, list : ArrayList<IDevice>): ArrayList<IDevice>{
        if(filter == "") //no filter
            return list
        else if(filter in TabOrder.filters){
            val filteredList = ArrayList<IDevice>()
            for (device in list){
                if(device.javaClass.simpleName == filter)
                    filteredList.add(device)
            }
            return filteredList
        }
        //return nothing if filter is incorrect
        return ArrayList<IDevice>()
    }


    override fun getDevice(id: Int): IDevice? {
        val listDevices = getDeviceListFromFile()
        for(device in listDevices) {
            if (device.id == id) {
                return device
            }
        }
        return null
    }
    /*
     override fun save(device: IDevice) {
         TODO("Not yet implemented")
     }

     override fun delete(id: Int) {
         TODO("Not yet implemented")
     }*/


    fun getProfileFromFile():UserProfile{
        JsonReader(context).loadProfileJson(file_name)?.let { return getProfileFromString(it) }
        //If we cannot return anything
        throw JSONException("Could not load profile")
    }

    fun getProfileFromString(datas: String):UserProfile {
        val jObject = JSONObject(datas)

        val firstName: String =
                jObject.getString("firstName")
        val lastName: String =
                jObject.getString("lastName")
        val birthDate:Double =
                jObject.getDouble("birthDate")

        val addressText: JSONObject =
                jObject.getJSONObject("address")
        val addressCity = addressText.getString("city")
        val addressPostal = addressText.getInt("postalCode")
        val street = addressText.getString("street")
        val streetCode = addressText.getString("streetCode")
        val country = addressText.getString("country")
        val address =  Adress(addressCity, addressPostal, street, streetCode, country)


        return UserProfile(firstName, lastName, address, birthDate)
    }



    fun getDeviceListFromFile():ArrayList<IDevice>{
         JsonReader(context).loadDeviceListJson(file_name)?.let { return getDeviceListFromString(it) }
        //If we cannot return anything
        return ArrayList<IDevice>()
    }

    fun getDeviceListFromString(datas: String):ArrayList<IDevice>{

        try {
            val jArray = JSONArray(datas)
            val list = ArrayList<IDevice>()

            for (i in 0 until jArray.length()) {

                val idevice = IDeviceManager.createIDevice(jArray.getJSONObject(i))

                if (idevice != null) {
                    list.add(idevice)
                }

            }

            return list
        } catch (e: JSONException) {
            e.printStackTrace()
            return ArrayList<IDevice>()
        }
    }

    private class IDeviceManager(){
        companion object{

            val att_productType = "productType"
            val att_id = "id"
            val att_deviceName = "deviceName"

            val typeHeater = "Heater"
            val typeLight = "Light"
            val typeShutter = "RollerShutter"

            fun getMode(mode: String) : Boolean{
                return mode == "ON"
            }

            fun createIDevice(jsonO: JSONObject) : IDevice?{

                val deviceType = jsonO.getString(att_productType)
                when (deviceType) {
                    typeHeater -> return Heater(jsonO.getInt(att_id), jsonO.getString(att_deviceName),
                            jsonO.getInt("temperature"), getMode(jsonO.getString("mode")))
                    typeLight -> return Light(jsonO.getInt(att_id), jsonO.getString(att_deviceName),
                            jsonO.getInt("intensity"), getMode(jsonO.getString("mode")))
                    typeShutter -> return RollerShutter(jsonO.getInt(att_id), jsonO.getString(att_deviceName),
                            jsonO.getInt("position"))
                    else ->  return null
                }

            }
        }
    }
}