package com.kevin.kotlin12;

import java.io.FileNotFoundException;

/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 */
class HelloJava4 {
    public static void main(String[] args) {
        MyClass3 myClass3 = new MyClass3();
        try {
            myClass3.method();
        } catch (FileNotFoundException e) {// 编译时报错
            // 编译时报错：
            // Exception 'java.io.FileNotFoundException' is never thrown in the corresponding try block
            // 没有在相应的语句块中抛出FileNotFoundException异常。
            // 没有在方法名字上抛出异常，又不能去捕获。
            // 解决：在kotlin需要抛出异常的方法上面写注解@Throws(xxxException::class)
            e.printStackTrace();
        }
    }
}
