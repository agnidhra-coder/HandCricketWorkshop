package com.adas.handcricketworkshop

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.adas.handcricketworkshop.databinding.ActivityGame2Binding
import com.adas.handcricketworkshop.databinding.ActivityResult1Binding
import com.google.android.material.button.MaterialButton
import kotlin.random.Random

class Game2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityGame2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGame2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getStringArrayExtra("totalScoreAndToss")
        val toss = result!![0].toString()

        binding.textView1.text = toss
        val target= result[1].toInt()

        val arrayOfButtons = arrayOf(binding.button1 , binding.button2 , binding.button3 , binding.button4 , binding.button5 , binding.button6)

        binding.button1.setOnClickListener{
            updateScore(1 , toss!! , arrayOfButtons,target)
        }
        binding.button2.setOnClickListener{
            updateScore(2 , toss!! , arrayOfButtons,target)
        }
        binding.button3.setOnClickListener{
            updateScore(3 , toss!! , arrayOfButtons,target)
        }
        binding.button4.setOnClickListener{
            updateScore(4 , toss!! , arrayOfButtons,target)
        }
        binding.button5.setOnClickListener{
            updateScore(5 , toss!! , arrayOfButtons,target)
        }
        binding.button6.setOnClickListener{
            updateScore(6 , toss!! , arrayOfButtons,target)
        }

        binding.nextButton.setOnClickListener {
            val i = Intent(this , Result2Activity::class.java)
            val totalScoreAndToss = arrayOf(binding.totalScoreTextView.text.toString() , (target-1).toString(), toss)
            i.putExtra("totalScoreAndToss" , totalScoreAndToss)
            startActivity(i)
        }

    }

    fun updateScore(currentPlayerValue: Int , toss: String , arrayOfButtons: Array <MaterialButton>, target: Int) {
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

        if ( binding.totalScoreTextView.text.toString().toInt()>=target){
            disableButtons(arrayOfButtons)
            Toast.makeText(this,"Game Over",Toast.LENGTH_SHORT).show()

            binding.nextButton.visibility = View.VISIBLE
        }
    }

    fun disableButtons(arrayOfButtons: Array <MaterialButton>) {
        for(i in 0 until 6) {
            arrayOfButtons[i].isEnabled = false
        }
    }
}