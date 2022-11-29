package com.e444er.compose.presentation.comments

import com.e444er.compose.domain.FeedPost
import com.e444er.compose.domain.PostComment

sealed class CommentsScreenState {

    object Initial : CommentsScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : CommentsScreenState()
}
