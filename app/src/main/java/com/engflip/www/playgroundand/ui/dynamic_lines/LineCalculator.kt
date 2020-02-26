package com.engflip.www.playgroundand.ui.dynamic_lines

import com.engflip.www.playgroundand.model.SpellingQuizCondition

class LineCalculator(private val wrapperWidth: Int, private val between: Int) {
    init {
        println("Init")
        println("wrapperWidth: $wrapperWidth\tbetween: $between")
        println("Init end")
    }
    fun calc(splitted: List<String>, letterWidth: Int, spaceWidth: Int ): SpellingQuizCondition {
        var remains = wrapperWidth
        var lines = 1
        val breakers: ArrayList<String> = arrayListOf()

        println("Calc")
        println("letterWidth: $letterWidth\tspaceWidth: $spaceWidth")
        println("Calc end")

        for(s in splitted) {
            val widthRequired = letterWidth * s.length  + between * s.length + spaceWidth

            remains -= widthRequired
            if(remains <= 0) {
                breakers.add(s)
                lines ++
                remains = wrapperWidth
            }
        }

        return SpellingQuizCondition(lines, breakers)
    }
}