package com.kevin.kotlin2

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
 * Kotlin：声明处协变；Java：使用处协变
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

fun main() {
    /**
     * 对于out泛型来说，我们可以将子类型对象赋值给父类型引用
     *
     * 分析：var producer2: Producer<Fruit> = AppleProducer()
     * 把AppleProducer()的实例赋值给了Producer<Fruit>类型的producer2，当调用producer2的produce方法的时候，返回的是Apple类型，
     * producer2是Producer<Fruit>类型，本来produce方法应该返回Fruit类型，但是，当程序真正在运行期的时候
     * AppleProducer()返回的是Apple类型，根据多态，本来要返回Fruit，可以返回Apple，对于使用者的角度来看，
     * 他看到的返回值就是Fruit类型。
     */
    var producer1: Producer<Fruit> = FruitProducer()
    var producer2: Producer<Fruit> = AppleProducer()
    var producer3: Producer<Fruit> = ApplePearProducer()

    println("----------")

    /**
     * 对于"in"泛型来说，我们可以将父类型对象赋值给子类型引用
     *
     * 分析：var consumer2: Consumer<ApplePear> = Man()
     * consumer2本身是Consumer<ApplePear>类型，当调用consumer2的consume方法的时候，只能往consume里面传ApplePear对象，
     * 而它运行期的对象是Man()，Man里面的consume方法要求接收的是一个apple类型，根据consumer2申明的类型Consumer<ApplePear>，
     * 只能往consume方法里面传入的是applePear类型，applePear类型是Apple的子类型，根据多态，consume方法要求传入的是Apple对象，
     * 实际使用的时候往里面传入的是applePear对象，applePear是Apple的子类型，这种操作是成立的。
     */
    var consumer1: Consumer<ApplePear> = Human()
    var consumer2: Consumer<ApplePear> = Man()
    var consumer3: Consumer<ApplePear> = Boy()
}

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
