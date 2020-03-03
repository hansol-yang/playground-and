package com.engflip.www.playgroundand.ui.quiz.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.engflip.www.playgroundand.R
import com.engflip.www.playgroundand.ui.base.BaseFragment
import com.engflip.www.playgroundand.ui.quiz.QuizPlayActivity
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_can_submit.*

class CanSubmitFragment : BaseFragment() {
    private lateinit var listener: Listener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is QuizPlayActivity) {
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_can_submit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        button_submit
            .clicks()
            .subscribeBy {
                listener.onSubmit()
            }
            .addTo(disposables)
    }

    interface Listener {
        fun onSubmit()
    }
}