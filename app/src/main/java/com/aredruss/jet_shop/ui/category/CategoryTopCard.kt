package com.aredruss.jet_shop.ui.category

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aredruss.jet_shop.ui.theme.JetShopTheme

@Composable
fun CategoryTopCard(title: String) {
    Surface(
        color = MaterialTheme.colors.primaryVariant,
        modifier = Modifier.fillMaxWidth(),
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier.padding(all = 15.dp),
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h1,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun CategoryTopCardPreview() {
    JetShopTheme {
        CategoryTopCard("Electronics")
    }
}