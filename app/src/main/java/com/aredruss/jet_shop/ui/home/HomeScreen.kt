package com.aredruss.jet_shop.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aredruss.jet_shop.ui.theme.DarkTransparentGrey
import com.aredruss.jet_shop.ui.theme.JetShopTheme
import com.aredruss.jet_shop.ui.theme.LightTransparentGrey

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {

    val homeState: HomeState by homeViewModel.homeState.observeAsState(HomeState())

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
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
                                text = "Hello, Alex",
                                style = MaterialTheme.typography.h1,
                                color = Color.White
                            )
                            Text(
                                text = "Welcome to the\nJetShop",
                                style = MaterialTheme.typography.h2,
                                color = Color.White
                            )
                        }
//                        FloatingActionButton(
//                            backgroundColor = MaterialTheme.colors.primaryVariant,
//                            elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp),
//                            onClick = { /*TODO*/ }
//                        ) {
//                            Icon(
//                                painter = painterResource(R.drawable.ic_cart),
//                                contentDescription = "Cart Icon"
//                            )
//                        }
                    }

                }
            },
            content = {
                Column {
                    Text(
                        text = "Explore what we have to offer you:",
                        style = MaterialTheme.typography.h2,
                        modifier = Modifier.padding(15.dp)
                    )
                    LazyColumn(
                        content = {
                            items(homeState.categories) { category ->
                                CategoryItem(title = category)
                            }
                        },
                    )
                }
            },
            bottomBar = {
                Surface(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .padding(top = 5.dp, bottom = 5.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Made with FakeStoreAPI",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.h4
                        )
                    }
                }
            }
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


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetShopTheme {
        CategoryItem(title = "Electronics")
    }
}
