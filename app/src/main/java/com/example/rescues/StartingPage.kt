package com.example.rescues

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.startingpage)

        val agencyforwardbutton = findViewById<Button>(R.id.agencyforward_button)
        agencyforwardbutton.setOnClickListener{

            val intent1 = Intent(this, LoginActivity::class.java)
            startActivity(intent1)
        }


        val userforwardbutton = findViewById<Button>(R.id.userforward_button)
        userforwardbutton.setOnClickListener{

            val intent1 = Intent(this, LoginActivity3::class.java)
            startActivity(intent1)
        }
    }
}