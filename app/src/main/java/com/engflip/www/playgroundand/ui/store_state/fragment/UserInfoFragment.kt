package com.engflip.www.playgroundand.ui.store_state.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.engflip.www.playgroundand.databinding.FragmentUserBinding
import com.engflip.www.playgroundand.model.User

class UserInfoFragment : Fragment() {
    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(
            inflater,
            container,
            false
        )
        binding.user = arguments?.getParcelable("USER")
        return binding.root
    }

    companion object {
        fun newInstance(user: User): UserInfoFragment {
            val fragment = UserInfoFragment()
            val args = Bundle().apply {
                putParcelable("USER", user)
            }
            fragment.arguments = args

            return fragment
        }
    }
}