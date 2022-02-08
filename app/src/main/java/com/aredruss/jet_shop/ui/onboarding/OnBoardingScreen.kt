package com.aredruss.jet_shop.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aredruss.jet_shop.ui.theme.JetShopTheme

@Composable
fun OnBoardingScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.primaryVariant)
                .padding(45.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            // horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Hi!", style = MaterialTheme.typography.h1)
            Text(text = "Let's get to know each other", style = MaterialTheme.typography.h2)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Jet-shop is a sample app", style = MaterialTheme.typography.h3)
            Text(text = "Those products are not real, you can't buy them.\nI'm sorry.", style = MaterialTheme.typography.h3)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Let's dive in", style = MaterialTheme.typography.h3)
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(value = "Your name (Optional)", onValueChange = { value ->

            })
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Sign up", style = MaterialTheme.typography.h3)
            }

        }
    }
}

@Preview
@Composable
fun OnBoardingPreview() {
    JetShopTheme {
        OnBoardingScreen()
    }
}
