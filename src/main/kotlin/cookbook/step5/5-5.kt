package cookbook.step5

data class Product(
    val name: String,
    var price: Double,
    var onSale: Boolean = false
)

fun namesOfProductsOnSale(products: List<Product>) =
    products.filter { it.onSale }
        .map { it.name }
        // .ifEmpty { listOf("none") }
        .joinToString(separator = ", ")
// .ifEmpty { "none" }

fun onSaleProducts_ifEmptyCollection(products: List<Product>) =
    products.filter { it.onSale }
        .map { it.name }
        .ifEmpty { listOf("none") }
        .joinToString(separator = ", ")

fun onSaleProducts_ifEmptyString(products: List<Product>) =
    products.filter { it.onSale }
        .map { it.name }
        .joinToString(separator = ", ")
        .ifEmpty { "none" }

fun main() {
    val products = listOf(Product("1", 10000.0, true), Product("2", 15000.0, true))
    println(namesOfProductsOnSale(products))
}