package com.example.collection.iterator;

import com.example.collection.User;

import java.util.Iterator;
import java.util.List;

/**
 * 迭代器
 * 1.遍历集合
 * 2.迭代器可以在迭代中删除集合元素，for 类型的遍历删除元素会ConcurrentModificationException异常
 * 3.集合对象.iterator 获取迭代器
 * 4.hasNext() next() remove()
 * 5.public interface Collection<E> extends Iterable<E> Collection 继承 Iterable 接口
 * 6.public interface list<E> extends Collection<E> list 继承 Collection
 * 7.ArrayList 实现了 list
 */
public class IteratorTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        List<User> userList = User.userList;
        Iterator iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            if (user.getUserId()%2 == 0) {
                iterator.remove();
            }
        }
        userList.forEach(e -> System.out.println(e.getUserName()));
    }

    public static  void test2() {
        List<User> userList = User.userList;

        userList.forEach(e -> {
            if (e.getUserId() % 2 == 0) {
                // ConcurrentModificationException
                userList.remove(e);
            }
        });
    }
}
