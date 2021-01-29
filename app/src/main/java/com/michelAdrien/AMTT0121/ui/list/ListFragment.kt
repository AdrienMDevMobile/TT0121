package com.michelAdrien.AMTT0121.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.michelAdrien.AMTT0121.R

class ListFragment(val test : String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("testAdrien", "variableDeListFragment" + test)
        val root = inflater.inflate(R.layout.fragment_list, container, false)
        return root
    }
}