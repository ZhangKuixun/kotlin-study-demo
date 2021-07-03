package com.kevin.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * other：Kevin
 * create time：2021/7/3
 * describe：
 */
public class Tom3 {
    public static void main(String[] args) {
        List<Person> tom = Arrays.asList(
                new Person("tom", 12, 175),
                new Person("jerry", 12, 185),
                new Person("kitty", 14, 175),
                new Person("kitty", 19, 176),
                new Person("lucy", 10, 173));
        // 收集所有的元素
        List<Person> collect = tom.stream()
                .filter(item -> item.age > 12)
                .collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("-----------------allMatch匹配所有的元素:");
        // allMatch匹配所有的元素，匹配都为true，才能返回true。
        boolean b = tom.stream()
                .allMatch(item -> item.age > 10);
        System.out.println(b);

        System.out.println("-----------------数组自己的排序方法:");
        // 数组自己的排序方法
        tom.sort((item1, item2) -> item1.age - item2.age);
        System.out.println(tom);

        System.out.println("-----------------更友好的排序，正序:");
        tom.sort(Comparator.comparingInt(Person::getAge));
        tom.forEach(System.out::println);

        System.out.println("-----------------更友好的排序，倒序:");
        tom.sort(Comparator.comparingInt(item -> -item.getAge()));
        tom.sort(Comparator.comparingInt(Person::getAge).reversed());
        tom.forEach(System.out::println);

        // 先按年龄的倒序排，再按升高的正序排。
        tom.sort(Comparator.comparingInt(Person::getAge).reversed().thenComparingInt(Person::getHeight));

        System.out.println("-----------------forEach:");
        tom.forEach(System.out::println);
    }

    static class Person {
        String name;
        int age;
        int height;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getHeight() {
            return height;
        }

        public Person(String name, int age, int height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", height=" + height +
                    '}';
        }
    }
}
