package com.kevin.java8;


import android.os.Build;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * other：Kevin
 * create time：2021/7/3
 * describe：
 */
public class Tom1 {

    public static void tomSay(Consumer<String> consumer, String content) {
        consumer.accept(content);
    }

    public static void tomSay1(Function<String, String> consumer, String content) {
        consumer.apply(content);
    }

    public static void main(String[] args) {
        //Consumer
        Tom1.tomSay((msg) -> System.out.println("消费了" + msg), "jerry");
        //Function
        Tom1.tomSay1((msg) -> "转化了" + msg, "jerry");
    }
}
/**
 * 什么是函数？给我一个值，我给你变成另一个值。
 * <p>
 * jdk8提供的函数式接口：
 * 1.Predicate
 * 断言型接口，是只有一个参数，返回boolean类型值。
 * boolean test(T t);
 * 它就是用于判断。
 * 2.Function
 * 接收一个参数，开发者使用参数生成一个结果，返回一个结果。
 * 3.Supplier
 * 生产厂商，不断的生产产品，不需要任何的参数，返回输入泛型类型的结果。
 * 4.Consumer
 * 消费，把输入参数用了，但是不给返回。
 * 什么是消费了？就是把传入的值使用了（打印，计算，存入数据库），但是不返回任何东西。
 * 5.Comparator
 * 是java的老接口了，在原来的基础上，java8加了一些默认方法。
 */












