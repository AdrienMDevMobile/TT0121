package com.michelAdrien.AMTT0121.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.michelAdrien.AMTT0121.R
import com.michelAdrien.AMTT0121.model.device.IDevice
import com.michelAdrien.AMTT0121.view.list.DeviceListFragment
import com.michelAdrien.AMTT0121.view.profile.ProfileFragment
import dagger.hilt.android.AndroidEntryPoint


//Main activity : will load the action bar that will be kept everywhere.
//Then load the main fragment, starting with Device list Fragment
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val customFragmentFactory = MainFragmentFactory { device: IDevice ->
        deviceClicked(
            device
        )
    }


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


    private fun deviceClicked(device : IDevice) {
        val myArguments = Bundle()
        myArguments.putString(MainFragmentFactory.DEVICE_ID_EXTRA, device.id.toString())

        val manager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        val fragment = customFragmentFactory.instantiate(classLoader, device.javaClass.simpleName)
        fragment.arguments = myArguments
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}