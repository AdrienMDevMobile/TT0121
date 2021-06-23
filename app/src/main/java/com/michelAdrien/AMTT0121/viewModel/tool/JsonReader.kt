package com.michelAdrien.AMTT0121.viewModel.tool

import android.annotation.SuppressLint
import android.content.Context
import com.michelAdrien.AMTT0121.model.Adress
import com.michelAdrien.AMTT0121.model.UserProfile
import com.michelAdrien.AMTT0121.model.device.Heater
import com.michelAdrien.AMTT0121.model.device.IDevice
import com.michelAdrien.AMTT0121.model.device.Light
import com.michelAdrien.AMTT0121.model.device.RollerShutter
import dagger.hilt.android.qualifiers.ApplicationContext
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject


//Load from a file to create json object
open class JsonReader @Inject constructor(@ApplicationContext private val context:Context) {

    companion object{
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


        fun getProfileFromString(datas: String): UserProfile {
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
    }


    @SuppressLint("DefaultLocale")
    fun loadJSONFromAsset(file_name: String): String? {
        val low_file_name : String = file_name.toLowerCase()

        val json = try {
            val assetManager = context.applicationContext.assets
            val `is`: InputStream = assetManager.open("json/" + low_file_name + ".json")
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            //Nous renvoyons le string pour json
            String(buffer, Charsets.UTF_8)
        }catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json

    }

    //We create those steps to be able to test the rest without needing a file for test
    fun loadDeviceListJson(file_name: String) : String?{
        loadJSONFromAsset(file_name).let{
            return JSONObject(it).getJSONArray("devices").toString()
        }
        return null
    }
    fun loadProfileJson(file_name: String):String?{
        loadJSONFromAsset(file_name).let{
            return JSONObject(it).getJSONObject("user").toString()
        }
        return null
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
