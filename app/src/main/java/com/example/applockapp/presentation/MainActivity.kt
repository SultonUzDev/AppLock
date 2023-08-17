package com.example.applockapp.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.applockapp.R
import com.example.applockapp.service.AppLockAccessibilityService

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment

        navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.main_navigation)
        if (AppLockAccessibilityService.isRunService) {
            navGraph.setStartDestination(R.id.mainFragment)

        } else {
            navGraph.setStartDestination(R.id.onBoardFragment)

        }

        navController.graph = navGraph


    }

    override fun onNavigateUp(): Boolean {
        return findNavController(R.id.main_container).navigateUp() or super.onNavigateUp()
    }


}