package tutorials

/**
 * https://kotlinlang.org/docs/tutorials/kotlin-for-py/loops.html
 */
fun main() {
    // for loop
    val strings = listOf("aaa", "bbb", "ccc")
    for (string in strings) {
        println(string)
    }

    for (i in 0..10) println(i) // 0 to 10
    for (i in 0 until 10) println(i) // 0 to 9
    for (i in 0..10 step 2) println(i) // 0, 2, 4, 6, 8, 10
    for (i in 10 downTo 0 step 2) println(i) // 10, 8, 6, 4, 2, 0
    println((0..10).toList())
    // with index
    for ((index, value) in strings.withIndex()) {
        println("$index $value")
    }

    // while loop
    var x = 0
    while (x < 10) {
        x++
    }

    // continue and break
    outer@ for (i in 2..100) {
        for (d in 2 until i) {
            if (i % d == 0) continue@outer
        }
        println("$i is prime")
    }
}