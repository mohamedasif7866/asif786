package com.example.rescues


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rescues.databinding.ActivitySignup2Binding
import com.google.firebase.auth.FirebaseAuth


class SignUpActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivitySignup2Binding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignup2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textviewlogin2.setOnClickListener {
            val intent = Intent(this, LoginActivity3::class.java)
            startActivity(intent)
        }
        binding.signupbutton2.setOnClickListener {
            val email = binding.signupemail2.text.toString()
            val pass = binding.signuppassword2.text.toString()
            val confirmPass = binding.signupconfirm2.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, LoginActivity3::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }
                } else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
        binding.textviewlogin2.setOnClickListener {
            val loginIntent = Intent(this, LoginActivity3::class.java)
            startActivity(loginIntent)
        }
    }
}