package com.e444er.compose.domain

import com.e444er.compose.R

data class FeedPost(
    val communityName: String = "/dev/null",
    val publicationDate: String = "14:00",
    val avatarResId: Int = R.drawable.post_comunity_thumbnail,
    val contentText: String = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
    val contentImageResId: Int = R.drawable.post_content_image,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIEWS, 969),
        StatisticItem(type = StatisticType.SHARES, 234),
        StatisticItem(type = StatisticType.COMMENTS, 548),
        StatisticItem(type = StatisticType.LIKES, 623)
    )
)
