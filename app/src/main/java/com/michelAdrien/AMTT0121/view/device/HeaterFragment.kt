package com.michelAdrien.AMTT0121.view.device

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.michelAdrien.AMTT0121.databinding.HeaterFragmentBinding
import com.michelAdrien.AMTT0121.viewModel.device.HeaterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeaterFragment : DeviceFragmentAbs() {
    private var _binding: HeaterFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HeaterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HeaterFragmentBinding.inflate(inflater, container, false)
        //val root = binding.root

        //viewModel = ViewModelProvider(this).get(HeaterViewModel::class.java)
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