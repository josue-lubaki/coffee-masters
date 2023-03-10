package ca.josue.coffeemasters

class Product(
    var id : Int,
    var name: String,
    var price: Double,
    var image: String
){
    val imageUrl get() = "${BuildConfig.URL_API}images/${this.image}"
}

class Category(
    val name: String,
    val products: MutableList<Product>
)

class ItemInCart(
    var product: Product,
    var quantity: Int
)