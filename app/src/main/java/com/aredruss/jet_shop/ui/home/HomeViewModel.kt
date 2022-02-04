package com.aredruss.jet_shop.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aredruss.jet_shop.domain.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val productRepo: ProductRepository
) : ViewModel() {

    private val _homeState = MutableStateFlow(HomeState())
    val homeState: StateFlow<HomeState> = _homeState

    init {
        _homeState.update { it.copy(loading = true) }
        getCategories()

    }

    fun getCategories() = viewModelScope.launch {
        _homeState.value = HomeState(loading = true)
        productRepo.getAllCategories()
            .onFailure { error ->
                _homeState.value = HomeState(error = true, message = error.toString())
            }.onSuccess { result ->
                _homeState.value = HomeState(categories = result)
            }
    }
}

data class HomeState(
    val loading: Boolean = false,
    val error: Boolean = false,
    val message: String? = null,
    val categories: List<String> = emptyList()
)
