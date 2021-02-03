package com.michelAdrien.AMTT0121.View.list.subpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.michelAdrien.AMTT0121.R
import com.michelAdrien.AMTT0121.Tool.Data.JsonRepository
import com.michelAdrien.AMTT0121.ViewModel.DeviceListViewModel
import com.michelAdrien.AMTT0121.ViewModel.ListViewModelFactory

class ListSubFragment() : Fragment() {
//val viewModelFactory : ViewModelProvider.Factory
    private lateinit var viewModelFactory : ListViewModelFactory
    private lateinit var pagerViewModel: DeviceListViewModel

    private lateinit var recyclerView: RecyclerView

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

        viewModelFactory = context?.let {ListViewModelFactory(JsonRepository(it))}!!
        pagerViewModel = ViewModelProvider(this, viewModelFactory)
                .get(DeviceListViewModel::class.java)
        pagerViewModel.setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)

        val root = inflater.inflate(R.layout.sub_fragment_main, container, false)

        recyclerView = root.findViewById<RecyclerView>(R.id.rv_list_devices).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            this.setHasFixedSize(true)
        }
        pagerViewModel.timerLiveData.observe(viewLifecycleOwner, {

            //Dans l'observe : ecrase et refait le RecyclerViewAdapter
            val viewAdapter = DeviceAdapter(it)
            // use a linear layout manager
            recyclerView.layoutManager = LinearLayoutManager(context)
            // specify an viewAdapter (see also next example)
            recyclerView.adapter = viewAdapter

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