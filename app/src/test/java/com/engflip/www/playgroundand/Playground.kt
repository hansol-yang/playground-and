package com.engflip.www.playgroundand

import org.junit.Before
import org.junit.Test

class Playground {
    private var word = ""

    @Before
    fun setup() {
        word = "in fact"
    }

    @Test
    fun testWhatever() {
        val splitted = word.split("").filter { it.isNotEmpty() }
        println(splitted)
    }
}