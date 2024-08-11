package com.adas.handcricketworkshop

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.adas.handcricketworkshop.databinding.ActivityGame2Binding
import com.adas.handcricketworkshop.databinding.ActivityResult2Binding

class Result2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityResult2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResult2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getStringArrayExtra("totalScoreAndToss")
        val toss = result!![2].toString()

        val yourScore = if (toss=="Bowling") result[1] else result[0]
        val cpuScore = if (toss=="Bowling") result[0] else result[1]

        binding.yourScore.text= yourScore.toString()
        binding.cpuscore.text= cpuScore.toString()

        val matchResult = if(yourScore.toInt() == cpuScore.toInt()) "Wow! It's a DRAW!"
        else if(yourScore.toInt() < cpuScore.toInt()) "Uh-oh! You LOST!!"
        else "Hooray! You WON!"

        binding.resultView.text = matchResult

        binding.menu.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
}