package com.aredruss.jet_shop.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aredruss.jet_shop.domain.ShopPreferences
import com.aredruss.jet_shop.helpers.safeNavigate
import org.koin.androidx.compose.get

@Composable
fun OnBoardingScreen(
    navController: NavController,
    prefs: ShopPreferences = get()
) {

    var input by remember { mutableStateOf("") }
    val localFocusManager = LocalFocusManager.current

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.primaryVariant)
                .padding(45.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Hi!", style = MaterialTheme.typography.h1)
            Text(text = "Let's get to know each other", style = MaterialTheme.typography.h2)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Jet-shop is a sample app", style = MaterialTheme.typography.h3)
            Text(
                text = "Those products are not real, you can't buy them.\nI'm sorry.",
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Let's dive in", style = MaterialTheme.typography.h3)
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = input,
                singleLine = true,
                label = {
                    Text(text = "Your name (Optional)")
                },
                onValueChange = { value ->
                    input = value
                    prefs.onBoardingShown = true
                    prefs.userName = input.ifEmpty { "User" }
                }, keyboardActions = KeyboardActions(
                    onDone = {
                        localFocusManager.clearFocus()
                    }
                ))
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.safeNavigate("home")
                    prefs.onBoardingShown = true
                    prefs.userName = input.ifEmpty { "User" }
                }) {
                Text(text = "Sign up", style = MaterialTheme.typography.h3)
            }
        }
    }
}
