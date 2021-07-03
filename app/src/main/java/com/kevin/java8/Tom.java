package com.kevin.java8;

/**
 * other：Kevin
 * create time：2021/7/2
 * describe：
 */
public class Tom {
    public static void tomSay(Person p) {
        String hello = p.say("hello");
        System.out.println(hello);
    }

    public static void main(String[] args) {
//        Person person = new Person() {
//            @Override
//            public void say() {
//            }
//        };
//        Person kevin = () -> {
//            System.out.println("kevin");
//        };
//        Person kevin = () -> System.out.println("kevin");

//        Person tom = (msg) -> "jerry sey:" + msg;
//        System.out.println(tom.say("hello"));

        // return和或括号可以不写。
        Tom.tomSay((msg) -> "jerry say:" + msg);

        // 改变lambda表达式外面的变量
        String tail = "how?";
        Person person = (msg -> msg + tail);
    }
}

/**
 * 方法是属于某一个类的，函数是独立存在的。
 * 函数式接口：只包含一个抽象方法，但是可以有多个默认方法（非抽象）的接口。
 * <p>
 * 只有一个抽象方法的接口，是函数式接口，方法比接口类重要。
 * lambda写法：
 * Person kevin = () -> System.out.println("kevin");
 * <p>
 * lambda方法体注意点：
 * 1.方法体只有一行代码，可以不写花括号。
 * 2.方法体有返回值，并且只有一行代码，可以不写return。
 * <p>
 * lambda作用域
 * 访问局部变量：
 * 可以直接在lambda表达式中访问局部变量，并且局部变量不用申明为final。
 * 编译器把局部变量隐式声明为final，所以还是不能修改局部变量。
 * <p>
 * 访问字段和静态变量：
 * 对实体字段和静态变量，有读写权限。
 */

