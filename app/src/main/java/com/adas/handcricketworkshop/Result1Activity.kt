package com.adas.handcricketworkshop

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.adas.handcricketworkshop.databinding.ActivityResult1Binding

class Result1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityResult1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResult1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentResult = intent.getStringArrayExtra("totalScoreAndToss")
        val totalScores = intentResult!![0]
        binding.totalScore.text = totalScores
        binding.target.text = (totalScores.toInt() + 1).toString()

        val toss = intentResult!![1]
        val score: Int
        binding.message.text = if(toss == "Batting") {
            "You need to defend $totalScores run" + if(totalScores.toInt() != 1) "s" else ""
        }
        else {
            "You need to chase ${binding.target.text} run" + if(binding.target.text.toString().toInt() != 1) "s" else ""
        }

        binding.next.setOnClickListener {
            val i = Intent(this , Game2Activity::class.java)
            i.putExtra("totalScoreAndToss" , arrayOf(if(toss == "Batting") "Bowling" else "Batting", binding.target.text.toString()))
            startActivity(i)
        }

    }
}