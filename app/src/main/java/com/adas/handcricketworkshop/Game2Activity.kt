package com.adas.handcricketworkshop

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.adas.handcricketworkshop.databinding.ActivityGame2Binding

class Game2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityGame2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game2)
    }
}