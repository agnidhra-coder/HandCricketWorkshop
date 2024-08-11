package com.adas.handcricketworkshop

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.adas.handcricketworkshop.databinding.ActivityGame1Binding
import com.google.android.material.button.MaterialButton
import kotlin.random.Random

class Game1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityGame1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGame1Binding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val toss = intent.getStringExtra("toss")
        binding.textView1.text = toss

        val arrayOfButtons = arrayOf(binding.button1 , binding.button2 , binding.button3 , binding.button4 , binding.button5 , binding.button6)

        binding.button1.setOnClickListener{
            updateScore(1 , toss!! , arrayOfButtons)
        }
        binding.button2.setOnClickListener{
            updateScore(2 , toss!! , arrayOfButtons)
        }
        binding.button3.setOnClickListener{
            updateScore(3 , toss!! , arrayOfButtons)
        }
        binding.button4.setOnClickListener{
            updateScore(4 , toss!! , arrayOfButtons)
        }
        binding.button5.setOnClickListener{
            updateScore(5 , toss!! , arrayOfButtons)
        }
        binding.button6.setOnClickListener{
            updateScore(6 , toss!! , arrayOfButtons)
        }

        binding.nextButton.setOnClickListener {
            val i = Intent(this , Result1Activity::class.java)
            val totalScoreAndToss = arrayOf(binding.totalScoreTextView.text.toString() , toss)
            i.putExtra("totalScoreAndToss" , totalScoreAndToss)
            startActivity(i)
        }

    }

    fun updateScore(currentPlayerValue: Int , toss: String , arrayOfButtons: Array <MaterialButton>) {
        var currentCPUValue = Random.nextInt(1 , 7)
        var toastMessage = if(toss == "Batting") "You are OUT!" else "CPU is OUT!"
        binding.playerTextView.text = currentPlayerValue.toString()
        binding.cpuTextView.text = currentCPUValue.toString()
        if(currentCPUValue == currentPlayerValue) {
            disableButtons(arrayOfButtons)
            Toast.makeText(this , toastMessage , Toast.LENGTH_SHORT).show()
            binding.nextButton.visibility = View.VISIBLE
        }
        else {
            binding.totalScoreTextView.text = if(toss == "Batting")
                (binding.totalScoreTextView.text.toString().toInt() + currentPlayerValue).toString()
            else (binding.totalScoreTextView.text.toString().toInt() + currentCPUValue).toString()
        }
    }

    fun disableButtons(arrayOfButtons: Array <MaterialButton>) {
        for(i in 0 until 6) {
            arrayOfButtons[i].isEnabled = false
        }
    }
}