package com.example.myapplicationplanets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomnavView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val controller = findNavController(R.id.navhostview)


        val fragmentSet = setOf<Int>(
            R.id.firstFragment,
            R.id.secondFragment
        )


        setupActionBarWithNavController(controller, AppBarConfiguration(fragmentSet))
        bottomnavView.setupWithNavController(controller)
    }
}