package com.example.collection.list;

import com.example.collection.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ArrayListTest {

    private int cursor;

    public static void main(String[] args) {
        ArrayListTest arrayListTest = new ArrayListTest();
        arrayListTest.test();
    }

    public void test() {
        int i = cursor;

        int[] a = {1, 4, 7};
        int j = -1;
        int k = a[j = i];

        // 1.这两个空数组的容器数组不相同
        List<User> userList = new ArrayList<>();
        List<User> userList2 = new ArrayList<>(0);

        userList.add(new User(123, "user123", LocalDate.now()));
        // 2.rangCheck:IndexOutOfBoundsException
        System.out.println(userList.get(0));
        // 3.set 方法返回index位置元素+设置index 新元素
        User userOld = userList.set(0, new User(1234, "user123", LocalDate.now()));
        System.out.println(userOld);
        System.out.println(userList.get(0));
        // 4.remove() 删除元素+返回被删除元素（其实是直接将被删除的元素之后的元素向前移动一位，最后一位赋值为 null） elementData[--size] = null, clear to let GC do its work
        User user3 = userList.remove(0);
        // 5•删除元素时不会减少容量，若希望减少容量则调用trimToSize() 这说明 trimToSize 不是 List 的接口方法
        ((ArrayList<User>) userList).trimToSize();
        System.out.println(user3);
        System.out.println(userList.size());
        // 6.线程安全转换Collections.synchronizedList(List)
        List<User> user4 = Collections.synchronizedList(userList);

        // 7.ListIterator可以往前遍历，添加元素，设置元素
        ListIterator<User> userListIterator = userList.listIterator();

    }
}

