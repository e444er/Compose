package com.e444er.compose.domain

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.e444er.compose.R
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeedPost(
    val id: Int = 0,
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
) : Parcelable {
    companion object {

        val NavigationType: NavType<FeedPost> = object : NavType<FeedPost>(false) {

            override fun get(bundle: Bundle, key: String): FeedPost? {
                return bundle.getParcelable(key)
            }

            override fun parseValue(value: String): FeedPost {
                return Gson().fromJson(value, FeedPost::class.java)
            }

            override fun put(bundle: Bundle, key: String, value: FeedPost) {
                bundle.putParcelable(key, value)
            }

        }
    }
}
