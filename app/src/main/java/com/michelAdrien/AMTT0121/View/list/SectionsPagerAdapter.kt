package com.michelAdrien.AMTT0121.View.list

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.michelAdrien.AMTT0121.R
import com.michelAdrien.AMTT0121.Tool.TabOrder
import com.michelAdrien.AMTT0121.View.list.subpage.ListSubFragment
import com.michelAdrien.AMTT0121.ViewModel.DeviceListViewModel


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return ListSubFragment.newInstance(position + 1)
        //return ListSubFragmentFactory(vm, position+1).instantiate(ClassLoader.getSystemClassLoader(), ListSubFragment::class.java.name)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(TabOrder.TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 4 total pages.
        return 4
    }
}