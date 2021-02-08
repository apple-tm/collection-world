package com.example.collection.set;

import com.example.collection.User;

import java.util.Set;

/**
 * LinkedHashSet
 * 1.底层就是 LinkedHashMap ，双向链表+散列表
 * 2.有序，插入顺序,比较器不会被使用
 * 3.链表的初始化容量与迭代无关
 */
public class LinkedHashSet {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Set<User> linkedHashSet = User.linkedHashSet;
        linkedHashSet.forEach(e -> System.out.println(e));
    }
}
