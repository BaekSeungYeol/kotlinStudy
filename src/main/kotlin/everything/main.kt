package everything

import com.fasterxml.jackson.core.type.TypeReference
import everything.util.Utils

fun main() {
    val products = "{\n" +
        "        \"name\": \"id\"\n" +
        "        }"
    val product = Utils.om.readValue(products, object : TypeReference<Product>() {})
    println(product.name)
}

data class Product(
    val name: String
)