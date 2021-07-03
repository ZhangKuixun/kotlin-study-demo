package com.kevin.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * other：Kevin
 * create time：2021/7/3
 * describe：
 */
public class Tom2 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 4, 21, 21, 23, 42, 51, 35, 13);

//        integers.stream().map(item->item*10).collect(Collectors.toList());
//        //.map(item->item*10)是中间操作。把水收集起来，沉淀消毒，处理成干净的水。
//        //.collect(Collectors.toList())是结束操作。水入户后，把水冲马桶了，又回收起来。
//        //.forEach(item -> System.out.println(item));消费操作。水入户后，把水浇花了，不能回收了。

//        Optional<Integer> optional =
        integers.stream()//把数组变成流
                .map(item -> item * 10)//映射。把数组的值映射为原来值的10倍。
                .filter(item -> item > 10)//把大于10的值都过滤掉。
                .sorted((item1, item2) -> item1 - item2)//排序。第一个参数减第二个参数，正序。第二个减第一个，倒序。
                .distinct()//去除重复元素
//                .reduce((item1, item2) -> item1 + item2);//归约，返回Optional<T>。把每个元素累加。
//                .forEach(item -> System.out.println(item));//最后把每个值都使用了，不用返回。
                .forEach(System.out::println);//使用的就只有传入的参数，方法体只有这一个方法，可以简化代码。
//        System.out.println(optional.get());
    }
}
/**
 * Stream 流
 * 能应用在数组上，一次执行的操作序列。Stream操作分为中间操作、最终操作，最终操作返回特定类型的计算结果，
 * 中间操作返回Stream本身，这样你就可以将多个操作依次串起来。
 * 创建Stream要指定一个数据源，比如collection的子类list、set，这些都可以变成一个流，不支持map。
 */






