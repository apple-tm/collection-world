package com.example.collection.set;

import com.example.collection.User;

import java.util.Set;

/**
 * TreeSet
 * 1.底层就是 TreeMap，只使用了 key，value 全部指向一个 Object 常量
 * 2.有序(比较器)
 * 3.元素唯一
 */
public class TreeSetTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Set<User> treeSet  =  User.treeSet;
        treeSet.forEach(e -> System.out.println(e));
    }
}
