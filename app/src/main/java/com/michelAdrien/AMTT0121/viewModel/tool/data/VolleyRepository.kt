package com.michelAdrien.AMTT0121.viewModel.tool.data

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.michelAdrien.AMTT0121.model.UserProfile
import com.michelAdrien.AMTT0121.model.device.IDevice
import com.michelAdrien.AMTT0121.view.TabOrder
import com.michelAdrien.AMTT0121.viewModel.tool.JsonReader
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.json.JSONObject
import javax.inject.Inject
import kotlin.coroutines.resume

class VolleyRepository @Inject constructor(val queue : RequestQueue, val jsonReader : JsonReader) : IRepository {

    val file_url="http://storage42.com/modulotest/data.json"

    var list: ArrayList<IDevice>? = null
    var profile:UserProfile?= null

    val mutex = Mutex()

    override suspend fun getProfile(): UserProfile {
        waitLoading()
        return profile?:return UserProfile()
    }

    private suspend fun waitLoading(){
        mutex.withLock {
            if (profile == null) {
                loadFromVolley()
            }
        }
    }

    override suspend fun getDeviceList(): ArrayList<IDevice> {
        waitLoading()
        return list?:ArrayList<IDevice>()
    }

    override suspend fun getDeviceListFiltered(filter: String): ArrayList<IDevice> {
        return filterDeviceList(filter, getDeviceList())
    }

    override suspend fun getDevice(id: Int): IDevice? {
        waitLoading()

        list.let {
            for(device in list!!) {
                if (device.id == id) {
                    return device
                }
            }
        }
        return null
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

    private suspend fun loadFromVolley() : Boolean{

        return suspendCancellableCoroutine{ cancellableContinuation ->

            try{
                val success = Response.Listener<JSONObject> { response ->
                    if (cancellableContinuation.isActive) {
                        profile = JsonReader.getProfileFromString(response.getJSONObject("user").toString())
                        list = JsonReader.getDeviceListFromString(response.getJSONArray("devices").toString())
                    }
                    cancellableContinuation.resume(true)
                }

                val error = Response.ErrorListener {
                    cancellableContinuation.resume(false)
                }

                val jsonObjectRequest =
                    JsonObjectRequest(Request.Method.GET, file_url, null, success, error)

                queue.add(jsonObjectRequest)
            }
            catch (e: Exception) {
                e.printStackTrace()
                cancellableContinuation.resume(false)
            }
        }
    }
}