package com.michelAdrien.AMTT0121.Tool

import android.annotation.SuppressLint
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

//Load from a file to create json object
open class JsonReader @Inject constructor(@ApplicationContext private val context:Context) {

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

}
