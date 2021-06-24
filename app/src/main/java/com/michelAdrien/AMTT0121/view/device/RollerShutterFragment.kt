package com.michelAdrien.AMTT0121.view.device

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.michelAdrien.AMTT0121.R
import com.michelAdrien.AMTT0121.view.MainFragmentFactory
import com.michelAdrien.AMTT0121.viewModel.device.RollerShutterViewModel

class RollerShutterFragment : Fragment() {

    companion object {
        fun newInstance() = RollerShutterFragment()
    }

    private lateinit var viewModel: RollerShutterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (getArguments() != null) {
            if (getArguments() != null) {
                Toast.makeText(activity, "ID :" + requireArguments().getString(MainFragmentFactory.DEVICE_ID_EXTRA), Toast.LENGTH_LONG).show()
            }
        }
        return inflater.inflate(R.layout.roller_shutter_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RollerShutterViewModel::class.java)
        // TODO: Use the ViewModel
    }

}