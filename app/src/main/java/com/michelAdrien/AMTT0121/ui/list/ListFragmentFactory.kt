package com.michelAdrien.AMTT0121.ui.list

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

class ListFragmentFactory(val test : String) : FragmentFactory() {
    /*Variables
    lateinit var test : String

    //Put arguments here so they are given to the variables defined above
    public fun ListFragmentFactory(test : String){
        this.test = test
    } */

    @NonNull
    override fun instantiate(@NonNull  classLoader : ClassLoader, @NonNull  className : String)  : Fragment {

        val clazz : Class<out Fragment> = loadFragmentClass(classLoader, className)
        if (clazz == ListFragment::class.java) {
                return ListFragment(test)
            } else {
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