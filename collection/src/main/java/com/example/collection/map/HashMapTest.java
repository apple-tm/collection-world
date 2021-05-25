package com.example.collection.map;

import com.example.collection.User;

import java.time.LocalDate;
import java.util.*;

/**
 * HashMap(数组+hash 表)
 * 1.put 第一个元素会触发resize系统会初始化一个长度为16（初始容量）的Node数组，像极了ArrayList的初始化。
 * 2.负载因子默认 0.75，map 的 size大于 map 容量*负载因子，map 的容量会扩充为之前的 2 倍（为了减少 Hash 冲突）
 * 3.bin单链表 -> 红黑tree 需要 map 容量最小 64 和添加一个 entry 后 Hash 链表的长度等于 8
 * 4.红黑tree->bin单链表,删除一个元素时红黑 tree的节点数为 6，转成长度为 5 的单链表
 * 5.Hashtable（默认容量 11）：扩容（2 倍+1）线程安全，它不允许key和value为null（hashmap key 和 value 可以为 null），使用ConcurrentHashMap替换
 * 6.map 的容量必须为 2 的整数次幂，扩容为原来的 2 倍
 */
public class HashMapTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        // 1.put 返回覆盖的 value 对象(集合的新增和覆盖，删除很多都有这个性质)
        Map<Integer, User> userMap = User.userMap;
        User user = userMap.put(123, new User(123, "user123", LocalDate.now()));
        // 2.hashmap 如果是新增而不是覆盖返回的是 null 代表添加的对象的 key 是本次 put 时没有的 key
        System.out.println(user);
        // userMap.forEach((e1, e2) -> System.out.println(e2));
        User user2 = userMap.put(123, new User(123, "user1234", LocalDate.now()));
        System.out.println(user2);
        // 3. clear 清空 map，remove(由 key 删除) 删除并返回value 对象
        userMap.clear();
        User user5 = userMap.put(123, new User(123, "user1234", LocalDate.now()));
        System.out.println(user5);

        User user3 = userMap.remove(123);
        System.out.println(user3);
        System.out.println(userMap.size());

        // 4.hashmap 转化为 set
        userMap.put(123, new User(123, "user1234", LocalDate.now()));
        userMap.put(1233, new User(1233, "user12344", LocalDate.now()));

        Set<Map.Entry<Integer, User>> set = userMap.entrySet();
//        set.forEach(e-> System.out.println(e));
        // 5.获取 key set(HashSet 的实现就是没有 value 的 hashmap)
        Set<Integer> keySet = userMap.keySet();
        keySet.forEach(e -> System.out.println(e));
        // 6.获取 value 集合
        Collection<User> userList = userMap.values();
        userList.forEach(e -> System.out.println(e));
        // 7.lambda 表达式可以省略 keyset and values 方法输出
        userMap.forEach((e1, e2) -> System.out.println(e2));
    }
}
