package com.klewis61.simple_hn_reader.data

import android.icu.text.CaseMap
import retrofit2.http.Url

data class HighlightResult (
    val title: StoryTitle?,
    val url: StoryUrl?,
    val author: Author?,
)