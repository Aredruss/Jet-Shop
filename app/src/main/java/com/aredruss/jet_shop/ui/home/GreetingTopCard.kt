package com.aredruss.jet_shop.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GreetingTopCard(name: String) {
    Surface(
        color = MaterialTheme.colors.primaryVariant,
        modifier = Modifier.fillMaxWidth(),
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier.padding(all = 15.dp),
        ) {
            Column {
                Text(
                    text = "Hello, $name",
                    style = MaterialTheme.typography.h1,
                    color = Color.White
                )
                Text(
                    text = "Welcome to the\nJetShop",
                    style = MaterialTheme.typography.h2,
                    color = Color.White
                )
            }

        }
    }
}