package com.example.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.quotesapp.Screens.QuotesItem
import com.example.quotesapp.models.DataManager
import com.example.quotesapp.models.Quotes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromJson(this)
//        }

        setContent {
            ShowQuote(quotes = DataManager.data) {
                //
            }
        }
    }
}

@Composable
fun ShowQuote(quotes: Array<Quotes>, onClick: () -> Unit) {

    if (DataManager.isDataLoaded.value) {
        Column {
            Text(
                text = "Quotes App",
                fontFamily = FontFamily.Cursive,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            LazyColumn(content = {
                items(quotes){item ->
                    QuotesItem(quote = item) {
                        
                    }
                }
            })
        }
    } else {
        Box(modifier = Modifier.fillMaxSize(1f),
        contentAlignment = Alignment.Center) {
            Column {
                CircularProgressIndicator()
                Text(text = "Loading")
            }
        }
    }
}

@Composable
fun DefaultPreview() {

}