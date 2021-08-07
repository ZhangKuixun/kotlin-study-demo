package com.kevin.coroutines4

import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/7/28
 * describe：
 * Job的使用
 * 如果在协程的代码块中，如何获取Job本身？
 * 协程的Job属于协程上下文（coroutineContext）的一部分：通过this.coroutineContext[Job]表达式获取Job对象。
 *
 */
fun main() = runBlocking<Unit> {
    val job: Job? = coroutineContext[Job]
    println(job)
    //打印：BlockingCoroutine{Active}@6e5e91e4

    println(coroutineContext.isActive)//true
    println(coroutineContext[Job]?.isActive)//true
}
/**
 * 分析：
 * BlockingCoroutine{Active}@6e5e91e4：BlockingCoroutine是阻塞的协程，{Active}处于活动状态，
 * @6e5e91e4一个Hash值。
 *
 * 为什么能在这里用coroutineContext？
 * coroutineContext是CoroutineScope的变量，runBlocking是一个可阻塞的协程，runBlocking最终
 * 调用BlockingCoroutine，它继承了CoroutineScope，所以可以去使用。
 *
 * CoroutineScope的coroutineContext
 * 文档：
 * 协程作用域的上下文，上下文通过一个封装，并且用于协程构建器的实现，构建器实际是作用域的一个扩展。
 * 通常的代码中不建议被使用，除了访问Job实例。根据约定，应该包含一个Job的实例去强制的结构化的并发。
 *
 * CoroutineContext：
 * 文档：
 * 协程的持久上下文。它是[Element]实例的索引集合，索引集合是介于set和map之间，索引集合的每一个
 * 元素都有唯一的key。
 *
 *
 * 为什么能在这里用Job？
 * public interface Job : CoroutineContext.Element {
 *     public companion object Key : CoroutineContext.Key<Job> {}
 * }
 * 因为在Job里面定义了一个伴生对象Key，伴生对象里面的泛型就是Job。
 *
 */
