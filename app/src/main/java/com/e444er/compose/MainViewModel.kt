package com.e444er.compose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e444er.compose.domain.FeedPost
import com.e444er.compose.domain.StatisticItem

class MainViewModel : ViewModel() {

    private val _feedPost = MutableLiveData(FeedPost())
    val feedPost: LiveData<FeedPost> = _feedPost

    fun updateCount(item: StatisticItem) {
        val oldStatistics = _feedPost.value?.statistics ?: throw IllegalStateException()
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        _feedPost.value = feedPost.value?.copy(statistics = newStatistics)
    }

}