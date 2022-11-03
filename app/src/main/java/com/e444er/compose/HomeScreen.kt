package com.e444er.compose

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissDirection
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.e444er.compose.domain.FeedPost
import com.e444er.compose.ui.PostCard

@Composable
fun HomeScreen(
    mainViewModel: MainViewModel,
    paddingValues: PaddingValues
) {
    val screenState = mainViewModel.screenState.observeAsState(HomeScreenState.Initial)

    when (val currentState = screenState.value) {
        is HomeScreenState.Posts -> {
            FeedPosts(
                posts = currentState.posts,
                mainViewModel = mainViewModel,
                paddingValues = paddingValues
            )
        }
        is HomeScreenState.Comments -> {
            CommentsScreen(
                feedPost = currentState.feedPost,
                comments = currentState.comments,
                onBackPressed = {
                    mainViewModel.closeComment()
                }
            )
            BackHandler {
                mainViewModel.closeComment()
            }
        }
        HomeScreenState.Initial -> {

        }
    }

}

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
private fun FeedPosts(
    posts: List<FeedPost>,
    mainViewModel: MainViewModel,
    paddingValues: PaddingValues
) {
    LazyColumn(
        modifier = Modifier.padding(paddingValues),
        contentPadding = PaddingValues(
            top = 16.dp,
            start = 8.dp,
            end = 8.dp,
            bottom = 72.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = posts,
            key = { it.id }
        ) { feedPost ->
            val dismissState = rememberDismissState()
            if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                mainViewModel.remove(feedPost)
            }
            SwipeToDismiss(
                modifier = Modifier.animateItemPlacement(
                ),
                state = dismissState,
                background = {},
                directions = setOf(DismissDirection.EndToStart)
            ) {
                PostCard(
                    feedPost = feedPost,
                    onCommentClick = {
                        mainViewModel.showComments(feedPost)
                    },

                    onLikeClick = { statisticItem ->
                        mainViewModel.updateCount(feedPost, statisticItem)
                    },

                    onShareClick = { statisticItem ->
                        mainViewModel.updateCount(feedPost, statisticItem)
                    },

                    onViewsClick = { statisticItem ->
                        mainViewModel.updateCount(feedPost, statisticItem)
                    },
                )
            }

        }
    }
}
