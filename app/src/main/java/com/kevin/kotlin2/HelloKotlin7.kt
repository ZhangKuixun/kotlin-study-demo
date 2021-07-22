package com.kevin.kotlin2


/**
 * other：Kevin
 * create time：2021/6/22
 * describe：
 * 泛型最后一课
 *
 * star projection（星投影）
 * Star<out T>：假如T的上界是TUpper，Star<out T>就可以写成Star<*>，读取过来的值都当作了TUpper类型。
 *
 * Star<in T>：Star<*>就相当于Star<in Nothing>，Nothing：没有实例，一个什么都不是的值，不能向其中写入任何值。
 *
 * Star<T>，如果T的上界是TUpper，那么Star<*>相当于读取时的Star<out TUpper>，以及写入时的Star<in Nothing>，不能往里写任何内容。
 */
class Star<out T> {
}

class Star2<in T> {
    fun setValue(t: T) {
    }
}

class Star5<T>(private var t: T) {
    fun setValue(t: T) {
    }

    fun getValue(): T {
        return this.t
    }
}

fun main() {
    val star: Star<Number> = Star<Int>()
    val star1: Star<*> = star

    val star3: Star2<Int> = Star2<Number>()
    val star4: Star2<*> = star3

    // star4.setValue(3) 不能写入Star2<in Nothing>
    val star6: Star5<String> = Star5("hello")
    val star7: Star5<*> = star6

    star7.getValue()
    // star7.setValue() 不能写入Star2<in Nothing>

    val list: MutableList<*> = mutableListOf("hello", "world")
    println(list[0])//hello
    // list[0]="test" 不能写入list<Nothing>[0]
}