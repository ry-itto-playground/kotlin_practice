fun main() {
    for (i in 1..100) {
        println(solveFizzBuzz(i))
    }
}

fun solveFizzBuzz(i: Int): String {
    return if (i % 15 == 0) {
        "FizzBuzz"
    } else if (i % 3 == 0) {
        "Fizz"
    } else if (i % 5 == 0) {
        "Buzz"
    } else {
        i.toString()
    }
}