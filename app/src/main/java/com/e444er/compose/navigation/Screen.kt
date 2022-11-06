package com.e444er.compose.navigation

import android.net.Uri
import com.e444er.compose.domain.FeedPost
import com.google.gson.Gson

sealed class Screen(
    val route: String
) {
    object NewFeed : Screen(ROUTE_NEWS_FEED)
    object Favorite : Screen(ROUTE_FAVOURITE)
    object Profile : Screen(ROUTE_PROFILE)
    object Home : Screen(ROUTE_HOME)

    object Comments : Screen(ROUTE_COMMENTS) {

        private const val ROUTE_FOR_ARGS = "comments"

        fun getRouteWithArgs(feedPost: FeedPost): String {
            val feedPostJson = Gson().toJson(feedPost)
            return "$ROUTE_FOR_ARGS/${feedPostJson.encode()}"
        }

//        fun getRouteWithArgs(feedPost: FeedPost): String {
//            return "$ROUTE_FOR_ARGS/${feedPost.id}/${feedPost.contentText.encode()}"
//        }
    }

    companion object {


//        const val KEY_FEED_POST_ID = "feed_post_id"
//        const val KEY_CONTENT_TEXT = "content_text"
//
//        const val ROUTE_COMMENTS = "comments/{$KEY_FEED_POST_ID}/{$KEY_CONTENT_TEXT}"

        const val KEY_FEED_POST = "feed_post"

        const val ROUTE_HOME = "home"
        const val ROUTE_COMMENTS = "comments/{$KEY_FEED_POST}"
        const val ROUTE_NEWS_FEED = "news_feed"
        const val ROUTE_FAVOURITE = "favourite"
        const val ROUTE_PROFILE = "profile"

    }
}

fun String.encode(): String {
    return Uri.encode(this)
}


