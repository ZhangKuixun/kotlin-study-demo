@file:JvmName("HelloWorld")
@file:JvmMultifileClass
package com.kevin.kotlin8

/**
 * other：Kevin
 * create time：2021/7/17
 * describe：
 * 需求：两个kotlin的文件，编译出的字节码文件名字都相同。
 * 编译结果：将两个文件中的成员编译到了同一个文件中。两个文件中的成员不能重名，会报错。
 */
fun myPrint2() {
    println("myPrent2")
}