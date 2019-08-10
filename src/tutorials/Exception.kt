package tutorials

import java.lang.ArithmeticException

fun throwFunc() {
    throw Exception() // Nothing 型を返す
}

fun divideZero(): Int {
    return try {
        1 / 0
    } catch (e: ArithmeticException) {
        println(e.localizedMessage)
        0
    }
    // メソッドの最後に必ず実行される Swift の defer文と同じかな
    finally {
        println("finally")
    }
}

fun main() {
    println(divideZero())
}