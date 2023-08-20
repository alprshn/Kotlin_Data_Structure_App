package com.example.datastrutures

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.datastrutures.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_stack, R.id.nav_queues, R.id.nav_binary_trees
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        var selector: Boolean = true
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_trees -> {
                    if (!selector) {
                        navView.menu.findItem(R.id.nav_binary_trees).isVisible = false
                        navView.menu.findItem(R.id.nav_trees)
                            .setIcon(R.drawable.baseline_arrow_drop_down)
                        selector = true
                    } else {
                        navView.menu.findItem(R.id.nav_binary_trees).isVisible = true
                        navView.menu.findItem(R.id.nav_trees)
                            .setIcon(R.drawable.baseline_arrow_drop_up)
                        selector = false
                    }

                }

                R.id.nav_binary_trees -> {
                    navController.navigate(R.id.nav_binary_trees)
                    drawerLayout.closeDrawers()
                }

                R.id.nav_queues -> {
                    navController.navigate(R.id.nav_queues)
                    drawerLayout.closeDrawers()
                }

                R.id.nav_stack -> {
                    navController.navigate(R.id.nav_stack)
                    drawerLayout.closeDrawers()
                }

                R.id.nav_home -> {
                    navController.navigate(R.id.nav_home)
                    drawerLayout.closeDrawers()
                }
            }
            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}