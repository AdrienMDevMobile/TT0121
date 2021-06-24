package com.michelAdrien.AMTT0121.view.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.michelAdrien.AMTT0121.model.device.IDevice
import com.michelAdrien.AMTT0121.R

//Handling DeviceViewHolder
class DeviceAdapter(private val device_list: ArrayList<IDevice>) : RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.device_view_item, parent, false)

        return DeviceViewHolder(view) //val clickListener: (IDevice) -> Unit
    }

    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) {
        holder.bind(device_list[position]) //clickListener
    }

    override fun getItemCount() = device_list.size


    class DeviceViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tv_device_name: TextView
        val tv_device_id: TextView
        val tv_device_type: TextView

        init{
            tv_device_name = view.findViewById(R.id.tv_device_name)
            tv_device_id = view.findViewById(R.id.tv_device_id)
            tv_device_type = view.findViewById(R.id.tv_device_type)
        }

        fun bind(device : IDevice ){
            this.tv_device_id.text = device.id.toString()
            this.tv_device_name.text = device.deviceName
            this.tv_device_type.text = device.javaClass.simpleName
            //itemView.setOnClickListener{ clickListener(device) } ,  clickListener: (IDevice) -> Unit
        }


    }

}




