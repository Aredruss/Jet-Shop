package com.aredruss.jet_shop.ui.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aredruss.jet_shop.data.model.Product
import com.aredruss.jet_shop.domain.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val category: String,
    private val productRepo: ProductRepository
) : ViewModel() {

    private val _categoryState = MutableStateFlow(CategoryState())
    val categoryState: StateFlow<CategoryState> = _categoryState

    init {
        loadCategories()
    }

    fun loadCategories() = viewModelScope.launch {
        _categoryState.value = CategoryState(loading = true)
        productRepo.getProductsForCategory(category = category)
            .onFailure { error ->
                _categoryState.value = CategoryState(error = true, message = error.toString())
            }.onSuccess { result ->
                _categoryState.value = CategoryState(products = result)
            }
    }
}

data class CategoryState(
    val loading: Boolean = false,
    val error: Boolean = false,
    val message: String? = null,
    val products: List<Product> = emptyList()
)
