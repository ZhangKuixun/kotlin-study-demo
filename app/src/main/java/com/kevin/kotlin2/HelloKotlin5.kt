package com.kevin.kotlin2


/**
 * other：Kevin
 * create time：2021/6/22
 * describe：
 * 深入讲解：协变和逆变
 * Kotlin：声明处协变（declaration-site variance）；Java：使用处协变
 *
 * Kotlin中的out关键字叫做variance annotation，在参数声明处指定的（declaration-site variance）
 * Java是使用处协变（use-site variance），类型通配符才能写协变。
 */

/**
 * 只将泛型作为方法的输出类型，用out。
 * produce = output = out
 */
interface Producer<out T> {
    fun produce(): T
}

/**
 * 只将泛型类型作为方法的输入类型，用in。
 * consume = input = in
 */
interface Consumer<in T> {
    fun consume(item: T)
}

/**
 * 不变：
 * 同时将泛型作为方法的输入类型与输出类型，使用out与in修饰泛型。（不重要）
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
     * AppleProducer()返回的是Apple类型，根据多态，本来要返回Fruit，可以返回Apple，从使用者的角度来看，
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
