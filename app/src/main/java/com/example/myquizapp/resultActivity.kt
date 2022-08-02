package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_page)
        val tvName: TextView=findViewById(R.id.emptyMessage)
        val tvScore:TextView=findViewById(R.id.emptyMessage1)
        val btnFinish:Button=findViewById(R.id.btn_Finish)


        tvName.text = intent.getStringExtra(Constant.USER_NAME)
        val correctAnswers =intent.getIntExtra(Constant.CORRECT_ANSWERS,0)
        val totalQuestions = intent.getIntExtra(Constant.TOTAL_QUESTIONS,0)
        tvScore.text= "Your Final Score Is $correctAnswers out of $totalQuestions"
        btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}