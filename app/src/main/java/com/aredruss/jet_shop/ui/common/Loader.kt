package com.aredruss.jet_shop.ui.common

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Loader() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(100.dp),
        strokeWidth = 15.dp,
        color = MaterialTheme.colors.primaryVariant
    )
}