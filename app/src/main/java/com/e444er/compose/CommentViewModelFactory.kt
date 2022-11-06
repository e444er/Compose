package com.e444er.compose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.e444er.compose.domain.FeedPost

class CommentViewModelFactory(
    private val feedPost: FeedPost
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CommentViewModel(feedPost) as T
    }
}