package com.engflip.www.playgroundand.model

data class Quiz(
    val word: String,
    val phonetic: String,
    val meanings: List<String>
)