package com.aredruss.jet_shop.ui.home

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aredruss.jet_shop.ui.theme.JetShopTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen() {
    val homeViewModel = getViewModel<HomeViewModel>()
    val homeState: HomeState by homeViewModel.homeState.observeAsState(HomeState())
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    homeState.error?.consume()?.let {
        scope.launch {
            snackbarHostState.showSnackbar("Error getting categories $it")
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                TopCard()
            },
            content = {
                if (homeState.loading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .padding(100.dp),
                        strokeWidth = 10.dp,
                        color = MaterialTheme.colors.primaryVariant
                    )
                } else {
                    CategoryList(list = homeState.categories)
                }
                SnackbarHost(hostState = snackbarHostState)
            },
            bottomBar = {
                BottomLabel()
            }
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
