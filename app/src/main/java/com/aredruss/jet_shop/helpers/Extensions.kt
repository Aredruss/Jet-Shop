package com.aredruss.jet_shop.helpers

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber

fun <T> StateFlow<T>.observe(lifecycleOwner: LifecycleOwner, action: FlowCollector<T>) =
    lifecycleOwner.lifecycleScope.launchWhenStarted { collect(action) }

// workaround for https://issuetracker.google.com/issues/118975714
fun NavController.safeNavigate(route: String) = try {
    navigate(route)
} catch (e: IllegalArgumentException) {
    Timber.e("safeNavigate failed: $e")
}




