package com.hfad.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hfad.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.enterButton.setOnClickListener {
            val firstName = binding.firstName.text.toString().trim()
            val lastName = binding.lastName.text.toString().trim()
            if (firstName.isNotEmpty() && lastName.isNotEmpty()) {
                binding.greetingsDisplay.text =
                    "${getString(R.string.welcome_to_the_app)} $firstName $lastName"
            } else {
                Toast.makeText(this, R.string.please_enter_a_name, Toast.LENGTH_LONG).show()
            }
        }
    }
}