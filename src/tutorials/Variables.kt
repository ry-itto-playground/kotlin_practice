package tutorials

// 定数(ファイルのトップレベル or オブジェクト宣言内でのみ実行可能)
const val x = 2

/**
 * https://kotlinlang.org/docs/tutorials/kotlin-for-py/declaring-variables.html
 */
fun main() {
    // 可変な変数
    var number = 10
    number = 30
    println(number)

    // 読み取り専用変数(定数ではない)
    val message = "Hello"
    // can't execute message = "aaa"
    println(message)

    // 型を明示的に指定
    val i = 1
    val b: Byte = 1
    println(i::class)
    println(b::class)

    // 変数名：lowerCamelCase で宣言する
}