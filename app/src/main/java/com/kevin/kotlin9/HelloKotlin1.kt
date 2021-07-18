package com.kevin.kotlin9

/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 */
//fun List<String>.myFilter(): List<String> {
//    return listOf("hello", "world")
//}
//
//fun List<Int>.myFilter(): List<Int> {
//    return listOf(1, 2)
//}
/**
 * 两个相同名字的扩展函数，编译时报错：
 * Platform declaration clash: The following declarations have the same JVM signature (myFilter(Ljava/util/List;)Ljava/util/List;)
 * 译：平台类型冲突，如下声明中有相同的JVM签名myFilter(Ljava/util/List;)Ljava/util/List;
 * public fun List<String>.myFilter(): List<String>
 * public fun List<Int>.myFilter(): List<Int>
 * 扩展函数实际是把要扩展的类，放入扩展函数"myFilter"的第一个参数中，java不存在扩展函数的概念。Java的泛型是假的泛型，泛型在字节码中都是Object来存储，
 * 要扩展的对象List<String>.myFilter()相当于List<Object>.myFilter()、List<Object>.myFilter()相当于List<Object>.myFilter()，
 * 编译时会报异常，平台类型冲突。
 */


/**
 * 想把两个相同名字的扩展函数写在相同作用域：Kotlin注解。
 */
fun List<String>.myFilter(): List<String> {
    return listOf("hello", "world")
}

// 在字节码中生成的函数名字是"myFilter2"，不是myFilter
@JvmName("myFilter2")
fun List<Int>.myFilter(): List<Int> {
    return listOf(1, 2)
}

fun main() {
    println(listOf<String>().myFilter())//[hello, world]
    println(listOf<Int>().myFilter())//[1, 2]
    // kotlin调用kotlin的扩展函数，不用调用注解生成的名字，用泛型就能判断出调用扩展函数名字，listOf<Int>().myFilter()。
    // java调用kotlin的多个相同函数名的扩展函数，只能调用扩展函数生成的名字，@JvmName("myFilter2")的myFilter2。
}