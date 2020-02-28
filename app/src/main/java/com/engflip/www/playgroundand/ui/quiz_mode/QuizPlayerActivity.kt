package com.engflip.www.playgroundand.ui.quiz_mode

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.engflip.www.playgroundand.R
import com.engflip.www.playgroundand.ui.base.BaseActivity

fun Context.getQuizPlayerActivityIntent(): Intent = Intent(this, QuizPlayerActivity::class.java)

class QuizPlayerActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_player)
    }
}