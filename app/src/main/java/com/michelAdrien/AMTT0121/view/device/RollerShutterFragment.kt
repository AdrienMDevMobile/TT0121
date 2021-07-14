package com.michelAdrien.AMTT0121.view.device

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.michelAdrien.AMTT0121.R
import com.michelAdrien.AMTT0121.databinding.HeaterFragmentBinding
import com.michelAdrien.AMTT0121.databinding.LightFragmentBinding
import com.michelAdrien.AMTT0121.databinding.RollerShutterFragmentBinding
import com.michelAdrien.AMTT0121.view.MainFragmentFactory
import com.michelAdrien.AMTT0121.viewModel.device.LightViewModel
import com.michelAdrien.AMTT0121.viewModel.device.RollerShutterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RollerShutterFragment : DeviceFragmentAbs() {
    private var _binding: RollerShutterFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RollerShutterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RollerShutterFragmentBinding.inflate(inflater, container, false)
        //val root = binding.root

        //viewModel = ViewModelProvider(this).get(RollerShutterViewModel::class.java)
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