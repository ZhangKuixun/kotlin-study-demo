package com.kevin.kotlin6


/**
 * other：Kevin
 * create time：2021/7/16
 * describe：
 * 注解 annotation
 * meta-annotation（元注解）：增加额外的元数据
 * 1.@Target：被注解的对象，可以被用在哪里，比如用在类上、方法上、参数上...。
 * 2.@Retention：被注解的对象，要存放在类中，还是要用反射获取。
 * 3.@Repeatable：相同的注解是否可以在同一个元素上多次出现。
 * 4.@MustBeDocumented：被注解的对象是API的一部分。
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER,
        AnnotationTarget.EXPRESSION, AnnotationTarget.CONSTRUCTOR,
        AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
@Repeatable
annotation class MyAnnotation

@MyAnnotation
class MyClass {
    fun myMethod(@MyAnnotation a: Int): Int {
        return (@MyAnnotation 10)
    }
}

// 给主构造方法加注解
class MyClass2 @MyAnnotation constructor(a: Int) {
}

// 给属性的set/get方法添加注解
class MyClass3 {
    var a: Int? = null
        @MyAnnotation set
        @MyAnnotation get
}
