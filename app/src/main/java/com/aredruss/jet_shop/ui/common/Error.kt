package com.aredruss.jet_shop.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aredruss.jet_shop.ui.theme.JetShopTheme

@Composable
fun ErrorCard(
    error: String,
    action: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = error, style = MaterialTheme.typography.body1, fontSize = 22.sp,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(15.dp))
        Button(
            onClick = { action() }) {
            Text(text = "Reload", style = MaterialTheme.typography.h4)
        }
    }
}

@Preview
@Composable
fun ErrorPreview() {
    JetShopTheme {
        ErrorCard("Error getting categories") {}
    }
}