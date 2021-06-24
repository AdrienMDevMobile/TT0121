package com.michelAdrien.AMTT0121.view


import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.michelAdrien.AMTT0121.model.device.Heater
import com.michelAdrien.AMTT0121.model.device.IDevice
import com.michelAdrien.AMTT0121.view.device.HeaterFragment
import com.michelAdrien.AMTT0121.view.list.DeviceListFragment
import com.michelAdrien.AMTT0121.view.profile.ProfileFragment

class MainFragmentFactory() : FragmentFactory() { //val clickListener: (IDevice) -> Unit

    @NonNull
    override fun instantiate(@NonNull  classLoader : ClassLoader, @NonNull  className : String)  : Fragment {

        if(className == Heater::class.java.simpleName){
            return HeaterFragment()
        }

        val clazz : Class<out Fragment> = loadFragmentClass(classLoader, className)
        if (clazz == DeviceListFragment::class.java) {
                return DeviceListFragment()//clickListener
        }
        else if(clazz == ProfileFragment::class.java) {
            return ProfileFragment()
        }
        else {
            return super.instantiate(classLoader, className)
        }
    }



}
