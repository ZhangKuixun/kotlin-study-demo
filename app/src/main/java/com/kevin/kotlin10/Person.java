package com.kevin.kotlin10;

/**
 * other：Kevin
 * create time：2021/7/17
 * describe：java bean
 */
public class Person {
    private String name;
    private boolean married;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", married=" + married +
                ", age=" + age +
                '}';
    }
}
