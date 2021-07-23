package com.kevin.kotlin10

/**
 * other：Kevin
 * create time：2021/7/17
 * describe：
 * 数组(Array)
 * kotlin的数组是不变的，不能协变也不能逆变。
 * java可以将String[]赋值给Object[]，运行时报异常。kotlin不能将Array<String>赋给Array<Any>，防止了运行期异常。
 *
 * 注意：
 * 如果kotlin方法是Any类型的参数，不能给这个方法的Any类型参数传入String。
 * 如果kotlin调用java的方法，方法是Object类型的参数，可以给这个Object类型的参数传入String。
 *
 * 原生类型数组：
 * Kotlin提供了原生类型数组避免自动装箱和拆箱的成本：IntArray，DoubleArray，CharArray...。
 * IntArray，DoubleArray...和Array没有任何关系，相互独立。IntArray面对JVM时，是一个原生类型数组（int[]）；Array面对JVM时，是一个java数组。
 * IntArray被编译时，会转成Int[]；DoubleArray被编译时，会转成Double[]...。
 *
 */
fun main() {
    val myArray = MyArray()
    val intArray: IntArray = intArrayOf(1, 2, 3)//IntArray
    myArray.myArrayMethod(intArray)
    val a: Array<Int> = arrayOf(1, 2, 3)//Array

    println("----------")
    // 面对JVM时，编译为JVM字节码，编译器会优化数组的访问，不会产生额外的成本。
    // 索引的方式操作数组，不会调用get或者set方法。
    // 索引方式：
    val arrayOf = arrayOf(1, 2, 3)
    arrayOf[0] = arrayOf[0] * 2
    for (x in arrayOf) {
        println(x)
    }

}