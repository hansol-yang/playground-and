package com.engflip.www.playgroundand.ui.store_state

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.engflip.www.playgroundand.ui.store_state.fragment.UserInfoFragment

class UsersPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
    private var fragments: List<UserInfoFragment> = emptyList()

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    fun setFragments(fragments: List<UserInfoFragment>) {
        this.fragments = fragments
        notifyDataSetChanged()
    }
}