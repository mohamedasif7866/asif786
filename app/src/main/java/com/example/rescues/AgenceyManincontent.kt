package com.example.rescues

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AgenceyManincontent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agenceymaincontent)


        val earthquakebutton = findViewById<Button>(R.id.earth_button)
        earthquakebutton.setOnClickListener {

            val intent1 = Intent(this, ReadData::class.java)
            startActivity(intent1)
        }
        val ag = findViewById<Button>(R.id.ag_button)
        ag.setOnClickListener {

            val intent1 = Intent(this, ReadData::class.java)
            startActivity(intent1)
        }
        val ag2 = findViewById<Button>(R.id.ag2_button)
        ag2.setOnClickListener {

            val intent1 = Intent(this, ReadData::class.java)
            startActivity(intent1)
        }
        val ag3 = findViewById<Button>(R.id.ag3_button)
        ag3.setOnClickListener {

            val intent1 = Intent(this, ReadData::class.java)
            startActivity(intent1)
        }
        val ag4 = findViewById<Button>(R.id.ag4_button)
        ag4.setOnClickListener {

            val intent1 = Intent(this, ReadData::class.java)
            startActivity(intent1)
        }
        val ag5 = findViewById<Button>(R.id.ag5_button)
        ag5.setOnClickListener {

            val intent1 = Intent(this, ReadData::class.java)
            startActivity(intent1)
        }
        val ag6 = findViewById<Button>(R.id.ag6_button)
        ag6.setOnClickListener {

            val intent1 = Intent(this, ReadData::class.java)
            startActivity(intent1)
        }
        val ag7 = findViewById<Button>(R.id.ag7_button)
        ag7.setOnClickListener {

            val intent1 = Intent(this, ReadData::class.java)
            startActivity(intent1)
        }
    }
}