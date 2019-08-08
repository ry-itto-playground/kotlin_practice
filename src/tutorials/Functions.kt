package tutorials

/**
 * https://kotlinlang.org/docs/tutorials/kotlin-for-py/functions.html
 */


fun happyBirthday(name: String, age: Int): String {
    return "Happy ${age}th birthday, $name!"
}

fun square(number: Int) = number * number

fun countAndPrintArgs(vararg numbers: Int) {
    println(numbers.size)
    for (number in numbers) println(number)
}

fun foo(decimal: Double, integer: Int, text: String = "Hello") {
    println("$decimal $integer, $text")
}

/**
 * 毎回デフォルト値が評価される
 */
fun tricky(x: Int, numbers: MutableList<Int> = mutableListOf()) {
    numbers.add(x)
    println(numbers)
}

fun main() {
    println(happyBirthday("ry-itto", 21))
    println(square(2))
    countAndPrintArgs(1, 2, 3, 4, 5)
    foo(3.14, 40)
    foo(integer = 42, decimal = 20.1)
    foo(text = "zzZ", integer = 10, decimal = 2.3)
    tricky(1)
    tricky(2)

    // 配列を展開して引数にできる
    val numbers = listOf(1, 2, 3, 4)
    countAndPrintArgs(*numbers.toIntArray())
}