package com.michelAdrien.AMTT0121.View.list.subpage

import android.util.Log
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider

/*
class ListSubFragmentFactory(val viewModelFactory: ViewModelProvider.Factory) : FragmentFactory() {

    @NonNull
    override fun instantiate(@NonNull classLoader : ClassLoader, @NonNull className : String)  : Fragment {
        Log.d("TestSubFragment", ListSubFragment::class.java.name)

        val clazz : Class<out Fragment> = loadFragmentClass(classLoader, className)
        if (clazz == ListSubFragment::class.java) {
            return ListSubFragment(viewModelFactory)
        }
        else {
            return super.instantiate(classLoader, className)
        }
    }
}*/