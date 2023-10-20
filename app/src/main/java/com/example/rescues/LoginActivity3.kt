package com.example.rescues


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rescues.databinding.ActivityLogin2Binding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityLogin2Binding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth = FirebaseAuth.getInstance()

        binding.loginButton2.setOnClickListener {
            val email = binding.loginemail2.text.toString()
            val pass = binding.loginpassword2.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, UserPage::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
        binding.textviewsignup2.setOnClickListener {
            val signupIntent = Intent(this, SignUpActivity2::class.java)
            startActivity(signupIntent)
        }
        binding.textviewotp.setOnClickListener {
            val signupIntent = Intent(this, PhoneActivity::class.java)
            startActivity(signupIntent)
        }

        fun onStart() {
            super.onStart()

            if (firebaseAuth.currentUser != null) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}