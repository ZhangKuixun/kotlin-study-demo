package com.kevin.kotlin4

/**
 * other：Kevin
 * create time：2021/7/16
 * describe：
 * 集合的扩展方法
 */
fun main() {
    val list = listOf(1, 2, 3, 4)
    println(list.first())//1
    println(list.last())//4
    list.filter { it % 2 == 0 }.forEach { println(it) }//2 4

    println("-------")
    val myList = mutableListOf(1, 2, 3)
    // 返回一个原集合，如果原集合里面有null元素，抛出异常
    println(myList.requireNoNulls())//[1, 2, 3]

    // 如果没有元素匹配none方法体的判断，返回true
    if (myList.none { it > 10 }) {
        println("没有大于10的")//没有大于10的
    }

    println(myList.firstOrNull())//1
    println(myList.lastOrNull())//3

    println("-----------------")
    val hashMap = hashMapOf("hello" to 1, "world" to 2)
    println(hashMap["hello"])//1

    val myHashMap: HashMap<String, Int> = HashMap(hashMap)
    println(myHashMap)//{hello=1, world=2}
}