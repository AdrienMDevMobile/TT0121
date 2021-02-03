package com.michelAdrien.AMTT0121.View.list.subpage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.michelAdrien.AMTT0121.Model.device.IDevice
import com.michelAdrien.AMTT0121.R

//Handling DeviceViewHolder
class DeviceAdapter(private val device_list: ArrayList<IDevice>) : RecyclerView.Adapter<DeviceViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.device_view_item, parent, false)

        return DeviceViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) {
        holder.tv_device_id.text = device_list[position].id.toString()
        holder.tv_device_name.text = device_list[position].deviceName
        holder.tv_device_type.text = device_list[position].javaClass.simpleName
    }

    override fun getItemCount() = device_list.size

}




