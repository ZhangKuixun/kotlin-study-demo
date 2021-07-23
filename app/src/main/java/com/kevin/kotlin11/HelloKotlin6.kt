package com.kevin.kotlin11

/**
 * other：Kevin
 * create time：2021/7/17
 * describe：
 * java调用kotlin的伴生对象
 */
class People {
    companion object {
        var name = "zhangsan"
        @JvmField
        var age = 20
    }
}