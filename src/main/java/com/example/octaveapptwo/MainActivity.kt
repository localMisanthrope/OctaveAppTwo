package com.example.octaveapptwo

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.octaveapptwo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val profileVM: ProfileViewModel by viewModels()

    private val realUser = "enterSandman1001"
    private val realPass = "password123"

    private val profileLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode == Activity.RESULT_OK){
        }
    }

    private fun checkLogin(username: String, password: String) : Boolean{
        return (username == realUser && password == realPass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener{
            val user = binding.username.text.toString()
            val pass = binding.password.text.toString()

            val correct = checkLogin(user, pass)

            if (correct){
                Toast.makeText(this, "Login Accepted!", Toast.LENGTH_SHORT).show()
                val intent = ProfileActivity.newIntent(this@MainActivity, realUser)
                profileLauncher.launch(intent)
            }

            else {
                Toast.makeText(this, "Login Denied!", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) {v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}