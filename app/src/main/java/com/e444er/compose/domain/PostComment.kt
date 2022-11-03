package com.e444er.compose.domain

import com.e444er.compose.R

data class PostComment(
    val id: Int,
    val authorName: String = "Author",
    val authorAvatarId: Int = R.drawable.avatar,
    val commentText: String = "Long comment text",
    val publicationDate: String = "14:00"
)