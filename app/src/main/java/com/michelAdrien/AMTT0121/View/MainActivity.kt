package com.michelAdrien.AMTT0121.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.michelAdrien.AMTT0121.R
import com.michelAdrien.AMTT0121.View.list.DeviceListFragment
import com.michelAdrien.AMTT0121.View.profile.ProfileFragment

//Main activity : will load the action bar that will be kept everywhere.
//Then load the main fragment, starting with Device list Fragment
class MainActivity : AppCompatActivity() {


    private val customFragmentFactory = MainFragmentFactory()

    override fun onCreate(savedInstanceState: Bundle?) {

        val fragmentFactory = customFragmentFactory
        getSupportFragmentManager().setFragmentFactory(fragmentFactory)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_navigation_activity)

        //We set up the fragment
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<DeviceListFragment>(R.id.nav_host_fragment)
            }
        }

        val toolbar: Toolbar = findViewById(R.id.main_toolbar)
        setSupportActionBar(toolbar)


    }

    //Creation menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.burger_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        supportFragmentManager.commit {
            replace(
                R.id.nav_host_fragment,
                    customFragmentFactory.instantiate(classLoader, ProfileFragment::class.java.name))
            addToBackStack(null)
        }

        return true
    }
}