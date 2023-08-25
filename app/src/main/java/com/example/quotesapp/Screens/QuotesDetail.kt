package com.example.quotesapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotesapp.R
import com.example.quotesapp.models.Quotes

////////////////////////////////////////    STEP  2    ///////////////////////////////////////////////////


@Composable
fun QuoteDetails(quotes: Quotes) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFE7E6E6),
                        Color(0xFF707070)
                    )
                )
            )
    ) {
        Card(
            elevation = 4.dp,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.padding(16.dp),
        ) {
            Column(Modifier.padding(8.dp)) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_format_quote_24),
                    contentDescription = "Detailed Quote",
                    colorFilter = ColorFilter.tint(Color.Black),
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180f)
                )
                Text(
                    text = quotes.title,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.W400,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    modifier = Modifier.padding(8.dp)
                )

                Text(
                    text = quotes.author,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}