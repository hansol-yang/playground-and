package com.engflip.www.playgroundand.ui.dynamic_lines

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.size
import androidx.databinding.DataBindingUtil
import com.engflip.www.playgroundand.R
import com.engflip.www.playgroundand.databinding.ActivityDynamicLinesBinding
import com.engflip.www.playgroundand.extension.inflate
import com.engflip.www.playgroundand.model.Meaning
import com.engflip.www.playgroundand.model.QuizSpelling
import com.engflip.www.playgroundand.ui.base.BaseActivity
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

fun Context.getDynamicLinesActivityIntent(): Intent = Intent(this, DynamicLinesActivity::class.java)

class DynamicLinesActivity : BaseActivity() {
    private val quiz = QuizSpelling(Meaning("idiom.", "사실은 ( = in face)"), "as a matter of fact")

    private lateinit var binding: ActivityDynamicLinesBinding

    private lateinit var layoutLinesOfLetters: List<LinearLayout>

    private var lineCursor = 0
    private var letterCursor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dynamic_lines)
        binding.quiz = quiz

        setupViews()
        setupLinesOfLetters()
    }

    private fun setupViews() {
        with(binding) {
            buttonFill
                .clicks()
                .subscribeBy {
                    var targetLayout: LinearLayout = layoutLinesOfLetters[lineCursor]

                    if (letterCursor > targetLayout.childCount - 1) {
                        letterCursor = 0
                        lineCursor++
                        targetLayout = layoutLinesOfLetters[lineCursor]
                    }

                    val textHolder = targetLayout.getChildAt(letterCursor) as TextView
                    textHolder.text = "z"

                    if(letterCursor >= targetLayout.childCount - 1) return@subscribeBy
                    letterCursor++
                }
                .addTo(disposables)

            buttonDel
                .clicks()
                .subscribeBy { }
                .addTo(disposables)
        }
    }

    private fun setupLinesOfLetters() = with(binding) {
        layoutEditWrapper.post {
            val arrWord = splitText(this@DynamicLinesActivity.quiz.eng)
            val between = getPxValueFromDp(5f)
            val letterWidth = getPxValueFromDp(20f)
            val spaceWidth = getPxValueFromDp(20f)
            val condition = LineCalculator(
                layoutEditWrapper.width - layoutEditWrapper.paddingStart * 2,
                between
            ).calc(
                splitText(this@DynamicLinesActivity.quiz.eng),
                letterWidth,
                spaceWidth
            )

            setLayoutLinesOfLetters(condition.requiredLine)

            for (word in arrWord) {
                if (condition.breakers.contains(word)) {
                    lineCursor++
                }

                val targetLayout = layoutLinesOfLetters[lineCursor]
                attachLineOfLetters(targetLayout)

                word.forEach {
                    val textHolder =
                        targetLayout.inflate(R.layout.dynamic_text_holder, false).apply {
                            this as TextView
                            text = it.toString()
                        }
                    targetLayout.addView(textHolder)

                    textHolder.run {
                        val params = layoutParams as LinearLayout.LayoutParams
                        params.marginEnd = between
                        layoutParams = params
                    }

                }
                val lastTextHolder = targetLayout.getChildAt(targetLayout.childCount - 1)
                val params = lastTextHolder.layoutParams as LinearLayout.LayoutParams
                params.marginEnd = spaceWidth
                lastTextHolder.layoutParams = params
            }

            lineCursor = 0
        }
    }

    private fun attachLineOfLetters(targetLayout: LinearLayout) = with(binding) {
        if (layoutEditWrapper.indexOfChild(targetLayout) == -1) {
            layoutEditWrapper.addView(targetLayout)
            val params = targetLayout.layoutParams as LinearLayout.LayoutParams
            params.bottomMargin = getPxValueFromDp(10f)
            targetLayout.layoutParams = params
        }
    }

    private fun setLayoutLinesOfLetters(lines: Int) {
        val range = 0 until lines
        layoutLinesOfLetters = range.map {
            LinearLayout(this@DynamicLinesActivity).apply { gravity = Gravity.CENTER }
        }
    }

    private fun splitText(text: String): List<String> {
        return text.split(" ").filter { it.isNotEmpty() }
    }

    private fun getPxValueFromDp(dp: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)
            .toInt()
    }
}