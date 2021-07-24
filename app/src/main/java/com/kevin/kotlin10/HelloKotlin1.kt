package com.kevin.kotlin10

/**
 * other：Kevin
 * create time：2021/7/16
 * describe：
 * kotlin调用java
 */
fun main() {
    val list = ArrayList<String>()//平台类型
    list.add("java")
    list.add("kotlin")
    for (item in list) {
        println(item)//java  kotlin
    }

    println("----------")
    for (i in 0 until list.size) {
        println(i)//0 1
    }

    println("----------")
    val person = Person()
    person.age = 20
    person.isMarried = true
    person.name = "java"
    println(person.toString())//Person{name='java', married=true, age=20}

    println("----------")
    // java的引用可能为null，kotlin对null有严格的检查与限制，kotlin引用java会冲突。☆☆☆
    // java的声明称为平台类型（platform types）。
    // java调用kotlin的方法时，kotlin的null检查不严格了，kotlin的空检查和java的语义变成一样了。
    // kotlin调用平台类型引用的方法时，kotlin在编译期不会施加空检查，在运行期可能会抛出异常。
    val list2 = ArrayList<String>()//平台类型
//    list2.add("hello")
    val item: String = list2[0]//运行报错

    val s: String? = item
    val s2: String = item
    // 将平台值传给kotlin声明的变量，s2运行报错。☆☆☆
    // 原因：声明一个不为空类型的变量，编译器会给它创建一个空判断的断言，一旦赋一个空值给不为空类型的变量，断言就会触发，程序报错，终止运行。
    // 将平台值传给kotlin方法的非空类型的参数，也会触发这个断言。
    // kotlin会防止null值蔓延到其他地方，发生问题就立刻断言解决。

//    val listOf = listOf<String>()//kotlin类型

}
