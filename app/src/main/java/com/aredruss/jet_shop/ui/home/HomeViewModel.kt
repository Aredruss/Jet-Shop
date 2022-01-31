package com.aredruss.jet_shop.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aredruss.jet_shop.domain.ProductRepository
import com.aredruss.jet_shop.domain.ShopPreferences
import com.aredruss.jet_shop.helpers.Event
import com.aredruss.jet_shop.helpers.update
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val prefs: ShopPreferences,
    private val productRepo: ProductRepository
) : ViewModel() {

    private val _homeState = MutableLiveData(HomeState())
    val homeState: LiveData<HomeState> = _homeState

    init {
        _homeState.update { it.copy(loading = true) }
        getCategories()

    }

    private fun getCategories() = viewModelScope.launch {
        productRepo.getAllCategories()
            .onFailure { error ->
                _homeState.update { it.copy(loading = false, error = Event(error.toString())) }
            }.onSuccess { result ->
                _homeState.update { it.copy(loading = false, categories = result) }
            }
    }
}

data class HomeState(
    val loading: Boolean = false,
    val error: Event<String>? = null,
    val categories: List<String> = emptyList()
)
