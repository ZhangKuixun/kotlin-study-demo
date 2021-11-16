package com.kevin.kotlin4

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


/**
 * other：Kevin
 * create time：2021/6/27
 * describe：
 *
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
 */
class PropertyDelegate : ReadOnlyProperty<People, String> {
    override fun getValue(thisRef: People, property: KProperty<*>): String {
        return "hello world"
    }
}

class PeopleLauncher {
    operator fun provideDelegate(thisRef: People, property: KProperty<*>): PropertyDelegate {
        println("welcome")//输出两次

        when (property.name) {
            "name", "address1" -> return PropertyDelegate()
            else -> throw Exception("无效的名称")
        }
    }
}

class People {
    val name: String by PeopleLauncher()//welcome
    val address: String by PeopleLauncher()//抛出异常
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
