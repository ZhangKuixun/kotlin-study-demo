package com.kevin.kotlin8;

/**
 * other：Kevin
 * create time：2021/7/17
 * describe：
 * 测试java调用kotlin的伴生对象
 */
class HelloJava6 {
    public static void main(String[] args) {
        System.out.println(People.Companion.getName());//zhangsan
        System.out.println(People.age);//20
    }
}
