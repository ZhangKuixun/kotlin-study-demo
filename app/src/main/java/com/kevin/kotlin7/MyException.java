package com.kevin.kotlin7;

import java.io.IOException;

/**
 * other：Kevin
 * create time：2021/7/17
 * describe：
 * 测试kotlin调用java抛出非运行时异常的方法
 */
class MyException {
    public void myMethod() throws IOException {
        throw new IOException("I/O异常");
    }
}
