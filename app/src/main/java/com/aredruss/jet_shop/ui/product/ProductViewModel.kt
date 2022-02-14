package com.aredruss.jet_shop.ui.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aredruss.jet_shop.data.model.Product
import com.aredruss.jet_shop.domain.BasketRepository
import com.aredruss.jet_shop.domain.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductViewModel(
    private val productId: String,
    private val basketRepo: BasketRepository,
    private val productRepo: ProductRepository
) : ViewModel() {

    private val _productState = MutableStateFlow(ProductState())
    val productState: StateFlow<ProductState> = _productState

    init {
        getProduct()
    }

    fun getProduct() = viewModelScope.launch {
        _productState.update {
            it.copy(loading = true)
        }
        productRepo.getProduct(productId = productId)
            .onSuccess { product ->
                _productState.update {
                    ProductState(product = product)
                }
            }
            .onFailure { error ->
                _productState.update {
                    ProductState(
                        error = true,
                        message = error.toString(),
                        product = it.product
                    )
                }
            }
    }
}

data class ProductState(
    val loading: Boolean = false,
    val error: Boolean = false,
    val message: String? = null,
    val product: Product? = null
)
