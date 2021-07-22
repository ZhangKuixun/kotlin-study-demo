package com.kevin.kotlin2


/**
 * other：Kevin
 * create time：2021/6/22
 * describe：
 * 泛型函数
 */
fun <T> getValue(item: T): T {
    return item
}

fun main() {
    val item = getValue<Int>(3)
    println(item)// 3

    val item2 = getValue("hello")
    println(item2)// hello
}

/**
 * <T>表示这个方法是泛型方法，它拥有一个方法泛型类型T，所以将参数声明为T类型，并且返回T类型，最后return item就符合T类型
 */


class UpperBoundsClass<T : List<T>> {
}

//fun main() {
//    //上界
//    val upperBoundsClass = UpperBoundsClass<AbstractList<String>>()
//}

/**
 * 定义好一个泛型，可以定义一个泛型的上界。
 * UpperBoundsClass<T : List<T>>：T的上界就是List。
 * 使用：UpperBoundsClass<AbstractList<String>>()，只要是List下面的类型就可以。
 */


class UpperBoundsClass2<T> where T : Comparable<T>, T : Any {
}
//fun main() {
//    //多个上界
//    val upperBoundsClass2 = UpperBoundsClass2<String>()
//}
/**
 * 两个及两个以上的上界
 * where T : Comparable<T>, T : Any，既要满足T : Comparable<T>，又要满足T : Any，后面的 T : Any 可以不用写
 * 使用：UpperBoundsClass2<String>()，String类型满足Comparable，Any。
 *
 * 注意：
 * Java中，一个泛型没有写上界，任意类型都可以。
 * Kotlin中，一个泛型没有写上界，默认上界是Any?（顶层可空类型）。
 */
