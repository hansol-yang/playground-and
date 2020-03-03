package com.engflip.www.playgroundand.ui.quiz

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class QuizAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private var fragments: List<Fragment> = emptyList()

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    fun setFragments(fragments: List<Fragment>) {
        this.fragments = fragments
        notifyDataSetChanged()
    }
}