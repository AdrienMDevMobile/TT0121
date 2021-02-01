package com.michelAdrien.AMTT0121.Tool.Data

import android.content.Context
import com.michelAdrien.AMTT0121.Model.UserProfile
import com.michelAdrien.AMTT0121.Model.device.Heater
import com.michelAdrien.AMTT0121.Model.device.IDevice
import com.michelAdrien.AMTT0121.Model.device.Light
import com.michelAdrien.AMTT0121.Model.device.RollerShutter
import com.michelAdrien.AMTT0121.Tool.JsonReader
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class JsondataManager(val context: Context) : dataManager {

    val file_name="data"

    override fun getProfile(): UserProfile {
        TODO("Not yet implemented")
    }

    override fun getDeviceList(): ArrayList<IDevice> {
        return getDeviceListFromFile(file_name)
    }

    override fun <E> getDevice(id: Int): E {
        TODO("Not yet implemented")
    }

    override fun save(id: Int) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    /*
    fun getProfileFromFile(filename:String):UserProfile{

    }

    getProfile(datas:String)
     */

    fun getDeviceListFromFile(fileName:String):ArrayList<IDevice>{
         JsonReader(context).loadDeviceListJson(file_name)?.let { return getDeviceListFromString(it) }
        //If we cannot return anything
        return ArrayList<IDevice>()
    }

    fun getDeviceListFromString(datas:String):ArrayList<IDevice>{

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

            fun getMode(mode:String) : Boolean{
                return mode == "ON"
            }

            fun createIDevice(jsonO : JSONObject) : IDevice?{

                val deviceType = jsonO.getString(att_productType)
                when (deviceType) {
                    typeHeater -> return Heater(jsonO.getInt(att_id), jsonO.getString(att_deviceName),
                            jsonO.getInt("temperature"), getMode(jsonO.getString("mode")))
                    typeLight ->  return Light(jsonO.getInt(att_id), jsonO.getString(att_deviceName),
                            jsonO.getInt("intensity"), getMode(jsonO.getString("mode")))
                    typeShutter -> return RollerShutter(jsonO.getInt(att_id), jsonO.getString(att_deviceName),
                            jsonO.getInt("position"))
                    else ->  return null
                }

            }
        }
    }
}