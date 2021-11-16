package com.kevin.kotlin3

/**
 * other：Kevin
 * create time：2021/6/26
 * describe：
 * 实践内部类和嵌套类
 */
class Person(val name: String, var age: Int) {
    private val str: String = "Person属性"

    private inner class PersonFeature(var height: Int, var weight: Int) {
        private val str: String = "PersonFeature属性"

        fun getPersonFeature() {
            val str: String = "局部变量"

            println("身高：$height, 体重：$weight")//身高：12, 体重：10

            println(this@Person.str)//Person属性
            println(this.str)//PersonFeature属性
            println(str)//局部变量

            this@Person.method()//执行了Person的method方法
        }
    }

    private fun method() {
        println("执行了Person的method方法")
    }

    fun getPerson() {
        val personFeature = PersonFeature(12, 10)
        personFeature.getPersonFeature()
    }
}

fun main() {
    val person = Person("张三", 20)
    person.getPerson()
}
/**
 * 访问变量：
 * 访问外部类的成员：this@外部类名字.str
 * 访问内部类的成员：this.str
 * 方法方法自己的成员：str
 */