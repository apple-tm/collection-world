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
 * 8.for 删除 list 报错原理 modcount,每次add或者remove它的值都会加1,用来检查列表中的元素是否发生结构性变化,
 * 主要在多线程环境下需要使用，防止一个线程正在迭代遍历，另一个线程修改了这个列表的结构。报错ConcurrentModificationException
 * 9.迭代器删除、添加元素要使用迭代器对象，使用集合对象会报错
 * 10.Iterator 是工作在一个独立的线程中，Iterator 被创建之后会建立一个指向原来对象的单链索引表，
 * 当原来的对象数量发生变化时，这个索引表的内容不会同步改变，所以当索引指针往后移动的时候就找不到要
 * 迭代的对象，所以按照 fail-fast 原则 Iterator 会马上抛出 java.util.ConcurrentModificationException
 * 11.Iterator 在工作的时候是不允许被迭代的对象被改变的。使用 Iterator 本身的方法 remove() 来删除对象， Iterator.remove()
 * 方法会在删除当前迭代对象的同时维护索引的一致性。
 *
 */
public class IteratorTest {

    public static void main(String[] args) {
        test3();
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
        userList.forEach(e -> System.out.println(e));
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

    public static  void test3() {
        List<User> userList = User.userList;

        userList.forEach(e -> {
            if (e.getUserId() % 2 == 0) {
                // ConcurrentModificationException
                userList.add(e);
            }
        });
    }
}
