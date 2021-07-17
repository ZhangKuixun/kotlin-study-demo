package com.kevin.kotlin8

/**
 * other：Kevin
 * create time：2021/7/16
 * describe：
 * 属性（properties）：
 * kotlin的属性会被编译成三个部分：get、set、私有属性名的字段（field）。
 *
 * 属性名是is开头：
 * 1.get方法和属性名字一样
 * 2.set方法将"is..."替换成"set..."
 * is开头的规则适用于所有类型，Boolean、String...。
 */
class Test {
    var name: String = "zhangsan"
    var isMerry: String = "lisi"
}

