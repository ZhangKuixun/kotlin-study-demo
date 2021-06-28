package com.kevin.kotlin3

import java.util.*
import kotlin.properties.Delegates
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * other：Kevin
 * create time：2021/6/27
 * describe：
 * 委托（delegation）
 *
 * 自己有事情让A去完成，A让B去完成，这就是委托
 */
////////////////////////////////////////////////////////////////////////////////////////////////////
// 类委托
interface MyInterface {
    fun myPrint()
}

class MyInterfaceImpl(var str: String) : MyInterface {
    override fun myPrint() {
        println("welcome $str")
    }
}

class MyClass(myInterface: MyInterface) : MyInterface by myInterface {
    override fun myPrint() {
        println("hello world")
    }
}

//fun main() {
//    val myInterfaceImpl = MyInterfaceImpl("ZhangSan")
//    MyClass(myInterfaceImpl)
//}

/**
 * class MyClass(myInterface: MyInterface) : MyInterface by myInterface
 * 分析：
 * 1.by后面的名字，必须用MyClass的参数myInterface
 * 2.如果MyClass类自己实现了MyInterface接口的myPrint方法，优先使用自己的
 *
 * 委托原理：
 * by关键字后面的对象实际上会被存储在类的内部，编译器则会把父接口中所有的方法实现出来，并且把实现转移给委托对象去进行。
 */


////////////////////////////////////////////////////////////////////////////////////////////////////
// 属性委托
class MyDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String =
        "$thisRef, your delegate name is ${property.name}"

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) =
        println("$thisRef, new value is $value")
}

class MyPropertyClass {
    var str: String by MyDelegate()
}

//fun main() {
//    val myPropertyClass = MyPropertyClass()
//    myPropertyClass.str = "hello world"
//    println(myPropertyClass.str)
//}
/**
 * MyDelegate的getValue、setValue必须这样写，如果MyDelegate不写，它的父类会定义这两个方法。
 * MyDelegate的operator，表示运算符，myPropertyClass.str调用的是MyDelegate的setValue方法，主要就是operator在起作用。
 *
 * 有四种情况在实际开发中比较有作用：
 * 1.延迟属性。
 * 2.可观测属性。当给一个属性赋值的时候，这个属性就相当于一个监听器一样，在赋值之前或者赋值之后，监听器收到相应的通知，执行预先或事后的处理。
 * 3.非空属性。
 * 4.map委托。
 */


////////////////////////////////////////////////////////////////////////////////////////////////////
// 延迟属性：属性在第一次被访问的时候才会被计算，然后将计算的结果缓存起来，供后续调用。
val myLazyValue: Int by lazy(LazyThreadSafetyMode.NONE) {
    println("hello world")
    30
}

//fun main() {
//    println(myLazyValue)
//    println(myLazyValue)
//}
/**
 * LazyThreadSafetyMode 延迟线程安全模式
 * SYNCHRONIZED 有一个锁，可以保证只有一个线程初始化实例。
 * PUBLICATION 初始化器函数可以被调用多次，并且是并发访问。但是只有第一次调用的返回值作为延迟属性的结果。
 * NONE 没有锁。可以减少线程安全的开销，但是确保它只会在一个线程中执行。
 */


////////////////////////////////////////////////////////////////////////////////////////////////////
// 非空属性：适用于无法在初始化阶段就确定属性值的情况
class MyPerson {
    var address: String by Delegates.notNull()
}

//fun main() {
//    val myPerson = MyPerson()
//    myPerson.address = "suzhou"
//    println(myPerson.address)
//}
/**
 * Delegates.notNull
 * 针对读写属性返回一个非空的属性委托，它不会在对象构建期间初始化，是在后面的时间初始化。使用的时候必须先赋值，后使用，不然会抛出异常。
 */


////////////////////////////////////////////////////////////////////////////////////////////////////
// 可观测属性（Observable）
class Person {
    var age: Int by Delegates.observable(20) { prop, oldValue, newValue ->
        println("${prop.name}, oldValue: $oldValue, newValue: $newValue")
    }
}

class Person2 {
    var age: Int by Delegates.vetoable(20) { property, oldValue, newValue ->
        when {
            oldValue <= newValue -> true
            else -> false
        }
    }
}

//fun main() {
//    val person = Person()
//    person.age = 30
//    person.age = 40
//
//    println("----------")
//
//    val person2 = Person2()
//    println(person2.age)
//    println("--")
//    person2.age = 40
//    println(person2.age)
//    println("--")
//    person2.age = 30
//    println(person2.age)
//}

