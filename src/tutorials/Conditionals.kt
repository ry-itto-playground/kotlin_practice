package tutorials

fun main() {
    // if/else
    val i = 42
    if (i < 10) {
        println("i is less than 10")
    } else if (i > 50) {
        println("i is larger than 50")
    } else {
        println("i is between 10 and 50")
    }

    // if/else statement (if/else の式)
    val result = if (i > 20) i * 10 else i
    println(result)

    // when (switch case)
    when (i) {
        in 0..9 -> println("i is less than 10")
        in 51..99 -> println("i is larger than 50")
        in 10..50 -> println("i is between 10 and 50")
        else -> println("??")
    }
}