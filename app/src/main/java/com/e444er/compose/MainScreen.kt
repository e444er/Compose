package com.e444er.compose

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.e444er.compose.domain.FeedPost
import com.e444er.compose.ui.PostCard
import com.e444er.compose.ui.theme.ComposeTheme

@Composable
fun MainScreen() {

    val feedPost = remember {
        mutableStateOf(FeedPost())
    }

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
        PostCard(
            modifier = Modifier.padding(8.dp),
            feedPost = feedPost.value,
            onStatisticClick = { newItem ->
                val oldStatistics = feedPost.value.statistics
                val newStatistics = oldStatistics.toMutableList().apply {
                    replaceAll { oldItem ->
                        if (oldItem.type == newItem.type) {
                            oldItem.copy(count = oldItem.count + 1)
                        } else {
                            oldItem
                        }
                    }
                }
                feedPost.value = feedPost.value.copy(statistics = newStatistics)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Test() {
    ComposeTheme {
        MainScreen()
    }
}


