package tutorials

fun main() {
    /**
     * 以下のコレクションは読み取り専用. addとかのコレクション書き換えはできない
     */
    val strings = listOf("aaa", "bbb", "ccc") // List<String>
    println(strings::class)
    // => java.util.Arrays.ArrayList => Arrays.asList() で生成したものと同じ.
    val map = mapOf("a" to 1, "b" to 2, "c" to 3) // Map<String, Int
    println(map::class)
    // => java.util.LinkedHashMap
    val set = setOf("a", "b", "c")
    println(set::class)
    // => java.util.LinkedHashSet

    /**
     * 以下のコレクションは書き換え可能コレクション
     */
    val mutableStrings = mutableListOf("aaa", "bbb")
    mutableStrings.add("ccc")
    mutableStrings.remove("bbb")
    println(mutableStrings::class)
    // => java.util.ArrayList
    val mutableMap = mutableMapOf("a" to 1)
    mutableMap["b"] = 3 // mutableMap.put("b", 3)
    println(mutableMap::class)
    // => java.util.LinkedHashMap

    // サイズの取得
    println(mutableStrings.size)
    println(mutableMap.size)

    // 空のコレクション
    val emptyList: List<Int> = listOf()
    val emptyMap: Map<String, Int> = mapOf()
}