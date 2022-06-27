package com.sum.capstoneproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.sum.capstoneproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNav = binding.bottomNavigationView
        setSupportActionBar(binding.toolbar)//Toolbar

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        bottomNav.setupWithNavController(navController)
        // setupActionBarWithNavController(navController)

        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment,
                R.id.loginFragment,
                R.id.shopFragment,
                R.id.bagFragment,
                R.id.favoriFragment,
                R.id.successFragment)  // bu kısımda hangi sayfalarda görünmesini istemiyorum kısmı
        )
        binding.toolbar.setupWithNavController(
            navController,
            appBarConfiguration)


        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment -> bottomNav.visibility = View.INVISIBLE
                R.id.registerFragment -> bottomNav.visibility = View.INVISIBLE
                R.id.forgotPasswordFragment -> bottomNav.visibility = View.INVISIBLE

                else -> {
                    bottomNav.visibility = View.VISIBLE


                }
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        applicationContext
        findNavController(R.id.fragment).popBackStack()
        return true
    }


}