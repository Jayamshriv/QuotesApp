package com.example.quotesapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotesapp.R
import com.example.quotesapp.models.Quotes

////////////////////////////////////////    STEP 1     ///////////////////////////////////////////////////

@Composable
fun QuotesItem(quote: Quotes, onClick: () -> Unit) {
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_format_quote_24),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.TopStart,
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Black)
                    .rotate(180f)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = quote.title,
                    color = Color.Black,
                    style = MaterialTheme.typography.body2
                )

                Divider(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(0.4f)
                )

                Text(
                    text = quote.author,
                    color = Color.Black,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Thin
                )
            }
        }
    }
}

