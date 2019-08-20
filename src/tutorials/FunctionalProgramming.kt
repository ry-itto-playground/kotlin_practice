package tutorials

/**
 * https://kotlinlang.org/docs/tutorials/kotlin-for-py/functional-programming.html
 */

fun safeDivide(numerator: Int, denominator: Int) = if (denominator == 0) 0.0 else numerator.toDouble() / denominator

// 関数の型に準拠したクラスを作る
class Divider: (Int, Int) -> Double {
    override fun invoke(p1: Int, p2: Int): Double = p1.toDouble() / p2
}

fun main() {
    // 関数を格納
    val f: (Int, Int) -> Double = ::safeDivide
    val quotient = f(3, 0)
    println(quotient)
    val div = Divider()
    println(div(4, 2))
}