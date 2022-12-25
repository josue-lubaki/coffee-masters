package ca.josue.coffeemasters

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DataManager(app : Application) : AndroidViewModel(app) {
    var menu : List<Category> by mutableStateOf(listOf())
    var cart : List<ItemInCart> by mutableStateOf(listOf())

    init{
        fetchData()
    }

    fun fetchData () {
        viewModelScope.launch {
            menu = API.menuService.fetchMenu()
            println(menu)
        }
    }

    fun cartAdd(product: Product) {
        var found = false

        cart.forEach {
            if (it.product.id == product.id) {
                it.quantity++
                found = true
            }
        }

        if (!found) {
           cart = listOf(*cart.toTypedArray(), ItemInCart(product, 1))
        }
    }

    fun cartRemove(product: Product) {
        val cartCopy = cart.toMutableList()
        cartCopy.removeAll { it.product.id == product.id }
        cart = listOf(*cartCopy.toTypedArray())
    }

    fun cartClear () {
        cart = listOf()
    }
}