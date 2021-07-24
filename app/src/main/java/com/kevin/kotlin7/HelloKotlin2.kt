package com.kevin.kotlin7

/**
 * other：Kevin
 * create time：2021/7/4
 * describe：
 */
////////////////////////////////////////////////////////////////////////////////////////////////////
// 可变集合
// 1.kotlin严格区分可变集合和不可变集合。
// 2.要清楚一点：区分开可变集合的只读视图与实际真正不可变集合。

fun main() {
    // 可变集合
    val stringList: MutableList<String> = mutableListOf("hello", "world", "kotlin")
    // 可变集合的只读视图。List<out E>是协变类型，只能取元素。
    val readOnlyView: List<String> = stringList
    println(stringList)
    stringList.add("java")
    println(readOnlyView)
    //[hello, world, kotlin]
    //[hello, world, kotlin, java]

    // 只有MutableCollection接口才有增删改查的方法，可变集合都实现了这个接口。
    // readOnlyView.clear()//报错
    // stringList.clear()//正常

    println("---------------")

    // 不可变集合：
    // 创建HashSet
    val strings: HashSet<String> = hashSetOf("a", "b", "c", "d")
    println(strings)
    //[a, b, c, d]

    // 协变可以把子类型的值赋值给父类型的值
    val s = listOf("a", "b")
    val s2: List<Any> = s

    println("---------------")

    // 快照
    // 比如list，它有toList方法，toList方法是一个扩展方法，它只会复制原集合的每一个元素，返回新集合，是永远不会发生变更的。
    val items = mutableListOf("a", "b", "c")
    val items2 = items.toList()
    items.add("d")
    println(items)//[a, b, c, d]
    println(items2)//[a, b, c]

    
}

