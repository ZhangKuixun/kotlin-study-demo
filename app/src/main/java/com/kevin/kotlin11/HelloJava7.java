package com.kevin.kotlin11;

/**
 * other：Kevin
 * create time：2021/7/17
 * describe：
 * 测试java调用kotlin的伴生对象的方法
 */
class HelloJava7 {
    public static void main(String[] args) {
        MyClass2.Companion.test1();
        MyClass2.Companion.test2();
        MyClass2.test2();
    }
}
