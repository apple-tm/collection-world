package com.example.collection.map;

import com.example.collection.User;

import java.util.Map;

/**
 * TreeMap
 *
 * 1.红黑 tree 实现，查询 log n,有序
 * 2.有序，使用比较器比较 key和排序，就是 treemap 的有序是 key 有序（可比较接口对应比较器、可迭代接口对应迭代器）
 * 3.TreeMap有序是通过Comparator来进行比较的，如果comparator为null，那么就使用自然顺序(使用key 的比较器，如果没有 cannot be cast to java.lang.Comparable)~
 * 4.key 必须实现比较器,或者使用构造方法传递一个匿名比较器（类似匿名线程对象的创建）
 */
public class TreeMapTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        // 1.User 对象实现可比较接口，比较逻辑逆序
        Map<User, User> treeMap = User.userTreeMap2;
        treeMap.forEach((e1, e2)  -> System.out.println(e2));

        Map<Integer, User> treeMap2 = User.userTreeMap;
        treeMap2.forEach((e1, e2)  -> System.out.println(e2));


    }
}
