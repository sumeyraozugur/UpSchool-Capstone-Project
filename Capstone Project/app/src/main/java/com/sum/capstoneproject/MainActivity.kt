package com.sum.capstoneproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sum.capstoneproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val bottomNav= binding.bottomNavigationView





        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        bottomNav.setupWithNavController(navController)
       // setupActionBarWithNavController(navController)

        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment, R.id.loginFragment) // bu kısımda hangi sayfalarda görünmesini istemiyorum kısmı
        )
        binding.toolbar.setupWithNavController(
            navController,
            appBarConfiguration
        )





        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {


                R.id.loginFragment -> bottomNav.visibility = View.INVISIBLE
                R.id.registerFragment -> {bottomNav.visibility =View.INVISIBLE}
                R.id.forgotPasswordFragment -> {bottomNav.visibility =View.INVISIBLE}
              

                else -> {bottomNav.visibility =View.VISIBLE


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