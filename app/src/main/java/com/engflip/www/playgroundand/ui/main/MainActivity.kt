package com.engflip.www.playgroundand.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.engflip.www.playgroundand.R
import com.engflip.www.playgroundand.ui.attrs_with_databinding.getAttrsWithDataBindingActivityIntent
import com.engflip.www.playgroundand.ui.base.BaseActivity
import com.engflip.www.playgroundand.ui.dynamic_lines.getDynamicLinesActivityIntent
import com.engflip.www.playgroundand.ui.quiz_mode.getQuizPlayerActivityIntent
import com.engflip.www.playgroundand.ui.store_state.getStoreStateActivityIntent
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*

fun Context.getMainActivityIntent(): Intent = Intent(this, MainActivity::class.java)

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
    }

    private fun setupViews() {
        button_store_ui_state
            .clicks()
            .subscribeBy {
                startActivity(getStoreStateActivityIntent())
            }
            .addTo(disposables)

        button_attrs_with_databinding
            .clicks()
            .subscribeBy {
                startActivity(getAttrsWithDataBindingActivityIntent())
            }
            .addTo(disposables)

        button_dynamic_lines
            .clicks()
            .subscribeBy {
                startActivity(getDynamicLinesActivityIntent())
            }
            .addTo(disposables)

        button_quiz_mode_flow
            .clicks()
            .subscribeBy {
                startActivity(getQuizPlayerActivityIntent())
            }
            .addTo(disposables)
    }
}