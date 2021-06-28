package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/6/16
 * describe：
 */
fun main() {
    println(字符串转整数("1").toString())
    println(字符串乘法1("2", "3"))
}

fun 普通写法(a: Int, b: Int): Int {
    return a + b
}

fun 语法糖(a: Int, b: Int) = a + b

fun 不返回值(a: Int, b: Int): Unit {
    print(a + b)
}

fun 字符串模板(a: Int, b: Int) {
    print("$a + $b = ${a + b}")
}

fun 类型推断() {
    val a: Int = 1
    val b = 2

    var c: Int
    c = 3

    var d = 3
    d = 4
}

/*注释嵌套/*/*/**/*/*/*/

fun 小范围类型的值禁止付给大范围类型的值() {
    var x = 10
    var y: Byte = 20
//        x=y// 报错
    x = y.toInt()

    print(x)
}

fun 修改val() {
    val m = intArrayOf(1, 2, 3)
//        m = intArryOf(4, 5)// 报错
    m[0] = 4
}

fun 代码块简写() {
    var x = 10
    var y = 20
    var max = if (x > y) x else y
    var min = if (x > y) y else x
}

fun 代码块自动返回() {
    var x = 10
    var y = 20
    var min = if (x > y) {
        print("x>y")
        x
    } else {
        print("y>x")
        y
    }
}

fun 字符串转整数(str: String): Int? {
    return try {// 防止空指针
        str.toInt()
    } catch (e: Exception) {
        null
    }
}

fun 字符串乘法(a: String, b: String) {
    val a2Int = 字符串转整数(a)
    val b2Int = 字符串转整数(b)

    if (null != a2Int && null != b2Int) {
        println(a2Int * b2Int)
    } else {
        println("参数为null")
    }
}

fun 字符串乘法1(a: String, b: String) {
    val a2Int = 字符串转整数(a)
    val b2Int = 字符串转整数(b)

//        println(a2Int * b2Int)// 报错，两个可为空的Int值相乘报错

    when {
        null == a2Int -> {
            println("参数为null")
        }
        null == b2Int -> {
            println("参数为null")
        }
        else -> {
            println(a2Int * b2Int)
        }
    }
}