package com.kevin.kotlin9;

/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 */
class HelloJava5 {
    public static void main(String[] args) {
        MyClass4 myClass4 = new MyClass4();
//        myClass4.method("hello world");//method invoked、hello world
        myClass4.method(null);
        // 运行时报错：NullPointerException: Parameter specified as non-null is null。
        // 译：指定的参数是一个非空，传入的是一个空。
    }
}
