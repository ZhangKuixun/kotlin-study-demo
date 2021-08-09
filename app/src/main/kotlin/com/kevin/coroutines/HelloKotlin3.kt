package com.kevin.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/7/25
 * describe：
 * runBlocking
 */
fun main() {
    GlobalScope.launch {
        delay(1000)
        println("kotlin coroutines")
    }
    println("hello")
    runBlocking {
        delay(2000)
    }
    println("world")
    //打印：hello；1秒后打印"kotlin coroutines"；2秒后打印"world"
}

/**
 * CoroutineScope：
 * 文档：
 * 为新协程定义一个作用域。协程构建器都是CoroutineScope的扩展，并且继承
 * CoroutineScope.coroutineContext去自动传播上下文元素和可取消的特性。
 *
 * 获取scope实例最佳的方式是用CoroutineScope()和工厂函数MainScope()，CoroutineScope.plus
 * 可以把额外的context元素可以被追加到作用域上。
 *
 * 不推荐手动实现CoroutineScope接口，优先使用委托的方式，根据约定，作用域的上下文（
 * CoroutineScope.coroutineContext）应该包含一个Job的实例，去强制结构化的并发。
 *
 * 每一个协程构造器和作用域函数，都提供了自己的scope和Job到运行的代码块中。根据约定，协程里面又套
 * 一个协程，外部的协程要等待里面的协程完成后，外部的协程才会真正执行，这样可以强化结构化的并发原则。
 *
 * CoroutineScope应该在实体类中被实现或作为一个域，使用一种定义良好的生命周期，它们负责启动子协程。
 * 接口的使用例子：
 * class MyActivity : AppCompatActivity(), CoroutineScope by MainScope() {
 *     override fun onDestroy() {
 *         cancel()
 *     }
 *     /*注意：activity被销毁或协程抛出异常，所有嵌套协程都会被取消。*/
 *     fun showSomeData() = launch {
 *        draw(data)
 *     }
 * }
 *
 *
 * launch：
 * 文档：
 * public fun CoroutineScope.launch(
 *     context: CoroutineContext = EmptyCoroutineContext,
 *     start: CoroutineStart = CoroutineStart.DEFAULT,
 *     block: suspend CoroutineScope.() -> Unit
 * ): Job
 * launch返回Job对象，launch有三个参数，前两个有默认值，第三个参数block是lambda表达式，不接收参
 * 数，没有返回值。
 * start：参数2，控制启动行为
 * suspend：定义一个挂起函数，后面会讲，suspend函数只能用在另一个suspend函数、协程、流。普通函数
 * 可以用在任何地方。
 *
 * 文档：
 * 在后台启动一个新的协程并立刻执行，不阻塞线程，返回一个Job，Job表示协程代码的执行逻辑，返回的Job
 * 被取消，协程也会被取消。
 *
 * 协程上下文继承CoroutineScope，额外的context元素可以从第一个参数传入，如果传入的context不包含
 * dispatcher或ContinuationInterceptor，会使用第二个默认参数Dispatchers.Default。父Job会继承
 * CoroutineScope，可以被coroutineContext覆盖。
 *
 * 默认情况下，协程会立刻执行。第二个参数start指定启动选项，参考CoroutineStart了解详细信息。start
 * 参数设置为CoroutineStart.LAZY，延迟启动协程，这种情况下，协程Job会以new的方式被创建，它会被
 * Job.start显式启动，并且当第一次调用Job.join的时候会被隐式启动。
 *
 * 在默认context中，协程的未捕获异常会取消父Job，除非显式指定处理器CoroutineExceptionHandler，
 * 这意味着launch函数与另一个协程的context一起使用，任何未捕获异常都会导致父协程被取消。
 *
 *
 * CoroutineStart：
 * 文档：
 * 为协程构造器定义启动选项。它被用在CoroutineScope.launch、CoroutineScope.async、协程构造器函
 * 数的start参数。
 *
 * CoroutineStart的选项：
 * DEFAULT：根据协程的context立刻执行，默认；
 * LAZY：延迟启动协程，需要的时候才启动；
 * ATOMIC：原子性的，根据协程的context以一种不可取消的方式执行；
 * UNDISPATCHED：立刻执行协程，直到遇到当前线程中的第一个挂起点。
 *
 */