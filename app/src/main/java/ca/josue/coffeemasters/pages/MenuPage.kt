package ca.josue.coffeemasters.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ca.josue.coffeemasters.DataManager
import ca.josue.coffeemasters.Product
import ca.josue.coffeemasters.ui.theme.Alternative1
import ca.josue.coffeemasters.ui.theme.CardBackground
import ca.josue.coffeemasters.ui.theme.Primary
import coil.compose.AsyncImage

@Composable
fun MenuPage(dataManager: DataManager) {
    // repeat Product 10 times
    LazyColumn(content = {
        items(dataManager.menu) {
            Text(
                text = it.name,
                color = Primary,
                modifier = Modifier.padding(10.dp, 20.dp, 10.dp, 10.dp),
            )
            it.products.forEach { product ->
                Card(
                    elevation = 2.dp,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .background(CardBackground)
                        .padding(12.dp)
                ) {
                    ProductItem(product, onAdd = {
                        dataManager.cartAdd(product)
                    })
                }
            }
        }
    })
}

fun Double.format(digits: Int) = "%.${digits}f".format(this)


@Composable
fun ProductItem_Preview() {
    ProductItem(
        product = Product(
            id = 1,
            name = "Café de la semaine",
            price = 1.99,
            image = ""
        ),
        onAdd = {}
    )
}

@Composable
fun ProductItem(product: Product, onAdd: (Product)->Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        AsyncImage(
            model = product.imageUrl,
            contentDescription = "Image for ${product.name}",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(product.name, fontWeight = FontWeight.Bold)
                Text("${product.price.format(2)} CAD")
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Alternative1,
                    contentColor = Color.White
                ),
                onClick = {
                    onAdd(product)
                },
            ) {
                Text("Add")
            }
        }
    }
}