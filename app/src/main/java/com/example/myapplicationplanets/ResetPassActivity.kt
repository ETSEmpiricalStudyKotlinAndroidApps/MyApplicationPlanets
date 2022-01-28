package com.example.myapplicationplanets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ResetPassActivity : AppCompatActivity() {
    private lateinit var resetmail: EditText
    private lateinit var resetbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pass)
        init()
        registerListeners()
    }
    private fun init() {
        resetbutton = findViewById(R.id.resetbutton)
        resetmail = findViewById(R.id.resetmail)
    }

    private fun registerListeners() {
        resetbutton.setOnClickListener {
            val email = resetmail.text.toString()

            if (email.isEmpty()){
                Toast.makeText(this, "IT IS EMPTY!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "CHECK YOUR EMAIL!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }else {
                    Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                }
            }


        }
    }


}