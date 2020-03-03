package com.engflip.www.playgroundand.ui.quiz.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.engflip.www.playgroundand.R
import com.engflip.www.playgroundand.ui.base.BaseFragment

class QuizResultFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz_result, container, false)
    }
}