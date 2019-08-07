package tutorials

import java.time.LocalDate

/**
 * https://kotlinlang.org/docs/tutorials/kotlin-for-py/strings.html
 */
fun main() {
    val c = 'A' // Char
    println(c::class)

    val str = "A" // String
    println(str::class)

    val s = str[0] // Char
    println(s::class)

    val year = LocalDate.now()
    // String interpolation 文字列補間
    val interpolation = "$str $s ${year.year}"
    println(interpolation)
}