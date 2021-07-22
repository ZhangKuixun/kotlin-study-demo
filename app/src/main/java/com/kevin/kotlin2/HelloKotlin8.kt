package com.kevin.kotlin2


/**
 * other：Kevin
 * create time：2021/6/22
 * describe：
 * 泛型擦除
 */
class MyStorage<out T>(private var t: T) {
    fun getValue(): T {
        return this.t
    }

    fun setValue(t: @UnsafeVariance T) {
        this.t = t
    }
}

fun main() {
    val myStorage1: MyStorage<Int> = MyStorage(5)
    val myStorage2: MyStorage<Any> = myStorage1
    println(myStorage2.getValue())//5

    myStorage2.setValue("hello")// 泛型擦除
    println(myStorage2.getValue())//hello
}
/**
 * MyStorage<out T>中的T已经被申明为协变类型，如果想要修改T，@UnsafeVariance T表示协变类型的T变成了普通的参数。
 * @UnsafeVariance ：压制协变、逆变的编译错误。
 *
 * 为啥可以这样做？
 * Java泛型的特点，在一个类中声明好了一个泛型，真正进入到字节码的时候，泛型是不存在的，都被当作Object看待，
 * 取出来时，强制类型向下转换，转换成真正的类型。
 */