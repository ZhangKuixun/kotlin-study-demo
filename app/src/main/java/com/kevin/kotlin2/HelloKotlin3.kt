package com.kevin.kotlin2

import android.annotation.SuppressLint
import java.lang.AssertionError

/**
 * other：Kevin
 * create time：2021/6/22
 * describe：
 *
 * generics 泛型，变量类型的参数化
 *
 */
//fun main() {
//    val myGeneric = MyGeneric("hello world")// 借助于kotlin的类型推断
//    println(myGeneric.varible)
//}

class MyGeneric<T>(t: T) {
    var varible: T

    init {
        this.varible = t
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 *
 * 泛型中的 协变（covariant）与逆变（controvariant）的概念来源
 *
 * List<String>、List<Object>不相等
 *
 * List<String> list = new ArrayList();
 * List<Object> list2 = list;// 编译失败，假如编译成功
 *
 * list2.add(new Date());// new Date()是Object子类，放入list2中。
 *
 * String str = list.get(0);// 放入list2的是Data()，取出来变成了String了，java不允许。
 *
 * 可以用通配符解决上面的问题。
 * List<? extends Object>，"? extends Object" 限定了类型的上限范围
 *
 *
 * interface Collection<E> {
 *   void addAll(Collection<E> items);// 失败
 * }
 *
 * void copyAll(Collection<Object> to, Collection<String> from) {
 *   to.addAll(from);
 *   // 调用上面的Collection<E>的addAll(Collection<E> items)方法，失败。
 *   // 调用下面的Collection<E>的addAll(Collection<? extends E> items)方法，成功，添加之后把String类型当作Object类型看待。
 * }
 *
 * interface Collection<E> {
 *   void addAll(Collection<? extends E> items);// 成功
 * }
 *
 * Collection<String>不是Collection<Object>的子类型
 * Collection<String>是Collection<? extends Object>的子类型，"? extends Object"规定了上限，只能放入Object以下的类型。----协变
 *
 * List<? super String>，"? super String"规定了下限，只能放入String以及String类型以上的类型。----逆变
 *
 * 只从里面读取数据，不往里面写数据，叫生产者；----协变
 * 只向里面写数据，不从中读取数据，叫消费者。----逆变
 *
 * 生产者使用 ? extends E，消费者使用 ? super E。
 *
 */
//fun main() {
//    val myGeneric = MyGeneric("hello world")// 借助于kotlin的类型推断
//    println(myGeneric.varible)
//
//    println("-------------")
//
//    val myClass = MyClass<String, Number>("abc", 1)
//    myTest(myClass)
//}

class MyClass<out T, in M>(t: T, m: M) {
    private var t: T
    private var m: M

    init {
        this.t = t
        this.m = m
    }

    fun get(): T = this.t

    fun set(m: M) {
        this.m = m
    }
}

fun myTest(myClass: MyClass<String, Number>) {
    // 把String类型的数据写入Any类型，读的时候，读的是Any类型，协变
    // 把Number类型的数据写入Int类型，读的时候，读的是Int类型，逆变
    val myObject: MyClass<Any, Int> = myClass

    println(myObject.get())
}

////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * 分析in、out
 * kotlin中：
 *   Consumer用in，Producer用out
 */
//fun main() {
//    // 协变
//    val parameterizedProducer = ParameterizedProducer("welcome")
//    val myRef: ParameterizedProducer<Any> = parameterizedProducer
//    println(myRef is ParameterizedProducer<Any>)
//    // java的写法：
//    // List<String> list2 = new ArrayList();
//    // List<? extends Object> list = list2;
//
//    println("------------")
//
//    val parameterizedConsumer: ParameterizedConsumer<Number> = ParameterizedConsumer()
//    val myRef2: ParameterizedConsumer<Int> = parameterizedConsumer
//    println(myRef2 is ParameterizedConsumer<Int>)
//    // java的写法：
//    // List<Object> list = new ArrayList();
//    // List<? super String> list2 = list
//}

class ParameterizedProducer<out T>(private val value: T) {
    fun get(): T {
        return this.value
    }
}

class ParameterizedConsumer<in T> {
    fun toString(value: T): String {
        return value.toString()
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * 深入讲解：协变和逆变
 * Kotlin：声明处协变（declaration-site variance）；Java：使用处协变
 *
 * Kotlin中的out关键字叫做variance annotation，因为他是在参数声明处所指定的，因此我们称之为协变（declaration-site variance）
 * Java是使用处协变（use-site variance），类型通配符才能写协变。
 *
 */

/**
 * 如果泛型类只是将泛型作为其方法的输出类型，用out。
 * produce = output = out
 */
interface Producer<out T> {
    fun produce(): T
}

/**
 * 如果泛型类只是将泛型类型作为其方法的输入类型，用in。
 * consume = input = in
 */
interface Consumer<in T> {
    fun consume(item: T)
}

/**
 * 不变：
 * 如果泛型类型同时将泛型类型作为其方法的输入类型与输出类型，使用out与in来修饰泛型。
 */
interface ProducerConsumer<T> {
    fun produce(): T
    fun consume(item: T)
}

open class Fruit
open class Apple : Fruit()
class ApplePear : Apple()

class FruitProducer : Producer<Fruit> {
    override fun produce(): Fruit {
        println("produce fruit")
        return Fruit()
    }
}

class AppleProducer : Producer<Apple> {
    override fun produce(): Apple {
        println("produce apple")
        return Apple()
    }
}

class ApplePearProducer : Producer<ApplePear> {
    override fun produce(): ApplePear {
        println("produce applePear")
        return ApplePear()
    }
}

//fun main() {
//    /**
//     * 对于out泛型来说，我们可以将子类型对象赋值给父类型引用
//     *
//     * 分析：var producer2: Producer<Fruit> = AppleProducer()
//     * 把AppleProducer()的实例赋值给了Producer<Fruit>类型的producer2，当调用producer2的produce方法的时候，返回的是Apple类型，
//     * producer2是Producer<Fruit>类型，本来produce方法应该返回Fruit类型，但是，当程序真正在运行期的时候
//     * AppleProducer()返回的是Apple类型，根据多态，本来要返回Fruit，可以返回Apple，对于使用者的角度来看，
//     * 他看到的返回值就是Fruit类型。
//     */
//    var producer1: Producer<Fruit> = FruitProducer()
//    var producer2: Producer<Fruit> = AppleProducer()
//    var producer3: Producer<Fruit> = ApplePearProducer()
//
//    println("----------")
//
//    /**
//     * 对于"in"泛型来说，我们可以将父类型对象赋值给子类型引用
//     *
//     * 分析：var consumer2: Consumer<ApplePear> = Man()
//     * consumer2本身是Consumer<ApplePear>类型，当调用consumer2的consume方法的时候，只能往consume里面传ApplePear对象，
//     * 而它运行期的对象是Man()，Man里面的consume方法要求接收的是一个apple类型，根据consumer2申明的类型Consumer<ApplePear>，
//     * 只能往consume方法里面传入的是applePear类型，applePear类型是Apple的子类型，根据多态，consume方法要求传入的是Apple对象，
//     * 实际使用的时候往里面传入的是applePear对象，applePear是Apple的子类型，这种操作是成立的。
//     */
//    var consumer1: Consumer<ApplePear> = Human()
//    var consumer2: Consumer<ApplePear> = Man()
//    var consumer3: Consumer<ApplePear> = Boy()
//}

class Human : Consumer<Fruit> {
    override fun consume(item: Fruit) {
        println("consume Fruit")
    }
}

class Man : Consumer<Apple> {
    override fun consume(item: Apple) {
        println("consume Apple")
    }
}

class Boy : Consumer<ApplePear> {
    override fun consume(item: ApplePear) {
        println("consume ApplePear")
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * use-site variance(type projection)类型投影
 */

@SuppressLint("Assert")
fun copy(from: Array<out Any>, to: Array<Any>) {
    assert(from.size == to.size)

    for (i in from.indices) {
        to[i] = from[i]
    }
}

/**
 * from: Array<out Any>：不能再往参数from写入数据，只能读取数据，这种就是使用处协变，也叫类型投影
 *
 * 本质来看：
 * 假如 from: Array<out Any> 不加out，copy(from, to)能成功，把 from: Array<Int>写入到 from: Array<out Any>，
 * from: Array<out Any> 就变成了 from: Array<Int>，然后 to[i] = from[i] 就相当于把 String写入到Int，就不能写入。
 */

//fun main() {
//    val from: Array<Int> = arrayOf(1, 2, 3, 4)
//    val to: Array<Any> = Array(4) { "hello$it" }
//
//    for (item in to) {
//        println(item)
//    }
//
//    copy(from, to)
//
//    println("------------")
//
//    val array: Array<String> = Array(4) { "hello" }
//    for (item in array) {
//        println(item)
//    }
//    setValue(array, 0, "world")
//    for (item in array) {
//        println(item)
//    }
//
//    val array2: Array<Any> = Array(4) { "hello$it" }
//    for (item in array2) {
//        println(item)
//    }
//    setValue(array2, 1, "world")
//}

/**
 * 本质来看：to: Array<in String>，in表示逆变，传入的setValue的时候使用的是Array<Any>类型，Array<Any>是Array<in String>的父类型，
 * 在setValue的方法中，String类型的value写入Array<Any>类型的array2，可以被写入。
 */

fun setValue(to: Array<in String>, index: Int, value: String) {
    to[index] = value
}

/**
 * Kotlin声明处协变和使用处协变的写法区别：
 * 声明处协变：out T，in T
 * 使用处协变：out Any，in String
 */


////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * 泛型最后一课
 *
 * star projection（星投影）
 * Star<out T>：如果T的上界是TUpper，Star<out T>就可以写成Star<*>，读取过来的值都当作了TUpper类型。
 *
 * Star<in T>: Star<*>，就相当于Star<in Nothing>，Nothing：没有实例，一个什么都不是的值，不能向其中写入任何值。
 *
 * Star<T>，如果T的上界是TUpper，那么Star<*>相当于读取时的Star<out TUpper>，以及写入时的Star<in Nothing>，不能往里写任何内容。
 */
class Star<out T> {
}

class Star2<in T> {
    fun setValue(t: T) {
    }
}

class Star5<T>(private var t: T) {
    fun setValue(t: T) {
    }

    fun getValue(): T {
        return this.t
    }
}

//fun main() {
//    val star: Star<Number> = Star<Int>()
//    val star1: Star<*> = star
//
//    val star3: Star2<Int> = Star2<Number>()
//    val star4: Star2<*> = star3
//
//    // star4.setValue(3) 不能写入Star2<in Nothing>
//    val star6: Star5<String> = Star5("hello")
//    val star7: Star5<*> = star6
//
//    star7.getValue()
//    // star7.setValue() 不能写入Star2<in Nothing>
//
//    val list: MutableList<*> = mutableListOf("hello", "world")
//    println(list[0])
//    // list[0]="test" 不能写入list<Nothing>[0]
//}


////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * 泛型擦除
 */
class MyStorage<out T>(private var t: T) {
    fun getValue(): T {
        return this.t
    }

    fun setValue(t: @UnsafeVariance T) {
        this.t = t
    }
}

//fun main() {
//    val myStorage1: MyStorage<Int> = MyStorage(5)
//    val myStorage2: MyStorage<Any> = myStorage1
//    println(myStorage2.getValue())// 5
//
//    myStorage2.setValue("hello")
//    println(myStorage2.getValue())// hello
//}
/**
 * MyStorage<out T>中的T已经被申明为协变类型了，如果想要修改T，写法：setValue(t: @UnsafeVariance T)，
 * 表示处于协变类型的T作为一个普通方法的输入参数。
 * @UnsafeVariance ：压制协变、逆变的编译错误。
 *
 * 为啥可以这样做？
 * Java泛型的特点，在一个类中声明好了一个泛型，真正进入到字节码的时候，泛型是不存在的，在字节码的层面上，
 * 泛型类型都被当作Object类型来看待，取出来的时候，强制类型向下转换，转换成真正的类型。泛型不会保存到字节码的。
 */

////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * 泛型方法
 */
fun <T> getValue(item: T): T {
    return item
}

fun main() {
    val item = getValue<Int>(3)
    println(item)// 3

    val item2 = getValue("hello")
    println(item2)// hello

    ///////////上界
    val upperBoundsClass = UpperBoundsClass<AbstractList<String>>()

    //////////多个上界
    val upperBoundsClass2 = UpperBoundsClass2<String>()
}

/**
 * <T>表示这个方法是泛型方法，它拥有一个方法泛型类型T，所以将参数声明为T类型，并且返回T类型，最后return item就符合T类型
 */


class UpperBoundsClass<T : List<T>> {
}

/**
 * 定义好一个泛型，可以定义一个泛型的上界。
 * UpperBoundsClass<T : List<T>>：T的上界就是List。
 * 使用：UpperBoundsClass<AbstractList<String>>()，只要是List下面的类型就可以。
 */


class UpperBoundsClass2<T> where T : Comparable<T>, T : Any {
}
/**
 * 两个及两个以上的上界
 * where T : Comparable<T>, T : Any，既要满足T : Comparable<T>，又要满足T : Any，后面的 T : Any 可以不用写
 * 使用：UpperBoundsClass2<String>()，String类型满足Comparable，Any。
 *
 * 注意：
 * Java中，一个泛型没有写上界，任意类型都可以。
 * Kotlin中，一个泛型没有写上界，默认上界是Any?（顶层可空类型）。
 */
