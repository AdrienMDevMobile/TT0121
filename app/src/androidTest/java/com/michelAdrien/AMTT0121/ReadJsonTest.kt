package com.michelAdrien.AMTT0121

import android.content.Context
import android.util.Log
import androidx.test.core.app.ApplicationProvider
import com.michelAdrien.AMTT0121.Model.UserProfile
import com.michelAdrien.AMTT0121.Model.device.Heater
import com.michelAdrien.AMTT0121.Model.device.Light
import com.michelAdrien.AMTT0121.Model.device.RollerShutter
import com.michelAdrien.AMTT0121.Tool.Data.JsonRepository
import com.michelAdrien.AMTT0121.Tool.JsonReader
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ReadJsonTest {
    /*

    val data_file_name = "data"
    lateinit var jsonRepository:JsonRepository

    //Set up la variable Context
    private lateinit var context: Context
    @Before
    fun set_up(){
        context = ApplicationProvider.getApplicationContext()
        jsonRepository = JsonRepository(context)
    }

    @Test
    fun loadJSONDevices(){
        val textJson = JsonReader(context).loadDeviceListJson(data_file_name)
        if(textJson != null){
            Log.d("TestJSON", textJson)
            assertTrue(textJson.isNotBlank())
        }
        else {
            assertTrue(false)
        }

    }

    private val stringJSONdevice : String = """
        [{"id":1,"deviceName":"Cuisine","intensity":50,"mode":"ON","productType":"Light"},{"id":2,"deviceName":"Salon","position":70,"productType":"RollerShutter"},{"id":3,"deviceName":"Chambre","mode":"OFF","temperature":20,"productType":"Heater"}, {"id":4,"deviceName":"Toilette","position":30,"productType":"RollerShutter"}]"
    """.trimIndent()
    //Now that we checked the string is correctly loaded from file, we check the string is correctly translated to ArrayList
    @Test
    fun getListIDeviceFromString(){
        val testList = jsonRepository.getDeviceListFromString(stringJSONdevice)
        assertTrue(testList.size == 4)
        assertTrue(testList[0] is Light)
        assertTrue(testList[1] is RollerShutter)
        assertTrue(testList[2] is Heater)
        assertTrue(testList[0].id ==1)
        assertTrue(testList[1].deviceName == "Salon")
    }

    @Test
    fun filterDeviceList(){
        val testList = jsonRepository.getDeviceListFromString(stringJSONdevice)
        val testListFull = jsonRepository.filterDeviceList("", testList)
        assertTrue(testListFull.size == 4)
        val testListHeater = jsonRepository.filterDeviceList(Heater::class.java.simpleName, testList)
        assertTrue(testListHeater.size == 1)
        val testListShutter = jsonRepository.filterDeviceList(RollerShutter::class.java.simpleName, testList)
        assertTrue(testListShutter.size == 2)
    }

    @Test
    fun loadJsonProfile(){
        val textJson = JsonReader(context).loadProfileJson(data_file_name)
        if(textJson != null){
            Log.d("TestJSON", textJson)
            assertTrue(textJson.isNotBlank())
        }
        else {
            assertTrue(false)
        }

    }

    private val stringJSONProfile = """
        {"firstName":"J","lastName":"D","address":{"city":"Issy","postalCode":92130,"street":"rue Michelet","streetCode":"2B","country":"Fr"},"birthDate":813766371000}"
    """.trimIndent()
    @Test
    fun getUserProfileFromString(){
        val testProfile = jsonRepository.getProfileFromString(stringJSONProfile)
        assertTrue(testProfile is UserProfile)
        assertTrue(testProfile != null)
        assertTrue(testProfile.firstName == "J")
        assertTrue(testProfile.address.country == "Fr")
    }
        */

}