package com.example.collection.set;

import com.example.collection.User;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * CopyOnWriteArraySet
 * 1.线程安全
 * 2.原理同 copyOnWriteArrayList,包含CopyOnWriteArrayList对象，它是通过CopyOnWriteArrayList实现的
 * 3.wc,这货插入有序，不具有 hashset 的无效特性
 * 4.不能有重复元素
 */
public class CopyOnWriteArraySetTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Set<User> copyOnWriteArraySet = User.copyOnWriteArraySet;
        copyOnWriteArraySet.forEach(e -> System.out.println(e));
    }
}
