package com.example.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.menus.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var homeFragments: HomeFragment
    lateinit var chatFragments: ChatFragment
    lateinit var settingsFragment: SettingsFragment

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.nav_view_btm)
        binding.navViewBtm.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home_menu -> {//Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
                homeFragments = HomeFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.containerFl, homeFragments)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null)
                    .commit()
            }
            R.id.chat_menu -> { //Toast.makeText(this, "Chat clicked", Toast.LENGTH_SHORT).show()
                chatFragments = ChatFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.containerFl, chatFragments)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null)
                    .commit()
            }
            R.id.settings_menu -> { //Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
                settingsFragment = SettingsFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.containerFl, settingsFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null)
                    .commit()
            }
        }
        return false
    }

}