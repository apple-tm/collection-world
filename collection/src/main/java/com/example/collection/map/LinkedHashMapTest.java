package com.example.collection.map;

import com.example.collection.User;

import java.util.Map;

/**
 * LinkedHashMap
 *
 * 1.extends HashMap
 * 2.底层数据结构为双向链表+hash 表
 * 3.插入有序（链表特性） 想要 Map 有序使用
 * 4.两种顺序，默认插入顺序，还有一种访问顺序（get 元素后(结构性改变)，该元素被置于链表末尾）
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Map<Integer, User> linkedHashMap = User.userLinkedMap;
        // 1.默认遍历顺序为插入顺序
        linkedHashMap.forEach((e1, e2) -> System.out.println(e2));
        Map<Integer, User> linkedHashMapByAccessOrder = User.userAccessOrderLinkedMap;
        linkedHashMapByAccessOrder.get(3);
        System.out.println(linkedHashMapByAccessOrder.get(3));
        // 2.构造方法设置为访问顺序访问
        linkedHashMapByAccessOrder.forEach((e1, e2) -> System.out.println(e2));
    }
}
