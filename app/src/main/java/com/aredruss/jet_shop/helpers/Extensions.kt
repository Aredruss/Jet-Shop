package com.aredruss.jet_shop.helpers

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.StateFlow

fun <T> StateFlow<T>.observe(lifecycleOwner: LifecycleOwner, action: FlowCollector<T>) =
    lifecycleOwner.lifecycleScope.launchWhenStarted { collect(action) }

@MainThread
inline fun <T> MutableLiveData<T>.update(crossinline block: (T) -> T) {
    value?.let { value = block(it) }
}



