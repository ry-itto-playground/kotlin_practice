package tutorials

/**
 * https://kotlinlang.org/docs/tutorials/kotlin-for-py/functional-programming.html
 */

fun safeDivide(numerator: Int, denominator: Int) = if (denominator == 0) 0.0 else numerator.toDouble() / denominator

// 関数の型に準拠したクラスを作る
class Divider: (Int, Int) -> Double {
    override fun invoke(p1: Int, p2: Int): Double = p1.toDouble() / p2
}

// 関数の最後のパラメータの場合, パラメータの宣言をしているかっこの外側にラムダを書くことができる
fun sample(init: Int, function: (Int, Int) -> Int) {
    println(init + function(10, 2))
}

fun main() {
    // 関数を格納
    val f: (Int, Int) -> Double = ::safeDivide
    val quotient = f(3, 0)
    println(quotient)
    val div = Divider()
    println(div(4, 2))
    // ラムダ式
    val safeDivide = { numerator: Int, denominator: Int -> Double
        if (denominator == 0) 0.0 else numerator.toDouble() / denominator
    }
    println(safeDivide(3, 0))
    // 1つしかパラメータのない場合のラムダ. Swiftの$0みたいな
    val square: (Double) -> Double = { it * it }
    println(square(2))
    sample(2) { x: Int, y: Int ->
        x * y
    }
}