package com.example.octaveapptwo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.octaveapptwo.databinding.ActivityProfileBinding

const val GOT_PROFILE_NAME = "com.example.octaveapptwo.profile_name"

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    private var profileName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        profileName =intent.getStringExtra(GOT_PROFILE_NAME).toString()

        binding.profilePic.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_background))

        binding.profileName.setText(profileName)
    }

    companion object {
        fun newIntent(packageContext: Context, profileName: String) : Intent {
            return Intent(packageContext, ProfileActivity::class.java).apply{
                putExtra(GOT_PROFILE_NAME, profileName)
            }
        }
    }
}