package com.michelAdrien.AMTT0121.View.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.michelAdrien.AMTT0121.R
import com.michelAdrien.AMTT0121.Tool.Data.JsondataManager
import com.michelAdrien.AMTT0121.ViewModel.DeviceListViewModel
import com.michelAdrien.AMTT0121.ViewModel.ListViewModelFactory

/**
 * A placeholder fragment containing a simple view.
 */
class ListSubFragment : Fragment() {

    private lateinit var viewModelFactory : ListViewModelFactory
    private lateinit var pagerViewModel: DeviceListViewModel

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pagerViewModel = ViewModelProvider(this).get(DeviceListViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }*/

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        viewModelFactory = context?.let {ListViewModelFactory(JsondataManager(it))}!!
        pagerViewModel = ViewModelProvider(this, viewModelFactory)
                .get(DeviceListViewModel::class.java)
        pagerViewModel.setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)

        val root = inflater.inflate(R.layout.sub_fragment_main, container, false)
        val textView: TextView = root.findViewById(R.id.section_label)
        pagerViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): ListSubFragment {
            return ListSubFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}