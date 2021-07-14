package com.michelAdrien.AMTT0121.view.device

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.michelAdrien.AMTT0121.databinding.HeaterFragmentBinding
import com.michelAdrien.AMTT0121.databinding.LightFragmentBinding
import com.michelAdrien.AMTT0121.viewModel.device.HeaterViewModel
import com.michelAdrien.AMTT0121.viewModel.device.LightViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LightFragment : DeviceFragmentAbs() {
    private var _binding: LightFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LightViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LightFragmentBinding.inflate(inflater, container, false)
        //val root = binding.root


        //viewModel = ViewModelProvider(this).get(LightViewModel::class.java)
        viewModel.name_device.observe(viewLifecycleOwner, {
            binding.includeDeviceName.tvDeviceName.setText(it)
        })

        loadDeviceInfo(viewModel)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}