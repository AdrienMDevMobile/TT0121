package com.michelAdrien.AMTT0121.view.device

import androidx.fragment.app.Fragment
import com.michelAdrien.AMTT0121.view.MainFragmentFactory
import com.michelAdrien.AMTT0121.viewModel.device.DeviceViewModelAbs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class DeviceFragmentAbs : Fragment() {
    fun loadDeviceInfo(viewModel : DeviceViewModelAbs){
        if (getArguments() != null) {
            if (getArguments() != null) {
                requireArguments().getString(MainFragmentFactory.DEVICE_ID_EXTRA)?.let {
                    viewModel.setId(
                        it
                    )
                }
            }
        }
    }
}