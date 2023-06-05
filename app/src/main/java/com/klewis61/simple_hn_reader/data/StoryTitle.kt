package com.klewis61.simple_hn_reader.data

data class StoryTitle
    (
    val value: String?,
    val matchLevel: String?,
    val matchedWords: List<String>
    )