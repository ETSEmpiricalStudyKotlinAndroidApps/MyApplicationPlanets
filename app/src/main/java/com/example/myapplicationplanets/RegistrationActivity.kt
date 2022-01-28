package com.example.myapplicationplanets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {
    private lateinit var registemail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextPassword2: EditText
    private lateinit var buttonregister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        init()
        signupListeners()
    }

    private fun init() {
        registemail = findViewById(R.id.registemail)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextPassword2 = findViewById(R.id.editTextPassword2)
        buttonregister = findViewById(R.id.buttonregister)
    }

    private fun signupListeners() {
        buttonregister.setOnClickListener {
            val email = registemail.text.toString()
            val password = editTextPassword.text.toString()
            val repeatpassword = editTextPassword2.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                Toast.makeText(this, "Password Is Empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (repeatpassword.isEmpty()) {
                Toast.makeText(this, "Confirm Password Is Empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if (password.equals(repeatpassword)){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                        task ->
                    if(task.isSuccessful){
                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()


                    }
                }


            }
            else if (!password.equals(repeatpassword)) {
                Toast.makeText(this, "passwords do not match!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener }

        }
    }
}



