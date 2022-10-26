package com.e444er.compose.test

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.e444er.compose.R
import com.e444er.compose.ui.theme.ComposeTheme

@Composable
fun InstagramProfileCard() {
    Card(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(
            topStart = 4.dp,
            topEnd = 4.dp
        ),
        backgroundColor = MaterialTheme.colors.background,
        border = BorderStroke(1.dp, color = MaterialTheme.colors.onBackground)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_instagram),
                    contentDescription = "",
                    modifier = Modifier
//                    .border(
//                        2.dp,
//                        color = MaterialTheme.colors.onSurface,
//                        shape = RoundedCornerShape(
//                            8.dp
//                        ))
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.onSurface)
                        .padding(8.dp)
                )
                UserStatistics("Posts", "6,950")
                UserStatistics("Followers", "436M")
                UserStatistics("Following", "76")
            }
            TextInstagram()
        }

    }

}

@Composable
private fun UserStatistics(
    title: String,
    value: String
) {
    Column(
        modifier = Modifier
            .height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = value,
            fontSize = 24.sp,
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCard() {
    ComposeTheme(
        darkTheme = false
    ) {
        InstagramProfileCard()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCardDark() {
    ComposeTheme(
        darkTheme = true
    ) {
        InstagramProfileCard()
    }
}

@Composable
fun TextInstagram() {
    Column(
        modifier = Modifier.padding(
            start = 12.dp, bottom = 12.dp
        )
    ) {
        Text(
            text = "Instagram",
            fontSize = 32.sp,
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = "#YourToMake",
            fontSize = 14.sp,
        )
        Text(
            text = "www.facebook.com/emotional_health",
            fontSize = 14.sp,
        )
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Follow")
        }
    }
}