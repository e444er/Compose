package com.e444er.compose.test

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun TextTest() {
    Column {
        Text(
            buildAnnotatedString {
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Hello")
                }
                withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append(" ")
                }
                withStyle(
                    SpanStyle(
                        fontSize = 30.sp,
                        textDecoration = TextDecoration.LineThrough
                    )
                ) {
                    append("World!")
                }

            }
        )

        Text(
            text = "Hello World",
            fontSize = 22.sp,
            fontWeight = FontWeight.W100,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.LineThrough,
        )
    }

}