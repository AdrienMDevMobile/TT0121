package com.michelAdrien.AMTT0121

import android.util.Log
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.michelAdrien.AMTT0121.ui.list.DeviceListFragment
import com.michelAdrien.AMTT0121.ui.profile.ProfileFragment

class MainFragmentFactory(val test : String) : FragmentFactory() {
    /*Variables
    lateinit var test : String

    //Put arguments here so they are given to the variables defined above
    public fun ListFragmentFactory(test : String){
        this.test = test
    } */

    @NonNull
    override fun instantiate(@NonNull  classLoader : ClassLoader, @NonNull  className : String)  : Fragment {
        Log.d("testAdrien", "className" + className)

        val clazz : Class<out Fragment> = loadFragmentClass(classLoader, className)
        if (clazz == DeviceListFragment::class.java) {
            Log.d("testAdrien", "twoF")
                return DeviceListFragment(test)
        }
        else if(clazz == ProfileFragment::class.java) {
            Log.d("testAdrien", "oneF")
            return ProfileFragment(test)
        }
        else {
            Log.d("testAdrien", "threeF")
            return super.instantiate(classLoader, className)
        }
    }



}

/*
class CustomFragmentFactory(private val dependency: Dependency) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        if (className == CustomFragment::class.java.name) {
            return CustomFragment(dependency)
        }
        return super.instantiate(classLoader, className)
    }
} */