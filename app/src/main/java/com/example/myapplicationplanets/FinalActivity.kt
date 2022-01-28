package com.example.myapplicationplanets


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplicationplanets.fragments.FirstFragment


class FinalActivity : AppCompatActivity() {
    private lateinit var name:TextView
    private lateinit var name2:TextView
    private lateinit var name3:TextView
    private lateinit var name4:TextView
    private lateinit var name5:TextView
    private lateinit var name6:TextView
    private lateinit var done:Button






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        window.decorView.apply { systemUiVisibility=
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN}
        init()
        donelisteners()






    }
    private fun init(){
        name = findViewById(R.id.name)
        name2 = findViewById(R.id.name2)
        name3 = findViewById(R.id.name3)
        name4 = findViewById(R.id.name4)
        name5 = findViewById(R.id.name5)
        name6 = findViewById(R.id.name6)
        done = findViewById(R.id.done)

    }
    private fun donelisteners() {
        done.setOnClickListener {
            if (TextUtils.isEmpty(name.text.toString()) && TextUtils.isEmpty(name2.text.toString()) && TextUtils.isEmpty(name3.text.toString()) && TextUtils.isEmpty(name4.text.toString()) && TextUtils.isEmpty(name6.text.toString())){
                Toast.makeText(this, "ERROR!", Toast.LENGTH_SHORT).show()
            }
            if (TextUtils.isEmpty(name.text.toString())){
                Toast.makeText(this, "Name Is Empty", Toast.LENGTH_SHORT).show()

            }
            if (TextUtils.isEmpty(name2.text.toString())){
                Toast.makeText(this, "Email Is Empty", Toast.LENGTH_SHORT).show()
            }
            if (TextUtils.isEmpty(name3.text.toString())){
                Toast.makeText(this, "Phone Number Is Empty", Toast.LENGTH_SHORT).show()
            }
            if (TextUtils.isEmpty(name4.text.toString())){
                Toast.makeText(this, "Booking Date & Time Is Empty", Toast.LENGTH_SHORT).show()
            }
            if (TextUtils.isEmpty(name5.text.toString())){
                Toast.makeText(this, "Planet Is Empty", Toast.LENGTH_SHORT).show()
            }
            if (TextUtils.isEmpty(name6.text.toString())){
               Toast.makeText(this, "Number Of Tickets Is Empty", Toast.LENGTH_SHORT).show()
            }

            else{
                Toast.makeText(this, "You Booked Your Flight!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
            }
        }




    }






}


