
package com.example.rescues

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.rescues.databinding.ActivityMainnBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ActivityMainn : AppCompatActivity() {

    private lateinit var binding: ActivityMainnBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainnBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener {

            val agencyName = binding.firstName.text.toString()
            val address = binding.lastName.text.toString()
            val contactNo = binding.age.text.toString()
            val userName = binding.userName.text.toString()

            if (agencyName.isNotEmpty() && address.isNotEmpty() && contactNo.isNotEmpty()&& userName.isNotEmpty()) {

                database = FirebaseDatabase.getInstance().getReference("Users")
                val User = User(agencyName, address, contactNo, userName)
                database.child(userName).setValue(User).addOnSuccessListener {

                    binding.firstName.text.clear()
                    binding.lastName.text.clear()
                    binding.age.text.clear()
                    binding.userName.text.clear()


                    Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()
                    if(1==1){

                        binding.registerBtn.setOnClickListener{

                            val intent1 = Intent(this, UpdateData::class.java)
                            startActivity(intent1)
                        }
                    }

                }.addOnFailureListener {

                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()


                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }

        }
        val agencyforwardbutton = findViewById<Button>(R.id.registerBtn1)
        agencyforwardbutton.setOnClickListener{

            val intent1 = Intent(this, ActivityPdf::class.java)
            startActivity(intent1)
        }

    }

    data class User(val agencyName : String? = null,val address : String? = null,val contactNo : String? = null,val userName : String? = null){

    }
}