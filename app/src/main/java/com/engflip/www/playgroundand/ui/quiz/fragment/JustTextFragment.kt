package com.engflip.www.playgroundand.ui.quiz.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.engflip.www.playgroundand.R
import com.engflip.www.playgroundand.databinding.FragmentJustTextBinding
import com.engflip.www.playgroundand.ui.base.BaseFragment

class JustTextFragment : BaseFragment() {
    private lateinit var binding: FragmentJustTextBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJustTextBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.idx = arguments?.getInt(IDX) ?: return
    }

    companion object {
        fun newInstance(idx: Int): JustTextFragment {
            return JustTextFragment().apply {
                val args = Bundle()
                args.putInt(IDX, idx)
                arguments = args
            }
        }

        private const val IDX = "IDX"
    }
}