/**
 * Delegates.observable(initialValue, onChange): ReadWriteProperty
 * 返回了一个针对读写属性的委托，当属性值被改变之后，调用回调函数。
 * initialValue: 属性的初始值
 * onChange：是一个回调函数，它是在属性变化之后被调用。
 * --onChange的三个参数：被赋值的属性值，旧的属性值与新的属性值。
 * ReadWriteProperty: 是Delegates.observable的返回值，就是一个属性委托，里面有getValue、setValue方法。
 *
 * Delegates.vetoable(initialValue, onChange): ReadWriteProperty
 * 返回了一个针对读写属性的委托，当属性值被改变之前，调用回调函数，回调允许否决这个修改。
 * onChange：对属性值修改之前调用回调函数。
 * 当回调被调用的时候，属性值还尚未被修改，如果返回true，就会被设置成新的值，如果返回false，设置的值不会修改属性。
 *
 */


////////////////////////////////////////////////////////////////////////////////////////////////////
// map委托
class Student(map: Map<String, Any?>) {
    val name: String by map
    val address: String by map
    val age: Int by map
    val birthday: Date by map
}

class Student2(map: MutableMap<String, Any?>) {
    var address: String by map
}

//fun main() {
//    val student = Student(
//        mapOf(
//            "name" to "zhangsan",
//            "address" to "beijing",
//            "age" to 20,
//            "birthday" to Date()
//        )
//    )
//    println(student.name)
//    println(student.address)
//    println(student.age)
//    println(student.birthday)
//
//    println("-----------")
//
//    val map = mutableMapOf<String, Any?>("address" to "beijing")
//    val student2 = Student2(map)
//    println(map["address"])
//    println(student2.address)
//
//    println("--")
//
//    student2.address = "shanghai"
//    println(map["address"])
//    println(student2.address)
//}
/**
 * 将属性存储到map中
 *
 * 一种常见的应用场景是将属性值存储到map当中。
 * 这种通常出现在JSON解析或是一些动态行为。
 * 这种情况中，可以将map实例作为委托，作为类的属性委托。
 *
 * 注意：map中的key，名字要与Student类中的属性名字保持一致。
 */


////////////////////////////////////////////////////////////////////////////////////////////////////
// 委托注意点
/**
 * 属性委托的要求
 *
 * 只读属性：
 * 1.委托需要提供一个名为getValue的方法，该方法接收的参数：
 *   - thisRef，必须是属性拥有者相同类型或者是父类型，对于属性来说，类型指的是被扩展的那个类型
 *   - property，需要KProperty<*>(就是属性本身)类型或父类型
 * 2.getValue 方法需要返回与属性相同的类型或是它的子类型
 *
 * 读写属性：
 * 1.委托需要听过一个getValue和setValue方法，该方法需要如下参数：
 *   - thisRef，与getValue方法的thisRef一样。
 *   - property，与getValue方法的property一样。
 *   - newValue，需要与属性类型相同或是它的父类型。
 *
 * 写委托类的两种方式：
 * 1.自己写委托类，必须写getValue和setValue方法，既可以作为委托类的成员方法实现，也可以作为扩展方法来实现，
 * 这两个方法都必须要用operator关键字标记。
 * 2.也可以自己写一个类，然后实现ReadOnlyProperty或ReadWriteProperty接口，这两个接口包含了相应的getValue与setValue方法。
 *
 * 委托转换规则：
 * 对于每个委托属性来说，Kotlin编译器在底层会产生一个辅助的属性，然后把原有属性的访问委托给这个辅助属性，
 * 比如说，属性prop，Kotlin编译器会创建一个名为prop$delegate的属性，访问原有的prop属性，都是调用的prop$delegate的get或set。
 */

/**
 * 提供委托（providing a delegate）
 *
 * 通过定义 provideDelegate operator，可以扩展委托的创建过程。如果对象定义了一个 provideDelegate 方法，
 * 该方法就会被调用来创建属性委托实例。
 *
 */
class PropertyDelegate : ReadOnlyProperty<People, String> {
    override fun getValue(thisRef: People, property: KProperty<*>): String {
        return "hello world"
    }
}

class PeopleLauncher {
    operator fun provideDelegate(thisRef: People, property: KProperty<*>): PropertyDelegate {
        println("welcome")

        when (property.name) {
            "name", "address1" -> return PropertyDelegate()
            else -> throw Exception("not valid name")
        }
    }
}

class People {
    val name: String by PeopleLauncher()
    val address: String by PeopleLauncher()
}

fun main() {
    val people = People()
    println(people.name)
    println(people.address)
}
/**
 * PeopleLauncher是一个提供委托的类，他没有提供getValue和setValue的方法，只有一个provideDelegate方法，
 * 这个方法会自动调用，根据属性的名字，返回PropertyDelegate委托。
 */
