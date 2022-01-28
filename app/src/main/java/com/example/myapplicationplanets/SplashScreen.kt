package com.example.myapplicationplanets
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        ic_saturn.alpha = 0f
        ic_saturn.animate().setDuration(2500).alpha(1f).withEndAction{
            val dawyeba = Intent(this, PlanetRecycleActivity::class.java)
            startActivity(dawyeba)
            finish()

        }



    }

}