package com.michelAdrien.AMTT0121.viewModel.tool.data

import com.michelAdrien.AMTT0121.model.Adress
import com.michelAdrien.AMTT0121.model.UserProfile
import com.michelAdrien.AMTT0121.model.device.Heater
import com.michelAdrien.AMTT0121.model.device.IDevice
import com.michelAdrien.AMTT0121.model.device.Light
import com.michelAdrien.AMTT0121.model.device.RollerShutter
import com.michelAdrien.AMTT0121.viewModel.tool.JsonReader
import com.michelAdrien.AMTT0121.view.TabOrder
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import javax.inject.Inject

class AssetFileRepository @Inject constructor(val jsonReader : JsonReader) : IRepository {

    val file_name="data"

    var list: ArrayList<IDevice>? = null

    override suspend fun getProfile(): UserProfile {
        return getProfileFromFile()
    }

    override suspend fun getDeviceList(): ArrayList<IDevice> {
        if(list.isNullOrEmpty()) list = getDeviceListFromFile()
        return list!!
    }

    override suspend fun getDeviceListFiltered(filter : String): ArrayList<IDevice> {
        return filterDeviceList(filter, getDeviceList())
    }

    fun filterDeviceList(filter : String, list : ArrayList<IDevice>): ArrayList<IDevice>{
        if(filter == "") //no filter
            return list
        else if(filter in TabOrder.filters){
            return list.filter { it.javaClass.simpleName == filter } as ArrayList<IDevice>
        }
        //return nothing if filter is incorrect
        return ArrayList<IDevice>()
    }

    override suspend fun getDevice(id: Int): IDevice? {
        if(list.isNullOrEmpty()) list = getDeviceListFromFile()

        list.let {
            for(device in list!!) {
                if (device.id == id) {
                    return device
                }
            }
        }
        return null
    }





    private fun getProfileFromFile():UserProfile{
        jsonReader.loadProfileJson(file_name)?.let { return JsonReader.getProfileFromString(it) }
        //If we cannot return anything
        throw JSONException("Could not load profile")
    }




    private fun getDeviceListFromFile():ArrayList<IDevice>{
         jsonReader.loadDeviceListJson(file_name)?.let { return JsonReader.getDeviceListFromString(it) }
        //If we cannot return anything
        return ArrayList<IDevice>()
    }




}