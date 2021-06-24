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
import com.michelAdrien.AMTT0121.viewModel.device.HeaterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeaterFragment : Fragment() {

    companion object {
        fun newInstance() = HeaterFragment()
    }

    private lateinit var viewModel: HeaterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (getArguments() != null) {
            if (getArguments() != null) {
                Toast.makeText(activity, "ID :" + requireArguments().getString(MainFragmentFactory.DEVICE_ID_EXTRA), Toast.LENGTH_LONG).show()
            }
        }
        return inflater.inflate(R.layout.heater_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HeaterViewModel::class.java)
        // TODO: Use the ViewModel
    }

}