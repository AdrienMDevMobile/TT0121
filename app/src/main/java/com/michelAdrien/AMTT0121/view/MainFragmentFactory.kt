package com.michelAdrien.AMTT0121.view


import android.util.Log
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.michelAdrien.AMTT0121.model.device.Heater
import com.michelAdrien.AMTT0121.model.device.IDevice
import com.michelAdrien.AMTT0121.model.device.Light
import com.michelAdrien.AMTT0121.model.device.RollerShutter
import com.michelAdrien.AMTT0121.view.device.HeaterFragment
import com.michelAdrien.AMTT0121.view.device.LightFragment
import com.michelAdrien.AMTT0121.view.device.RollerShutterFragment
import com.michelAdrien.AMTT0121.view.list.DeviceListFragment
import com.michelAdrien.AMTT0121.view.profile.ProfileFragment

class MainFragmentFactory(val clickListener: (IDevice) -> Unit) : FragmentFactory() {

    companion object {
        val DEVICE_ID_EXTRA = "DEVICE_ID_EXTRA"
    }

    @NonNull
    override fun instantiate(@NonNull  classLoader : ClassLoader, @NonNull  className : String)  : Fragment {
        Log.i("fragmentFactory", className)
        Log.i("fragmentFactory2", Heater::class.java.simpleName)
        if(className == Heater::class.java.simpleName){
            return HeaterFragment()
        }
        else if(className == Light::class.java.simpleName){
            return LightFragment()
        }
        else if(className == RollerShutter::class.java.simpleName){
            return RollerShutterFragment()
        }

        val clazz : Class<out Fragment> = loadFragmentClass(classLoader, className)
        if (clazz == DeviceListFragment::class.java) {
                return DeviceListFragment(clickListener)
        }
        else if(clazz == ProfileFragment::class.java) {
            return ProfileFragment()
        }
        else {
            return super.instantiate(classLoader, className)
        }
    }



}
