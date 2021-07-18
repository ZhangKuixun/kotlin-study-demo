package com.kevin.kotlin9

/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 * 重载方法冲突：
 * kotlin方法的参数可以设置默认值，java方法的参数不能设置默认值，如何把两种匹配起来。
 * 解决：kotlin注解：@JvmOverloads。
 *
 */
class MyClass2 @JvmOverloads constructor(x: Int, y: String = "hello") {
    fun myMethod(a: Int, b: String, c: Int = 2) {
        println("a=$a,b=$b,c=$c")
    }
}
/**
 * java调用kotlin的构造方法或者普通方法时，有几个参数就传递几个参数。
 * 如果给kotlin的构造方法或者普通方法，增加@JvmOverloads注解，字节码中会生成重载的构造方法或普通方法，
 * 生成的规则：
 * 为有默认值的参数生成重载方法，它的参数包含当前有默认值的参数，将这个参数右边的值都去掉：MyClass2(int x, String y)
 * 没有默认值的参数也会生成一个重载的方法：MyClass2(int x)，没有y，但是最终用到的y值是kotlin中声明的默认值。
 */