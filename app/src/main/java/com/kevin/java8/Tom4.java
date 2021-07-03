package com.kevin.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * other：Kevin
 * create time：2021/7/3
 * describe：
 */
public class Tom4 {
    public static void main(String[] args) {
        ArrayList<Double> doubles = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            double random = Math.random();
            doubles.add(random);
        }

        long start = System.currentTimeMillis();
        List<Double> collect = doubles.stream().sorted().collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("串行流=" + (end - start));//910

        long start1 = System.currentTimeMillis();
        List<Double> collect1 = doubles.parallelStream().sorted().collect(Collectors.toList());
        long end1 = System.currentTimeMillis();
        System.out.println("并行流=" + (end1 - start1));//414
    }
}
/**
 * 串行流和并行流的使用注意点：
 * 1.串行流是单线程，慢，并行流是多线程，快。
 * 2.并行流可能会把cpu拉爆，其他的程序也会调用cpu。
 */
