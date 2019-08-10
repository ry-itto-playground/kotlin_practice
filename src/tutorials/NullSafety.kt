package tutorials

/**
 * https://kotlinlang.org/docs/tutorials/kotlin-for-py/null-safety.html
 */
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