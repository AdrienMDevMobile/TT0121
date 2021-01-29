package com.michelAdrien.AMTT0121

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import com.michelAdrien.AMTT0121.ui.list.ListFragmentFactory

class MainActivity : AppCompatActivity() {


    private val customFragmentFactory = ListFragmentFactory("Toc")

    override fun onCreate(savedInstanceState: Bundle?) {
        val fragmentFactory = customFragmentFactory
        getSupportFragmentManager().setFragmentFactory(fragmentFactory)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_navigation_activity)



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
        Log.d("testAdrien", "nous avons inflate")
        return true
    }

    //@TODO Put here switch to profile screen
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("testAdrien", "clicksurlemenu")
        return super.onOptionsItemSelected(item)
    }
}