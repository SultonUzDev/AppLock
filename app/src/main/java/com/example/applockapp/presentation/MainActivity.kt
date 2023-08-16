package com.example.applockapp.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.applockapp.R

class MainActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onNavigateUp(): Boolean {
        return findNavController(R.id.main_container).navigateUp() or super.onNavigateUp()
    }


}