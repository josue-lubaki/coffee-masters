package ca.josue.coffeemasters.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import ca.josue.coffeemasters.DataManager
import ca.josue.coffeemasters.ItemInCart
import ca.josue.coffeemasters.Product
import ca.josue.coffeemasters.ui.theme.Primary

@Composable
fun OrderPage(dataManager: DataManager) {
    LazyColumn(content = {
        if(dataManager.cart.isEmpty()){
            item {
                Card(
                    elevation = 2.dp,
                    modifier = Modifier.padding(16.dp),
                ) {
                    Text(
                        text = "Your cart is empty",
                        style = MaterialTheme.typography.h4,
                    )
                }
            }
        }

        items(dataManager.cart) {
            CartItem(it, onDelete = { product ->
                dataManager.cartRemove(product)
            })
        }
    })
}

@Composable
fun CartItem(it: ItemInCart, onDelete: (Product) -> Unit){
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()

    ) {
        Text("${it.quantity}x")
        Text(it.product.name,
            modifier = Modifier.width(150.dp)
        )
        Text("$${(it.quantity*it.product.price).format(2)}",
            modifier = Modifier.width(50.dp)
        )
        Image(
            imageVector = Icons.Filled.Delete,
            contentDescription = "Delete",
            colorFilter = ColorFilter.tint(Primary),
            modifier = Modifier.clickable {
                onDelete(it.product)
            }
        )
    }
}