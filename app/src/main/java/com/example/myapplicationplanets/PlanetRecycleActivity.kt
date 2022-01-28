package com.example.myapplicationplanets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_planet_recycle.*


class PlanetRecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_recycle)

        planetRecycle.adapter=Adapter(SetData.SetPlanets())
        planetRecycle.layoutManager=LinearLayoutManager(this)
    }
}