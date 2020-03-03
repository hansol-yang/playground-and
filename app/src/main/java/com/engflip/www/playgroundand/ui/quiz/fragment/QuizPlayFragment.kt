package com.engflip.www.playgroundand.ui.quiz.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.engflip.www.playgroundand.R
import com.engflip.www.playgroundand.ui.base.BaseFragment
import com.engflip.www.playgroundand.ui.quiz.QuizAdapter
import kotlinx.android.synthetic.main.fragment_quiz_play.*

class QuizPlayFragment : BaseFragment() {
    private val intRange = 0 until 10

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz_play, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        vp_quiz.run {
            adapter = QuizAdapter(childFragmentManager)

            val fragments = intRange.map {
                if (it == 9) {
                    CanSubmitFragment()
                } else {
                    JustTextFragment.newInstance(it)
                }
            }
            (adapter as? QuizAdapter)?.setFragments(fragments)
        }
    }
}