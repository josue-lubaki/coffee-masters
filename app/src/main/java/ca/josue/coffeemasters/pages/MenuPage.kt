package ca.josue.coffeemasters.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.josue.coffeemasters.Product
import ca.josue.coffeemasters.R
import ca.josue.coffeemasters.ui.theme.Alternative1
import ca.josue.coffeemasters.ui.theme.CardBackground

@Preview(showBackground = true)
@Composable
fun MenuPage() {
    // repeat Product 10 times
    LazyColumn(content = {
        items(5) {
            Card(
                elevation = 2.dp,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(CardBackground)
                    .padding(12.dp)
            ) {
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
        }
    })
}

fun Double.format(digits: Int) = "%.${digits}f".format(this)


//@Preview(showBackground = true)
//@Composable
//fun ProductItem_Preview() {
//    ProductItem(
//        product = Product(
//            id = 1,
//            name = "Café de la semaine",
//            price = 1.99,
//            image = ""
//        ),
//        onAdd = {}
//    )
//}

@Composable
fun ProductItem(product: Product, onAdd: (Product)->Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        Image(
            painter = painterResource(id = R.drawable.black_coffee),
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