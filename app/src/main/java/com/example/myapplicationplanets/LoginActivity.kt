package com.example.myapplicationplanets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var mail: EditText
    private lateinit var paroli: EditText
    private lateinit var login: Button
    private lateinit var register: Button
    private lateinit var forgotpass: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        registerListeners()
    }
    private fun init() {
        mail = findViewById(R.id.mail)
        paroli= findViewById(R.id.paroli)
        login= findViewById(R.id.login)
        register= findViewById(R.id.register)
        forgotpass= findViewById(R.id.forgotpass)





    }

    private fun registerListeners() {
        register.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
        forgotpass.setOnClickListener {
            startActivity(Intent(this, ResetPassActivity::class.java ))
        }


        login.setOnClickListener {
            val email = mail.text.toString()
            val password = paroli.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, "E-mail IS EMPTY!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.isEmpty()){
                Toast.makeText(this, "Password IS EMPTY!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener{task ->
                if (task.isSuccessful) {
                    gotoPlanetRecycle()

                }else {
                    Toast.makeText(this, "SOMETHING WENT WRONG!", Toast.LENGTH_SHORT ).show()
                }
            }
        }
    }
    private fun gotoPlanetRecycle() {
        startActivity(Intent(this, SplashScreen::class.java))
    }
}


