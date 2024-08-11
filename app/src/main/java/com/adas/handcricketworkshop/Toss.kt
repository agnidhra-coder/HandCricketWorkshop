package com.adas.handcricketworkshop

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.adas.handcricketworkshop.databinding.ActivityTossBinding

class Toss : AppCompatActivity() {
    private lateinit var binding: ActivityTossBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTossBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.batButton.setOnClickListener {
            callIntent("Batting")
        }

        binding.bowlButton.setOnClickListener {
            callIntent("Bowling")
        }

    }

    fun callIntent(toss: String) {
        val i = Intent(this , Game1Activity::class.java)
        i.putExtra("toss" , toss)
        startActivity(i)
    }
}