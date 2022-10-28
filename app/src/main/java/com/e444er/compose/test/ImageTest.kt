package com.e444er.compose.test

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.e444er.compose.R

@Preview
@Composable
fun ImageTest() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        modifier = Modifier.clip(CircleShape),
        contentScale = ContentScale.FillBounds,
        contentDescription = ""
    )
}

@Composable
fun BottomNavigationSample() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Songs", "Artists", "Playlists")

    BottomNavigation {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}

//ComposeTheme {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(color = MaterialTheme.colors.background)
//            .padding(8.dp)
//    ) {
//        val models = followViewModel.models.observeAsState(listOf())
//        LazyColumn {
//            items(models.value, key = { it.id }) { model ->
//                val dismissState = rememberDismissState()
//
//                if (dismissState.isDismissed(DismissDirection.EndToStart)) {
//                    followViewModel.delete(model)
//                }
//                SwipeToDismiss(
//                    state = dismissState,
//                    directions = setOf(DismissDirection.EndToStart),
//                    background = {
//                        Box(
//                            modifier = Modifier
//                                .padding(16.dp)
//                                .fillMaxSize()
//                                .background(Color.Red.copy(alpha = 0.5f)),
//                            contentAlignment = Alignment.CenterEnd
//                        ) {
//                            Text(
//                                modifier = Modifier.padding(16.dp),
//                                text = "Delete item",
//                                color = Color.White,
//                                fontSize = 24.sp
//                            )
//                        }
//                    }
//                ) {
//                    InstagramProfileCard(
//                        model = model,
//                        onFollowedClick = {
//                            followViewModel.changeFollowingStatus(it)
//                        }
//                    )
//                }
//            }
//        }
//    }
//}
