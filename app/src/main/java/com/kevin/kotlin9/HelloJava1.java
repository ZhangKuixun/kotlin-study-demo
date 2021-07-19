package com.kevin.kotlin9;

import java.util.ArrayList;
import java.util.List;

/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 */
class HelloJava1 {
    public static void main(String[] args) {
        List<String> strings = HelloKotlin1Kt.myFilter(new ArrayList<>());
        System.out.println(strings);//[hello, world]

        List<Integer> integers = HelloKotlin1Kt.myFilter2(new ArrayList<>());
        System.out.println(integers);//[1, 2]
        // java调用kotlin的多个相同函数名的扩展函数，只能调用注解生成的名字，@JvmName("myFilter2")的myFilter2。

    }
}
