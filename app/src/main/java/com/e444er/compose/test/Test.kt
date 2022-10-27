package com.e444er.compose.test

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

//Button
@Composable
fun ButtonSample() {
    Button(onClick = { /* Do something! */ }) {
        Text("Button")
    }
}


@Composable
fun OutlinedButtonSample() {
    OutlinedButton(onClick = { /* Do something! */ }) {
        Text("Outlined Button")
    }
}

@Composable
fun TextButtonSample() {
    TextButton(onClick = { /* Do something! */ }) {
        Text("Text Button")
    }
}
@Composable
fun ButtonWithIconSample() {
    Button(onClick = { /* Do something! */ }) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Like")
    }
}
@Preview(showBackground = true)
@Composable
fun ScaffoldTest(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "TopAppBar title")
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Menu, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = null)
                    }
                }
            )
        },
        drawerContent = {
                        Text(text = "1")
                        Text(text = "1")
                        Text(text = "1")
                        Text(text = "1")
        },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    selected =true,
                    onClick = { /*TODO*/ },
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = null)},
                    label = { Text(text = "Favorite") }
                )
                BottomNavigationItem(
                    selected =true,
                    onClick = { /*TODO*/ },
                    icon = { Icon(Icons.Filled.Add, contentDescription = null)},
                    label = { Text(text = "Add") }
                )
                BottomNavigationItem(
                    selected =true,
                    onClick = { /*TODO*/ },
                    icon = { Icon(Icons.Filled.Create, contentDescription = null)},
                    label = { Text(text = "Create") }
                )
            }
        }
    ) {
        Text(
            modifier = Modifier.padding(it),
            text = "ScaffoldTest"
        )
    }

}