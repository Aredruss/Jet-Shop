package com.aredruss.jet_shop.ui.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.aredruss.jet_shop.ui.theme.Purple500
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(productId: String) {
    val productViewModel = getViewModel<ProductViewModel> { parametersOf(productId) }
    val productState by productViewModel.productState.collectAsState()

    Surface {
        Scaffold(
            topBar = {

            }, content = {
                Column {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        painter = rememberImagePainter(productState.product?.image),
                        contentDescription = productState.product?.title,
                        alignment = Alignment.Center
                    )
                    Text(
                        modifier = Modifier
                            .background(Purple500)
                            .padding(20.dp),
                        text = productState.product?.title ?: "Product",
                        style = androidx.compose.material.MaterialTheme.typography.h3,
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )

                    Text(
                        modifier = Modifier.padding(
                            top = 20.dp, bottom = 0.dp, start = 10.dp, end = 10.dp
                        ),
                        text = "${productState.product?.price}$",
                        style = androidx.compose.material.MaterialTheme.typography.h1,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        modifier = Modifier.padding(
                            top = 5.dp, bottom = 0.dp, start = 10.dp, end = 10.dp
                        ),
                        text = productState.product?.description ?: "A new product",
                        style = androidx.compose.material.MaterialTheme.typography.body2,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Justify
                    )
                }
            })
    }

}