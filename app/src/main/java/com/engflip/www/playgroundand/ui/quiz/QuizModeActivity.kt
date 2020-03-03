package com.engflip.www.playgroundand.ui.quiz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.engflip.www.playgroundand.R
import com.engflip.www.playgroundand.model.QuizMode
import com.engflip.www.playgroundand.ui.base.BaseActivity
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_quiz_mode.*


fun Context.getQuizModeActivityIntent(): Intent = Intent(this, QuizModeActivity::class.java)

class QuizModeActivity : BaseActivity() {
    private val quizMode = QuizMode()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_mode)

        setupViews()
    }

    private fun setupViews() {
        checkbox_select_word
            .clicks()
            .subscribeBy { quizMode.selectWord = !quizMode.selectWord }
            .addTo(disposables)

        checkbox_select_meaning
            .clicks()
            .subscribeBy { quizMode.selectMeaning = !quizMode.selectMeaning }
            .addTo(disposables)

        checkbox_spelling
            .clicks()
            .subscribeBy { quizMode.spelling = !quizMode.spelling }
            .addTo(disposables)

        button_play
            .clicks()
            .subscribeBy {
                startActivity(getQuizPlayActivityIntent(quizMode))
            }
            .addTo(disposables)
    }
}
