package com.kevin.kotlin8

/**
 * other：Kevin
 * create time：2021/7/17
 * describe：
 * @JvmField：被它注解的字段，是一个实例字段(instance field)，kotlin编译器不会给这种字段生成get、set。
 *
 */
class Person {
    var name: String = "zhangsan"
    @JvmField
    var age: Int = 10
}