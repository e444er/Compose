package com.e444er.compose

import com.e444er.compose.domain.FeedPost
import com.e444er.compose.domain.PostComment

sealed class HomeScreenState{

    object Initial: HomeScreenState()

    data class Posts(val posts: List<FeedPost>) : HomeScreenState()

    data class Comments(val feedPost: FeedPost, val comments: List<PostComment>) : HomeScreenState()
}
