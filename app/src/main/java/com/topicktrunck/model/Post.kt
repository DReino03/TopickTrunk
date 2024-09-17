package com.topicktrunck.model

data class Post(
    val id: Int,
    val title: String,
    val image: String,
    val category: String,
    val date: String,
    val content: String,
    val author: String,
    val authorImage: String,
    val likes: Int,
    val comments: Int,
    val shares: Int,
)
