package com.michelAdrien.AMTT0121.View.list.subpage

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.michelAdrien.AMTT0121.R

class DeviceViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val tv_device_name:TextView
    val tv_device_id:TextView
    val tv_device_type:TextView

    init{
        tv_device_name = view.findViewById(R.id.tv_device_name)
        tv_device_id = view.findViewById(R.id.tv_device_id)
        tv_device_type = view.findViewById(R.id.tv_device_type)
    }
}