package com.e444er.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.e444er.compose.test.InstagramProfileCard
import com.e444er.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private val followViewModel by viewModels<FollowViewModel>()

    @OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colors.background)
                        .padding(8.dp)
                ) {
                    val models = followViewModel.models.observeAsState(listOf())
                    LazyColumn {
                        items(models.value, key = { it.id }) { model ->
                            val dismissState = rememberDismissState()

                            if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                                followViewModel.delete(model)
                            }
                            SwipeToDismiss(
                                state = dismissState,
                                directions = setOf(DismissDirection.EndToStart),
                                background = {
                                    Box(
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .fillMaxSize()
                                            .background(Color.Red.copy(alpha = 0.5f)),
                                        contentAlignment = Alignment.CenterEnd
                                    ) {
                                        Text(
                                            modifier = Modifier.padding(16.dp),
                                            text = "Delete item",
                                            color = Color.White,
                                            fontSize = 24.sp
                                        )
                                    }
                                }
                            ) {
                                InstagramProfileCard(
                                    model = model,
                                    onFollowedClick = {
                                        followViewModel.changeFollowingStatus(it)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}







