package com.example.collection.list;

import com.example.collection.User;

import java.util.List;

/**
 * CopyOnWriteArrayList
 *
 * 1.Collections.synchronizedList(new ArrayList()) 不是加在方法的声明处，而是方法的内部，vector 加载方法声明处。
 * 2.vector使用时需要加锁，vector 方法在多线程情况下不加锁会报错
 * 3.CopyOnWriteArrayList是同步List的替代品，CopyOnWriteArraySet是同步Set的替代品。
 * 4.Hashtable-->ConcurrentHashMap（ConcurrentHashMap用了cas锁、volatile等方式来实现线程安全），还是说Vector-->CopyOnWriteArrayList。
 * 5.JUC下支持并发的容器与老一代的线程安全类相比，总结起来就是加锁粒度的问题
 * 6.在修改时，复制出一个新数组，修改的操作在新数组中完成，最后将新数组交由array变量指向。写加锁，读不加锁(集合名称体现)
 * 7.缺点：经常修改会占用内存过多，不能保证数据实时一致性
 */
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        List<User> copyOnWriteArrayList = User.copyOnWriteArrayList;
        copyOnWriteArrayList.add(null);
        copyOnWriteArrayList.forEach(e -> System.out.println(e));
    }
}
