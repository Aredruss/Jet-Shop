package com.aredruss.jet_shop.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {

    val homeState: HomeState by homeViewModel.homeState.observeAsState(HomeState())

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                Column(Modifier.padding(10.dp)) {
                    Text(
                        text = "Hello, Alex",
                        style = MaterialTheme.typography.h4
                    )
                    Text(
                        text = "Welcome to the\nJetShop",
                        style = MaterialTheme.typography.h6
                    )
                }
            },
            content = {
                LazyColumn(content = {
                    items(homeState.categories) { category ->
                        Text(
                            text = category,
                            Modifier.padding(10.dp),
                            style = MaterialTheme.typography.h5
                        )
                    }
                })
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}