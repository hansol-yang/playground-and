package com.engflip.www.playgroundand.ui.attrs_with_databinding.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.LinearLayout
import com.engflip.www.playgroundand.R
import com.engflip.www.playgroundand.extension.inflate
import kotlinx.android.synthetic.main.attrs_meaning_unit.view.*

class MeaningUnit (context: Context?, attrs: AttributeSet? = null): LinearLayout(context, attrs) {
    init {
        inflate(R.layout.attrs_meaning_unit, true)
        context?.let {
            val typedArr = it.obtainStyledAttributes(attrs, R.styleable.MeaningUnit)
            setupUI(typedArr)
        }
    }

    fun setMeaning(meaning: String) {
        println(meaning)
        text_meaning.text = meaning
    }

    private fun setupUI(typedArr: TypedArray) {
        text_meaning.text = typedArr.getString(R.styleable.MeaningUnit_meaning)
        typedArr.recycle()
    }
}