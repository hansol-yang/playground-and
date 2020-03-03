package com.engflip.www.playgroundand.ui.quiz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.engflip.www.playgroundand.R
import com.engflip.www.playgroundand.model.QuizMode
import com.engflip.www.playgroundand.ui.base.BaseActivity
import com.engflip.www.playgroundand.ui.quiz.fragment.CanSubmitFragment
import com.engflip.www.playgroundand.ui.quiz.fragment.QuizPlayFragment
import com.engflip.www.playgroundand.ui.quiz.fragment.QuizResultFragment

fun Context.getQuizPlayActivityIntent(quizMode: QuizMode): Intent =
    Intent(this, QuizPlayActivity::class.java).apply {
        putExtra(getString(R.string.extra_quiz_mode), quizMode)
    }

class QuizPlayActivity : BaseActivity(), CanSubmitFragment.Listener {
    private val quizMode: QuizMode by lazy {
        intent.getParcelableExtra<QuizMode>(getString(R.string.extra_quiz_mode))
            ?: throw IllegalStateException("quizMode 는 필수값 입니다")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_play)

        println(quizMode)
        setFragment(QuizPlayFragment(), getString(R.string.quiz_play))
    }

    override fun onSubmit() {
        setFragment(QuizResultFragment(), getString(R.string.quiz_result))
    }

    private fun setFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction().run {
            replace(R.id.layout_fragment, fragment, tag)
            commitAllowingStateLoss()
        }
    }
}