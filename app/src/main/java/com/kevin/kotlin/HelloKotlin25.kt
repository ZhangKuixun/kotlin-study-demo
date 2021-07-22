package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/6/20
 * describe：
 * 对可空类型扩展，可空类型：一个类型后面加一个问号
 */
fun Any?.toString(): String {
    if (null == this)
        return "null"
    return toString()
}