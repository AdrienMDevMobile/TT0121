package com.michelAdrien.AMTT0121.ui.list

import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.michelAdrien.AMTT0121.databinding.FragmentDeviceListBinding

class DeviceListFragment(val test : String) : Fragment() {

    private var _binding: FragmentDeviceListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDeviceListBinding.inflate(inflater, container, false)
        val root = binding.root

        binding.tvList.text = "List + "+ test

        Log.d("testAdrien","List")
        return root
    }
}