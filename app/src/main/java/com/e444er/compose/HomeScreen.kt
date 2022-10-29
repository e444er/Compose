package com.e444er.compose

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
import com.e444er.compose.ui.PostCard

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    mainViewModel: MainViewModel,
    paddingValues: PaddingValues
) {
    val feedPost = mainViewModel.feedPosts.observeAsState(listOf())

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
            items = feedPost.value,
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
                    onCommentClick = { statisticItem ->
                        mainViewModel.updateCount(feedPost, statisticItem)
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