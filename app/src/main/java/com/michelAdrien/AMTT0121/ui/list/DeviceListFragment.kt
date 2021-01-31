package com.michelAdrien.AMTT0121.ui.list

import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.michelAdrien.AMTT0121.R
import com.michelAdrien.AMTT0121.databinding.FragmentDeviceListBinding
import com.michelAdrien.AMTT0121.databinding.ToolbarDevicelistBinding
import com.michelAdrien.AMTT0121.ui.profile.ProfileFragment

class DeviceListFragment(val test : String) : Fragment() {

    private var _binding: FragmentDeviceListBinding? = null
    private val binding get() = _binding!!

    private var _TBbinding: ToolbarDevicelistBinding? = null
    private val TBbinding get() = _TBbinding!!

    //We informa that we want to change the menu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDeviceListBinding.inflate(inflater, container, false)
        val root = binding.root

        binding.tvList.text = "List + "+ test

        //Setting up the fragment custom to devicelist
        _TBbinding = binding.tbdDevicelist
        TBbinding.devMainToolbar.inflateMenu(R.menu.burger_menu)

        TBbinding.devMainToolbar.setOnMenuItemClickListener {
            Log.d("testAdrien", "click menu List")

            /*
            parentFragmentManager.commit {
                replace(R.id.nav_host_fragment,
                        customFragmentFactory.instantiate(classLoader, ProfileFragment::class.java.name))
                addToBackStack(null)
            } */


            true
        }

        return root
    }
}