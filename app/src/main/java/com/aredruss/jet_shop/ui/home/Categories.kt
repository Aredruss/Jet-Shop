package com.aredruss.jet_shop.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aredruss.jet_shop.ui.theme.DarkTransparentGrey
import com.aredruss.jet_shop.ui.theme.LightTransparentGrey


@Composable
fun CategoryList(list: List<String>) {
    Column {
        Text(
            text = "Explore what we have to offer you:",
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(15.dp)
        )
        LazyColumn(
            content = {
                items(list) { category ->
                    CategoryItem(title = category)
                }
            },
        )
    }
}

@Composable
fun CategoryItem(title: String) {
    Surface(
        color = if (isSystemInDarkTheme()) {
            DarkTransparentGrey
        } else {
            LightTransparentGrey
        },
        modifier = Modifier
            .padding(
                top = 10.dp,
                start = 15.dp,
                end = 15.dp
            )
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .clickable { }
    ) {
        Text(
            modifier = Modifier.padding(15.dp),
            text = title.replaceFirstChar { it.uppercase() },
            style = MaterialTheme.typography.h3,
            fontSize = 22.sp
        )
    }
}
