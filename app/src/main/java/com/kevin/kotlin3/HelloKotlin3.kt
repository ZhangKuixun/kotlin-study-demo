package com.kevin.kotlin3

/**
 * other：Kevin
 * create time：2021/6/26
 * describe：
 * 实践内部类和嵌套类
 */
class Person1(val name: String, var age: Int) {
    private val str: String = "Person1属性"

    private inner class PersonFeature(var height: Int, var weight: Int) {
        private val str: String = "PersonFeature属性"

        fun getPersonFeature() {
            val str: String = "局部变量"

            println("身高：$height, 体重：$weight")

            println(this@Person1.str)
            println(this.str)
            println(str)

            this@Person1.method()
        }
    }

    private fun method() {
        println("执行了Person的method方法")
    }

    fun getPerson1() {
        val personFeature = PersonFeature(12, 10)
        personFeature.getPersonFeature()
    }
}

fun main() {
    val person1 = Person1("张三", 20)
    person1.getPerson1()
}
/**
 * 访问外部类的成员：this@外部类名字.str
 * 访问内部类的成员：this.str
 * 方法方法自己的成员：str
 */