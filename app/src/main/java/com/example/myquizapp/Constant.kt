package com.example.myquizapp

object Constant {
    //Whenever you send data from one activity to another, it's good to store the name under which you
    //stored the details that you want to have in a constant. So this will make a lot more sense once we get started with it.
    //(These variables are important during setting up the result activity.)
    const val USER_NAME       :String = "user_name"
    const val TOTAL_QUESTIONS :String = "total_questions"
    const val CORRECT_ANSWERS :String = "correct_answers"


    fun getQuestions():ArrayList<Question>//Creating a function which will get us the question and we can aslo call this function from the
    //quizQuestionActivity and this getQuestion return the array list of the questions
    {
        val questionsList = ArrayList<Question>()
        val que1 = Question(
           1, "Which Country's Flag is this?",R.drawable.ic_flag_of_argentina
        ,"India", "USA", "Argentina", "Wales",3
        )
        questionsList.add(que1) //Adding the question to the arrayList by using .add() function
        val que2 = Question(
            2, "Who is He?", R.drawable.unnamed
            ,"LeBron James", "Stephen Curry", "Kevin Durant", "James Harden",1
        )
        questionsList.add(que2) 
        val que3 = Question(
            3, "Who Are They?", R.drawable.gays
            ,"BTS", "One Direction", "Harry Styles", "All of the Above",4
        )
        questionsList.add(que3)
        val que4 = Question(
            4, "Which Country's Flag is This?", R.drawable.ic_flag_of_australia
            ,"England", "Netherlands", "Spain", "Australia",4
        )
        questionsList.add(que4)
        val que5= Question(
            5, "Which Country's Flag is This?", R.drawable.ic_flag_of_belgium
            ,"Palestine", "Nigeria", "Belgium", "Nepal",3
        )
        questionsList.add(que5)
        val que6 = Question(
            6, "Which Country's Flag is This?", R.drawable.ic_flag_of_brazil
            ,"Colombia", "Vatican City", "Brazil", "Monaco",3
        )
        questionsList.add(que6)
        val que7 = Question(
            7, "Which Country's Flag is This?", R.drawable.ic_flag_of_denmark
            ,"Denmark", "Vatican City", "San Marino", "Liechtenstein",1
        )
        questionsList.add(que7)
        val que8 = Question(
            8, "Which Country's Flag is This?", R.drawable.ic_flag_of_fiji
            ,"Dubai", "Pakistan", "Fiji", "Afghanistan",3
        )
        questionsList.add(que8)
        val que9 = Question(
            9, "Which Country's Flag is This?", R.drawable.ic_flag_of_india
            ,"India", "USA", "San Marino", "Liechtenstein",1
        )
        questionsList.add(que9)
        val que10 = Question(
            10, "Which Country's Flag is This?", R.drawable.ic_flag_of_germany
            ,"Nauru", "Vietnam", "Mexico", "Germany",4
        )
        questionsList.add(que10)

return questionsList
    }
}