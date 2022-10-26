package com.e444er.compose.test

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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