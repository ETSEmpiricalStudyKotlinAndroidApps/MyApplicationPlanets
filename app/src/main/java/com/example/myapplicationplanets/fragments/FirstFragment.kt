package com.example.myapplicationplanets.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.myapplicationplanets.LoginActivity
import com.example.myapplicationplanets.R
import com.example.myapplicationplanets.models.UserInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val user = view.findViewById<TextView>(R.id.user)
        val userphoto = view.findViewById<EditText>(R.id.userphoto)
        val username = view.findViewById<EditText>(R.id.username)
        val logout = view.findViewById<Button>(R.id.logout)
        val button2 = view.findViewById<Button>(R.id.button2)
        val db = FirebaseDatabase.getInstance().getReference("UserInfo")
        val auth = FirebaseAuth.getInstance()
        db.child(auth.currentUser?.uid!!).addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val userInfo:UserInfo = snapshot.getValue(UserInfo::class.java)?:return
                user.text = userInfo.name
                Glide.with(this@FirstFragment)
                    .load(userInfo.imageUrl).placeholder(R.drawable.ic_launcher_foreground).into(imageView)

            }

            override fun onCancelled(error: DatabaseError) {
            }

        })

        button2.setOnClickListener {

            val name = username.text.toString()
            val imageUrl = userphoto.text.toString()

            if (name.isEmpty() || imageUrl.isEmpty()) {
                return@setOnClickListener
            }


            val userInfo = UserInfo(name, imageUrl)
            db.child(auth.currentUser?.uid!!)
                .setValue(userInfo)





        }
        logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(activity, LoginActivity::class.java))
            activity?.finish()
        }

    }


}