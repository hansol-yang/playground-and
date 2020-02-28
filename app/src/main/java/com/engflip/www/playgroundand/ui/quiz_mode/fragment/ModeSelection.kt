package com.engflip.www.playgroundand.ui.quiz_mode.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import com.engflip.www.playgroundand.R
import com.engflip.www.playgroundand.ui.base.BaseFragment
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.Observable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_quiz_mode_selection.*

class ModeSelection : BaseFragment() {
    private val mode: SparseArrayCompat<Boolean> = SparseArrayCompat()

    init {
        mode.put(SELECT_WORD, false)
        mode.put(SELECT_MEANING, false)
        mode.put(SPELLING, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz_mode_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        val selectWord = checkbox_select_word.clicks().map { SELECT_WORD }
        val selectMeaning = checkbox_select_meaning.clicks().map { SELECT_MEANING }
        val spelling = checkbox_spelling.clicks().map { SPELLING }
        Observable
            .merge(selectWord, selectMeaning, spelling)
            .subscribeBy {
                val before = mode[it]!!
                mode.replace(it, !before)
            }
            .addTo(disposables)

        button_play
            .clicks()
            .subscribeBy {
                println(mode)
            }
            .addTo(disposables)
    }

    companion object {
        private const val SELECT_WORD = 0
        private const val SELECT_MEANING = 1
        private const val SPELLING = 2
    }
}