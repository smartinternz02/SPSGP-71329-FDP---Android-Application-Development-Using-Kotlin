package com.example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.nfc.tech.TagTechnology
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener { // implementing the view on Click Listener.
    //is going to allow us to click on to items inside of it and we can now implement the members.

    //so what we can do is we can now hover over it and implement the on click method.
    //So you see there is this override fun on click(Line 122) where we get a view and then we can do something in here.
    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mUserName : String? = null
    private var mCorrectAnswers:Int=0


    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var tvImage: ImageView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var btnSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        //Log.i("QuestionsList size is","${questionsList.size}") //This Just display whatever you'll white in the logcat.
        var textEmpty: TextView
        var textMessage = intent.getStringExtra("Name")
        textEmpty = findViewById(R.id.emptyMessage)
        textEmpty.text = textMessage + "'s Quiz"
        progressBar = findViewById(R.id.tv_progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        tvOptionOne = findViewById(R.id.optionOne)
        tvOptionTwo = findViewById(R.id.optionTwo)
        tvOptionThree = findViewById(R.id.optionThree)
        tvOptionFour = findViewById(R.id.optionFour)
        tvImage = findViewById(R.id.tv_QuizImage)
        btnSubmit = findViewById(R.id.btn_submit)
        mUserName = intent.getStringExtra(Constant.USER_NAME)


        //we are basically exporting the onclick what should happen once we click on it by setting the on
        //click listener here, by making sure we have this view onClickListener here, and by implementing
        //this on click method with the different options in line 136.
        tvOptionOne?.setOnClickListener(this)//Line 136 for Explaination.
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constant.getQuestions()
        setQuestion()
        defaultOptionsView()

    }

    private fun setQuestion() {
        defaultOptionsView()
        //  for (i in questionsList) {
        //    Log.e("Questions", i.question)
        //}
        val questionT: Question = mQuestionList!![mCurrentPosition - 1]
        tvImage?.setImageResource(questionT.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = questionT.question
        tvOptionOne?.text = questionT.optionOne
        tvOptionTwo?.text = questionT.optionTwo
        tvOptionThree?.text = questionT.optionThree
        tvOptionFour?.text = questionT.optionFour
        if (mCurrentPosition == mQuestionList!!.size) {
            btnSubmit?.text = "FINISH"
        } else {
            btnSubmit?.text = "SUBMIT"
        }
    }

    // From Below function we set the defaukt background of the text views of the option i.e. all the options expect the option which get selecetd

    //a function to set the default options view when the new position is loaded or when the answer is
    //re selected. So it's going to reset basically this the colors of the selected answers and then we can just set is to be gray.
    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        //because option one is a nullable thats why i need to use this let statement and I can now add this option to the options.
        tvOptionOne?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }

        for (optio in options) {
            optio.setTextColor(Color.parseColor("#2b2d42"))//setting the color of thr option hard-coding it.
            optio.typeface =
                Typeface.DEFAULT  //Colours will be changed once its selected by the surface
            //set the typeface. So I'm going to set the typeface to be default again and because I want to change it once it's selected.(Refer to Line 129 & 130)
            optio.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
            // above the background for this text view,should be gotten from our context compat.
            // first of all I need to pass in the context and then I can say where the file is that I want to use and I want to use the default options port of BG
           // Basically we are setting the background of each textView back to default
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) { //a method that will allow us to display the selected option.


        defaultOptionsView()//we reset all of the options to be gray again. You'll need this line near Line 200 approximately.
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))//Setting the color of the selected option.
       //below it Sets the typeface and style in which the text should be displayed fake bold, italic or whatever style you specify.


        tv.setTypeface(tv.typeface, Typeface.BOLD) // we had to add this option typeface default here as well in our default
        // options view method. Otherwise it would just stay bold after we have clicked on it and everything would be bold at one point
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_background)
    }
//this override fun onClick where we get a view when we click on any of the view we're setting up all the option views
    // you can also say we're making these views clickable.

    // For making these views clickable and to perform certain operations that we need to have
// we'll also have to set onClick Listener for all the buttons which we did in line 57
    override fun onClick(view: View?) { //2:57 video 108.
        when (view?.id) {
            R.id.optionOne -> {
                tvOptionOne?.let {

                    selectedOptionView(it, 1)
                }
            }
            R.id.optionTwo -> {
                tvOptionTwo?.let {

                    selectedOptionView(it, 2)
                }
            }
            R.id.optionThree -> {
                tvOptionThree?.let {

                    selectedOptionView(it, 3)
                }
            }
            R.id.optionFour -> {
                tvOptionFour?.let {

                    selectedOptionView(it, 4)
                }


            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else->{ //(->)lambda expression used while handling nullables.
                             val intent = Intent(this,resultActivity::class.java)
                            intent.putExtra(Constant.USER_NAME,mUserName)
                            intent.putExtra(Constant.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constant.TOTAL_QUESTIONS,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else{
                    val question = mQuestionList!![mCurrentPosition-1]//this will just give me the question that fits to the current question that I'm at
                    if (question!!.correctOptionL!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctOptionL,R.drawable.correct_option_border_bg)
                }
                if(mCurrentPosition == mQuestionList!!.size){
                   btnSubmit?.text = "Finish"
                }else{
                    btnSubmit?.text="GO TO NEXT QUESTION"
                }
                mSelectedOptionPosition=0//set back the selected option position to zero,
                //because otherwise we will always stay at the current selected option and we will get errors where the app will not behave as we want it to.
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this, drawableView
                )

            }
            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
}