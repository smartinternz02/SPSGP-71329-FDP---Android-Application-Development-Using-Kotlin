package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myquizapp.QuizQuestionsActivity as QuizQuestionsActivity

//Manifest File => In this file you do the setup for the diffrent
//activites that you have, You define which activity is going to be the starting activity.
// When you open up the app whuch activity should be displayed
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_start: Button = findViewById(R.id.btn_start)
        val et_name: EditText = findViewById(R.id.et_name) //The Text which you can edit again and again
        // Example -> entering the name in the card view again and again because thats an edit text
        btn_start.setOnClickListener {
            if (et_name.text.isEmpty()) {
                Toast.makeText(this, "Please Enter Your Name First.", Toast.LENGTH_LONG).show()
            }
            else {
                var message = et_name.text.toString()
                val intent = Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(Constant.USER_NAME,message)
                intent.putExtra("Name",message)
                startActivity(intent)
            }
            }
        }
    }
