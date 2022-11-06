package com.e444er.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.e444er.compose.domain.FeedPost
import com.e444er.compose.navigation.Screen.Companion.KEY_FEED_POST
import com.google.gson.Gson

fun NavGraphBuilder.homeScreenNavGraph(
    newsScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (FeedPost) -> Unit,
) {
    navigation(
        startDestination = Screen.NewFeed.route,
        route = Screen.Home.route
    ) {
        composable(Screen.NewFeed.route) {
            newsScreenContent()
        }
        composable(
            route = Screen.Comments.route,
            arguments = listOf(
                navArgument(KEY_FEED_POST) {
                    type = FeedPost.NavigationType
                }
            )
        ) {
            val feedPost = it.arguments?.getParcelable<FeedPost>(KEY_FEED_POST)
                ?: throw RuntimeException("Args is null ")
            commentsScreenContent(feedPost)
        }
//        composable(
//            route = Screen.Comments.route,
//            arguments = listOf(
//                navArgument(KEY_FEED_POST_ID) {
//                    type = NavType.IntType
//                },
//                navArgument(KEY_CONTENT_TEXT) {
//                    type = NavType.StringType
//                }
//            )
//        ) {
//            val feedPostId = it.arguments?.getInt(KEY_FEED_POST_ID) ?: 0
//            val contentText = it.arguments?.getString(KEY_CONTENT_TEXT) ?: ""
//            commentsScreenContent(FeedPost(id = feedPostId, contentText = contentText))
//        }
    }
}
