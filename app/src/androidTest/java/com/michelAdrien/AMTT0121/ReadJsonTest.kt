package com.michelAdrien.AMTT0121

import android.content.Context
import android.util.Log
import androidx.test.core.app.ApplicationProvider
import com.michelAdrien.AMTT0121.Model.device.Heater
import com.michelAdrien.AMTT0121.Model.device.Light
import com.michelAdrien.AMTT0121.Model.device.RollerShutter
import com.michelAdrien.AMTT0121.Tool.Data.JsondataManager
import com.michelAdrien.AMTT0121.Tool.JsonReader
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ReadJsonTest {

    val data_file_name = "data"

    //Set up la variable Context
    private lateinit var context: Context
    @Before
    fun set_up(){
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun loadJSONDevices(){
        val textJson = JsonReader(context).loadDeviceListJson(data_file_name)
        if(textJson != null){
            textJson?.let { Log.d("TestJSON", it) }
            assertTrue(textJson!!.isNotBlank())
        }
        else {
            assertTrue(false)
        }

    }

    private val stringJSON : String = "[{\"id\":1,\"deviceName\":\"Cuisine\",\"intensity\":50,\"mode\":\"ON\",\"productType\":\"Light\"},{\"id\":2,\"deviceName\":\"Salon\",\"position\":70,\"productType\":\"RollerShutter\"},{\"id\":3,\"deviceName\":\"Chambre\",\"mode\":\"OFF\",\"temperature\":20,\"productType\":\"Heater\"}]"

    //Now that we checked the string is correctly loaded from file, we check the string is correctly translated to ArrayList
    @Test
    fun getListIDeviceFromString(){
        val testList = JsondataManager(context).getDeviceListFromString(stringJSON)
        assertTrue(testList.size == 3)
        assertTrue(testList[0] is Light)
        assertTrue(testList[1] is RollerShutter)
        assertTrue(testList[2] is Heater)
        assertTrue(testList[0].id ==1)
        assertTrue(testList[1].deviceName == "Salon")
    }
}