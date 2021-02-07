package com.example.collection.java8;

import java.time.Clock;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * parallel 并行处理
 * 1.计算
 * 2.排序
 * 3.性能高、速度快（基于 CPU 核心数）
 * 4.java.util.concurrent.ConcurrentHashMap类添加了新的方法来支持聚焦操作
 * 5.java.util.concurrent.ForkJoinPool类添加了新的方法来支持通用线程池操作
 * 6.java.util.concurrent.locks.StampedLock类，用于支持基于容量的锁——该锁有三个模型用于支持读写操作（可以把这个锁当做是java.util.concurrent.locks.ReadWriteLock的替代者）。
 */
public class ParallelArray {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        long[] longs = new long[120000];
        Arrays.parallelSetAll(longs, e -> ThreadLocalRandom.current().nextLong(1000000));
        Arrays.stream(longs).limit(10).forEach(e -> System.out.println(e));
        long start = Clock.systemUTC().millis();
        Arrays.sort(longs);
        System.out.println(Clock.systemUTC().millis() - start);

        long start2 = Clock.systemUTC().millis();
        // 排序速度快 3-10 倍
        Arrays.parallelSort(longs);
        System.out.println(Clock.systemUTC().millis() - start2);
    }
}
