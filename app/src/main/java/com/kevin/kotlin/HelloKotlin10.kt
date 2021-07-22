package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/7/22
 * describe：
 * 三个冒号
 */
fun main() {
    // \n也会失效
    fun 按照原有的格式输出字符串() {
        val b: String = """ helllo
            |\n world
            |    welcome
        """
        println(b)
    }
}