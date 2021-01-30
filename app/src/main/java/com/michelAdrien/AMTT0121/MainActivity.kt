package com.michelAdrien.AMTT0121

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.ListFragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.michelAdrien.AMTT0121.ui.list.DeviceListFragment
import com.michelAdrien.AMTT0121.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {


    private val customFragmentFactory = MainFragmentFactory("Toc")

    override fun onCreate(savedInstanceState: Bundle?) {
        val fragmentFactory = customFragmentFactory
        getSupportFragmentManager().setFragmentFactory(fragmentFactory)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_navigation_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<DeviceListFragment>(R.id.nav_host_fragment)
            }
        }

        val toolbar: Toolbar = findViewById(R.id.main_toolbar)
        setSupportActionBar(toolbar)


        /*
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        */

    }

    //Creation menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.burger_menu, menu)
        return true
    }

    //@TODO Put here switch to profile screen
    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        supportFragmentManager.commit {
            replace(R.id.nav_host_fragment,
                    customFragmentFactory.instantiate(classLoader, ProfileFragment::class.java.name))
            addToBackStack(null)
        }

        return true
    }
}