package tutorials

fun main() {
    val x: String? = null
    // Elvis演算子(Swiftの ?? )
    println(x ?: "none")
    // Safe call operator (SwiftでいうOptional chaining)
    println(x?.length)
    try {
        // force unwrapping
        println(x!!)
    } catch (e: KotlinNullPointerException) {
        println(e.localizedMessage)
    }
}