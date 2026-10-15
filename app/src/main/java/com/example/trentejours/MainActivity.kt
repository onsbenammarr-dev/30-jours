package com.example.trentejours

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trentejours.model.Tip
import com.example.trentejours.model.tips
import com.example.trentejours.ui.theme.TrenteJoursTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrenteJoursTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TrenteJoursApp()
                }
            }
        }
    }
}

@Composable
fun TrenteJoursApp() {
    Scaffold(
        topBar = { TrenteJoursTopAppBar() }
    ) { padding ->
        TipsList(
            contentPadding = PaddingValues(
                top = padding.calculateTopPadding() + 8.dp,
                bottom = padding.calculateBottomPadding() + 8.dp
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrenteJoursTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayMedium
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        modifier = modifier
    )
}

@Composable
fun TipsList(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(tips) { tip ->
            TipItem(
                tip = tip,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun TipItem(tip: Tip, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable(tip.day) { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.primaryContainer
        else MaterialTheme.colorScheme.secondaryContainer,
        label = "cardColor"
    )

    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = color),
        modifier = modifier
            .animateContentSize()
            .clickable { expanded = !expanded }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.day_label, tip.day),
                style = MaterialTheme.typography.labelSmall
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = stringResource(tip.titleRes),
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
            )
            Spacer(Modifier.height(8.dp))
            Image(
                painter = painterResource(tip.imageResourceId),
                contentDescription = stringResource(tip.titleRes),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp)
                    .clip(MaterialTheme.shapes.small)
            )
            if (expanded) {
                Spacer(Modifier.height(12.dp))
                Text(
                    text = stringResource(tip.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}