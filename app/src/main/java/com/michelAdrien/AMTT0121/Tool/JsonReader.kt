package com.michelAdrien.AMTT0121.Tool

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream


open class JsonReader(val context: Context) {

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

    //We create those steps to be able to test the rest without needing a file
    //just sample data from test code.
    fun loadDeviceListJson(file_name: String) : String?{

        val jobject = JSONObject(loadJSONFromAsset(file_name))
        return jobject.getJSONArray("devices").toString()
    }
    fun loadProfileJson(file_name: String):String?{
        val jobject = JSONObject(loadJSONFromAsset(file_name))
        return jobject.getJSONArray("user").toString()
    }


}
