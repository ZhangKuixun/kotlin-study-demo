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
 * 重要的API
 *
 * CoroutineScope：
 * 文档：
 * 为新的协程定义一个作用域。每一个协程构建器都是CoroutineScope的一个扩展，并且继承
 * CoroutineScope.coroutineContext去自动传播上下文元素和可取消的特性。
 *
 * 获取scope实例最佳的方式是用CoroutineScope()和工厂函数MainScope()，CoroutineScope.plus
 * 可以把额外的context元素可以被追加到作用域上。
 *
 * 不推荐手动实现CoroutineScope接口，优先使用委托的方式，根据约定，作用域的上下文（
 * CoroutineScope.coroutineContext）应该包含一个Job的实例，去强制结构化的并发。
 *
 * 每一个协程构造器（比如：launch、async...）和作用域函数（比如：coroutineScope、withContext...）
 * ，都提供了它自己的scope和自己的job实例到它运行的代码块中。根据约定，协程里面又套了一个协程，
 * 外部的协程要等待里面的协程完成后，外部的协程才会真正执行，这样可以强化结构化的并发原则。
 *
 * CoroutineScope应该在实体类中被实现或者作为一个域，使用一种定义良好的生命周期，它们负责启动子协
 * 程，比如：Android上的实体类是Activity。
 * 接口的使用例子：
 * class MyActivity : AppCompatActivity(), CoroutineScope by MainScope() {
 *     override fun onDestroy() {
 *         cancel()
 *     }
 *     /*注意：协程构造器是如何scoped：如果activity被销毁或任何启动的协程在方法中抛出异常了，
 *     然后所有嵌套的协程都会被取消。*/
 *     fun showSomeData() = launch {
 *        draw(data)
 *     }
 * }
 *
 *
 * launch：
 * public fun CoroutineScope.launch(
 *     context: CoroutineContext = EmptyCoroutineContext,
 *     start: CoroutineStart = CoroutineStart.DEFAULT,
 *     block: suspend CoroutineScope.() -> Unit
 * ): Job
 *
 * 构造方法：
 * launch返回Job对象，launch有三个参数，前两个有默认值，第三个参数block，它是一个lambda表达式，
 * 不接收参数，没有返回值。
 * start：参数2，控制启动行为
 * suspend：定义一个挂起函数，后面会讲，suspend函数只能用在另一个suspend函数中、协程中。普通函数
 * 可以用在任何地方。
 *
 * 文档：
 * 在后台启动一个新的协程并且会立刻执行，不会阻塞当前线程，并且会以Job形式返回一个协程引用，Job
 * 表示协程代码的执行逻辑，当返回的Job被取消，协程也会被取消。
 *
 * 协程上下文继承CoroutineScope，额外的context元素可以从参数中传入，如果传入的context不包含任何
 * dispatcher或ContinuationInterceptor，会使用第二个参数的默认值Dispatchers.Default。父Job也
 * 会继承CoroutineScope，但是它也可以被coroutineContext覆盖。
 *
 * 在默认情况下，协程会立刻执行。其他的启动选项可以通过指定start参数，参考CoroutineStart了解详细
 * 信息。start参数设置为CoroutineStart.LAZY，延迟启动协程，这种情况下，协程Job会以new的方式被创
 * 建，它会被Job.start函数显式启动，并且当第一次调用Job.join的时候会被隐式启动。
 *
 * 在默认context中，协程中的未捕获异常会取消父Job，除非显式指定处理器CoroutineExceptionHandler，
 * 意思是使用launch函数并且搭配另一个协程的context，那么任何未捕获异常都会导致父协程被取消。
 *
 *
 * CoroutineStart：
 * 为协程构造器定义启动选项。它被用在CoroutineScope.launch、CoroutineScope.async或协程构造器函
 * 数的start参数。
 *
 * CoroutineStart的选项：
 * DEFAULT：根据协程的context立刻执行，默认；
 * LAZY：延迟启动协程，需要的时候才启动；
 * ATOMIC：原子性的，根据协程的context以一种不可取消的方式执行；
 * UNDISPATCHED：立刻执行协程，直到遇到当前线程中的第一个挂起点。
 *
 */