package com.klewis61.simple_hn_reader.data

data class Story (
    val created_at: String?,
    val title: String?,
    val url: String?,
    val author: String?,
    val points: Int?,
    val story_text: String?,
    val comment_text: String?,
    val num_comments: Int?,
    val story_id: Int?,
    val story_title: String?,
    val story_url: String?,
    val parent_id: Int?,
    val created_at_i: Int?,
    val _tags: List<String>,
    val objectID: String,
    val _highlightResult: HighlightResult,
    val isFavorite: Boolean = false,
    val isRead: Boolean = false,
    val page: Int = 0,
    val nbHits: Int = 0,
    val nbPages: Int = 0,
    val hitsPerPage: Int = 0,
    val processingTimeMS: Int = 0,
    val query: String = ""

    )