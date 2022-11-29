package com.e444er.compose.presentation.news

import com.e444er.compose.domain.FeedPost

sealed class NewsFeedScreenState{

    object Initial: NewsFeedScreenState()

    data class Posts(val posts: List<FeedPost>) : NewsFeedScreenState()
}
