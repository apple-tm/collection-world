package com.example.collection.set;

import com.example.collection.User;

import java.util.Set;

/**
 * HashSet
 * 1.无序
 * 2.底层就是 HashMap，构造方法实现就是 new HashMap,(只使用 key，value 全部为一个 Object 常量)
 * 3.可空
 */
public class HashSetTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Set<User> hashSet = User.hashSet;
        hashSet.forEach(e -> System.out.println(e));
    }
}
