package com.example.collection.list;

import com.example.collection.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ListIterator;

/**
 * ListIterator list 增强迭代器
 * 1.有add()方法，可以向List中添加对象，而Iterator不能。
 * 2.ListIterator和Iterator都有hasNext()和next()方法，可以实现顺序向后遍历。但是ListIterator有hasPrevious()和previous()方法，可以实现逆向（顺序向前）遍历。Iterator就不可以。
 * 3.ListIterator可以定位当前的索引位置，nextIndex()和previousIndex()可以实现。Iterator 没有此功能。
 * 4.都可实现删除对象，但是ListIterator可以实现对象的修改，set()方法可以实现。Iterator仅能遍历，不能修改。因为ListIterator的这些功能，可以实现对LinkedList等List数据结构的操作。
 */
public class ListTest {

    public static void main(String[] args) {
        test2();
    }

    public static void test() {
        List<User> userList = User.userList;
        // list 实现的迭代器，方法更多
        // 1.此时，迭代器指向Iterator_one位置, 强制转化时考虑泛型，用泛型替代强制优先
        ListIterator<User> listIterator = userList.listIterator();
        // 2.此时，迭代器指向Iterator_two位置
        User user2 = listIterator.next();
        // 3.迭代器指向Iterator_two位置, remove 删除却是第一个位置的元素
        listIterator.remove();
        // 4.指向上一个位置，就是 remove 掉的第一个位置,报错， 直接 add 就会在删除的位置上添加，就是先 remove 再 add
        // listIterator.previous();
        listIterator.add(new User(-1, "user-1", LocalDate.now()));

        // 5.将指向位置重新初始化到Iterator_one位置
        listIterator = userList.listIterator();

        // 6.执行完 while 迭代器游标指向最后一个元素
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        // 7.set 方法直接覆盖当前游标指向的元素
        listIterator.set(new User(99, "user99", LocalDate.now()));
        userList.forEach(e-> System.out.println(e));
    }

    public static void test2() {
        List<User> userList = User.userList;
        // 8.指定迭代器起游标 wc index 从 0 开始，10 个元素的迭代器指定起始位置,previous 才能获取到 9
        ListIterator<User> listIterator = userList.listIterator(10);
        while(listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
        // 9.获取当前游标的上一个位置，反向遍历完成，所有游标为 0，上一个位置就是-1
        System.out.println(listIterator.previousIndex());
        while(listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        // 10.获取当前游标的下一个位置，正向遍历到最后一个位置，所有下一个为为 size - 1 + 1
        System.out.println(listIterator.nextIndex());

    }

}
