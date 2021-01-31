package com.michelAdrien.AMTT0121.View.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.michelAdrien.AMTT0121.databinding.FragmentProfileBinding


class ProfileFragment(val test : String) : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root = binding.root

        /*

            private var _toolbarBinding: FragmentProfileBinding? = null
    private val toolbarBinding get() = _binding!!
        val saveItem = viewBinding.myToolbar.menu.findItem(R.id.action_done)
        setSupportActionBar(binding.main_toolbar) */

      //  binding.too
        //mainToolbar.inflateMenu(R.menu.sample_menu)
        //val saveItem = findV

        binding.tvProfile.text = "Prof + "+ test

        return root
    }
}