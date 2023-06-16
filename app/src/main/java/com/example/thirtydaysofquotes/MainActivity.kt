package com.example.thirtydaysofquotes

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydaysofquotes.model.Card
import com.example.thirtydaysofquotes.model.CardDateSourceRepo
import com.example.thirtydaysofquotes.ui.theme.ThirtyDaysOfQuotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuoteApp()
        }
    }
}

@Composable
fun QuoteApp() {
    val context = LocalContext.current
    ThirtyDaysOfQuotesTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            QuotationCardsList(QuotationLists = CardDateSourceRepo.cards)
        }
    }
}

@Composable
fun QuotationCard(card: Card, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(8.dp),
    ) {
        Column {
            Text(
                text = stringResource(id = card.title),
                modifier.padding(16.dp),
                style = MaterialTheme.typography.titleMedium
            )
            Image(
                painter = painterResource(id = card.imageRes),
                contentDescription = stringResource(id = card.descriptionRes),
                modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = card.descriptionRes),
                modifier.padding(16.dp),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun QuotationCardsList(QuotationLists: List<Card>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(QuotationLists) {Quotation ->
            QuotationCard(Quotation)
        }
    }
}

@Preview
@Composable
fun QuoteAppPreview() {
    QuotationCard(card = Card(R.string.day_1, R.string.quote_1,R.drawable.image_1))
}