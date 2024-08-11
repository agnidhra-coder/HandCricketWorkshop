package com.adas.handcricketworkshop

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.adas.handcricketworkshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var playerName = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            playerName = binding.nameEditText.text.toString()
            if(playerName == "")
                Toast.makeText(this , "Invalid name" , Toast.LENGTH_SHORT).show()
            else {
                val i = Intent(this, Toss::class.java)
                startActivity(i)
            }
        }

    }
}