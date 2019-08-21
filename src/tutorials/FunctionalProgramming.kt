package tutorials

import java.time.Instant

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

class A {
    val value = "AAAAA"
    inner class B {
        val value = "BBBBB"
        // 暗黙的にクラスBのthisになる
        val x = this
        // 明示的にクラスBのthis
        val y = this@B
        // クラスAのthisをとる
        val z = this@A
    }
}

// 呼び出した時に関数内容が展開されるような関数を定義. 主に引数に関数を受けるときに使う。引数に与えられた関数の前後に処理を挟むとか。
inline fun time(f: () -> Unit): Long {
    val start = Instant.now().toEpochMilli()
    f()
    return Instant.now().toEpochMilli() - start
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

    // レシーバを指定した拡張関数の宣言
    val boast: Divider.() -> String = {"Divider!!!"}
    // レシーバを指定したラムダ内のthisはレシーバ
    val hoge: Divider.() -> String = {"${this.invoke(1, 2)}"}
    println(div.boast())
    println(div.hoge())
    val b = A().B()
    println(b.x.value)
    println(b.y.value)
    println(b.z.value)
    val t = time { println("hoge") }
    println(t)

    var n: String? = null
    println(n?.length) // => null
    println(n?.run { println("receive null value!!") }) // => null
    n = "hoge"
    println(n?.run {
        println(this) // => hoge
    }) // => kotlin.Unit

    // run:let, apply:alsoの使い分けの記事。結構直感的でわかりやすかった
    // https://qiita.com/JohnSmithWithHaruhi/items/e8f411c379483d4902aa

    // takeIf
    n?.takeIf { !it.isEmpty() }.run { println(this) }
    n?.takeUnless { it.isEmpty() }.run { println(this) }
}