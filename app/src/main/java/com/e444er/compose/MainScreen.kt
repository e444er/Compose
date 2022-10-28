package com.e444er.compose

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.e444er.compose.ui.PostCard

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun MainScreen(mainViewModel: MainViewModel) {

    Scaffold(
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
                backgroundColor = MaterialTheme.colors.onSurface
            ) {
                Log.d("COMPOSE_TEST", "BottomNavigation")

                val selectedItem = remember { mutableStateOf(0) }

                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourite,
                    NavigationItem.Profile
                )

                items.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        selected = selectedItem.value == index,
                        onClick = { selectedItem.value = index },
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = stringResource(id = item.titleResId))
                        },
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        unselectedContentColor = MaterialTheme.colors.onSecondary
                    )
                }
            }
        }
    ) {
        val feedPost = mainViewModel.feedPosts.observeAsState(listOf())

        LazyColumn(
            modifier = Modifier.padding(it),
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
}


