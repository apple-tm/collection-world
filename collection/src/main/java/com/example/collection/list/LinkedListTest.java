package com.example.collection.list;

import com.example.collection.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * LinkedList
 * 1.双向链表+队列数据结构
 * 2.两个构造方法（一个空参数，一个 Collection 参数）
 * 3.最后一个元素的 next 指向 null 作为遍历的终点
 */
public class LinkedListTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        // 1.add 链表末尾添加新元素 返回 bool
        List<User> userList = User.userLinkedList;
        userList.add(new User(111, "user111", LocalDate.now()));
        userList.forEach(e -> System.out.println(e));
        // 2.remove （存在删除空元素和非空元素 equals(针对对象的实现，两个不同对象内容一致，就是属性值完全一致) 判断）返回 bool
        User user = new User(111, "user111", LocalDate.now());
        userList.add(user);
        System.out.println(user);

        userList.remove(user);
        System.out.println(userList.size());
        // 3.get 方法 index 下标小于链表长度的一半从头遍历，否则从尾部遍历，这是双向链表的优势
        System.out.println(userList.get(0));
        // 4.set 方法 返回被覆盖的对象，同样查询遍历index 下标小于链表长度的一半从头遍历，否则从尾部遍历，这是双向链表的优势
        User user2 = userList.set(0, new User(111, "user111", LocalDate.now()));
        System.out.println(user2);
        System.out.println(userList.get(0));
    }
}
