package com.kevin.java8;

/**
 * other：Kevin
 * create time：2021/7/2
 * describe：
 */
@FunctionalInterface
interface Person {
    //    void say();
    String say(String msg);

    default void play() {
        System.out.println("play");
    }
}

/**
 * 在jdk1.8以后，可以在接口里写默认方法，默认方法：用default修饰的方法，它可以写方法体。
 */
