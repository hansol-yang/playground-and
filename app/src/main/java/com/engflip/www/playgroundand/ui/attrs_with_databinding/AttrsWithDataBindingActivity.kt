package com.engflip.www.playgroundand.ui.attrs_with_databinding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.engflip.www.playgroundand.R
import com.engflip.www.playgroundand.databinding.ActivityAttrsWithDatabindingBinding
import com.engflip.www.playgroundand.model.Quiz
import com.engflip.www.playgroundand.ui.base.BaseActivity

fun Context.getAttrsWithDataBindingActivityIntent(): Intent = Intent(this, AttrsWithDataBindingActivity::class.java)

class AttrsWithDataBindingActivity : BaseActivity() {
    private lateinit var binding: ActivityAttrsWithDatabindingBinding

    val quiz = Quiz("apple", "[ˈæpl]", listOf("사과, 사과나무", "바나나바나나바나나바나나바나나바나나바나나바나나바나나바나나", "바나나", "바나나"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_attrs_with_databinding)
        binding.quiz = quiz
    }
}