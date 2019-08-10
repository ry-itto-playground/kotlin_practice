package tutorials

class Person(firstName: String, lastName: String, yearOfBirth: Int) {
    val fullName = "$firstName $lastName"
    var age: Int = 32
        set(value) {
            if (value < 0) {
                throw IllegalArgumentException("Age cannot negative")
            }
            field = value
        }

    // constructor
    init {
        age = 2018 - yearOfBirth
    }

    fun present() {
        println("Hello")
    }
}

// コンストラクタの引数しかパラメータに持っていないクラス
class Person2(val name: String, val age: Int)

// コンストラクタのオーバーロード
class Person3(val name: String, val age: Int) {
    constructor(name: String):this(name, 0)
    constructor(yearOfBirth: Int, name: String):this(name, 2018 - yearOfBirth)

    infix fun marry(spouse: Person3) {
        println("$name and ${spouse.name} are getting married!!")
    }

    operator fun plus(spouse: Person3) {
        println("$name and ${spouse.name} are getting married!!")
    }
}

class Person4() {
    // not-nullなパラメータの初期化を `init` よりも後にすることができる
    lateinit var name: String

    fun present() {
        if (::name.isInitialized) println(name)
    }
}

enum class ContentKind(val kind: String, val num: Int) {
    TOPIC("Topic", 1),
    ARTICLE("Article", 2),
    EXERCISE("Exercise", 3),
    VIDEO("Video", 4);

    override fun toString(): String {
        return kind
    }
}

// 自動的に `toString`, `equals`, `hashCode` などが実装される。
// toString: 全てのプロパティの名前と値を含む文字列を取得
// equals: 全てのプロパティに対して `equals` を実行
data class ContentDescriptor(val kind: ContentKind, val id: String)

fun main() {
    val a = Person("aa", "bb", 0)
    val b = Person("bb", "cc", 1998)
    println("${a.age} ${b.age}")
    a.age = 42
    println("${a.age} ${b.age}")
    a.present()
    val p2 = Person2("test", 100)
    println(p2.age)
    val p3_1 = Person3("test")
    println(p3_1.age) // 0
    val p3_2 = Person3(2000, "aaa")
    println(p3_2.age)
    val p3_3 = Person3("bbb", 20)
    println(p3_3.age)
    p3_1 marry p3_2
    p3_2 + p3_3
    val p4_1 = Person4()
    p4_1.present()
    p4_1.name = "aaa"
    p4_1.present()
    println(ContentKind.ARTICLE.num)

    val c1 = ContentDescriptor(ContentKind.ARTICLE, "1")
    val c2 = ContentDescriptor(ContentKind.ARTICLE, "1")
    val c3 = ContentDescriptor(ContentKind.ARTICLE, "12")
    val c4 = ContentDescriptor(ContentKind.EXERCISE, "1")
    println(c1 == c2)
    println(c1 == c3)
    println(c1 == c4)
}