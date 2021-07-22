package com.kevin.kotlin3_

/**
 * other：Kevin
 * create time：2021/7/3
 * describe：
 */
////////////////////////////////////////////////////////////////////////////////////////////////////
// 练习
//fun main() {
//    val strings = arrayOf("hello", "world", "jerry", "tom", "okD")
//
//    // 找出数组中的元素，包含字母r的字符串
////    val results = arrayListOf<String>()
////    strings.forEach {
////        if (it.contains("r")) {
////            results.add(it)
////        }
////    }
////    results.forEach { println(it) }
//
//    strings.filter { it.contains("r") }.forEach { println(it) }
//
//    println("---------------")
//
//    // 找出长度大于四的字符串
//    strings.filter { it.length > 4 }.forEach { println(it) }
//
//    println("---------------")
//
//    // 找出以字母d结尾的字符串，并且把所有匹配的字符串转换成大写
//    strings.filter { it.endsWith("d", true) }.map { it.toUpperCase(Locale.ROOT) }.forEach { println(it) }
//
//}

////////////////////////////////////////////////////////////////////////////////////////////////////
// lambda表达式返回值
//fun main() {
//    val string = arrayOf("hello", "world", "lambda")
//
//    // 在默认情况下，lambda表达式中最后一个表达式的值会隐式的作为该lambda表达式的返回值。
//    string.filter {
//        val mayFilter = it.length > 3
//        mayFilter
//    }
//
//    // 也可以通过全限定return语法来显示从lambda表达式返回值
//    string.filter {
//        return@filter it.length > 3
//    }
//}


////////////////////////////////////////////////////////////////////////////////////////////////////
// 匿名函数
fun main() {
    // 1.匿名函数只能声明在函数里面，匿名函数写在外面，他没有名字，没法使用。
    // 2.把匿名函数放在函数里面，对匿名方法做一些转换，让后面的代码可以使用。
    fun(x: Int, y: Int) = x + y
    fun(x: Int, y: Int): Int {
        return x + y
    }

    // 匿名函数主要在lambda表达式中使用。
    val string = arrayOf("hello", "world", "lambda")
    string.filter(fun(item): Boolean = item.length > 3).forEach(fun(item) { println(item) })
}
/**
 * 匿名函数和lambda表达式的区别：
 * 匿名函数的执行体式表达式，它的返回类型可以自动的推断出来。
 * 匿名函数的执行体是一个花括号，返回值必须显示的指定。
 * 匿名函数的参数是在圆括号中传递，lambda方法的最后一个参数是lambda表达式，这个lambda表达式可以放到圆括号外面。
 * 匿名函数用return，表示的就是返回匿名函数本身，如果lambda表达式用return，表示的是lambda表达式所在的外层函数。
 *
 */