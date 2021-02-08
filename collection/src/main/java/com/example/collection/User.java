package com.example.collection;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class User implements Comparable<User> {

    private Integer userId;

    private String userName;

    private LocalDate birthday;

    public final static List<User> userList = new ArrayList<>(10);
    public final static List<User> userLinkedList = new LinkedList<>();
    public final static Map<Integer,User> userMap = new HashMap<>((int)Math.ceil(10/0.75));
    public final static Map<Integer,User> userLinkedMap = new LinkedHashMap<>((int)Math.ceil(10/0.75));
    public final static Map<Integer,User> userAccessOrderLinkedMap = new LinkedHashMap<>((int)Math.ceil(10/0.75), 0.75f,true);
    public final static Map<Integer,User> userTreeMap = new TreeMap<>();
    public final static Map<User,User> userTreeMap2 = new TreeMap<>();
    public final static Set<User> hashSet = new HashSet<>();
    public final static Set<User> treeSet = new TreeSet<>();
    public final static Set<User> linkedHashSet = new LinkedHashSet<>();
    public final static List<User> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    public final static Set<User> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
    static {
        for (int i=0; i<10; i++) {
            User user = new User();
            user.setUserId(i);
            user.setUserName("user" + i*i + i);
            user.setBirthday(LocalDate.now());
            userList.add(user);
            userLinkedList.add(user);
            userMap.put(user.getUserId(),user);
            userLinkedMap.put(user.getUserId(),user);
            userAccessOrderLinkedMap.put(user.getUserId(),user);
            userTreeMap.put(user.getUserId(), user);
            userTreeMap2.put(user, user);
            hashSet.add(user);
            treeSet.add(user);
            linkedHashSet.add(user);
            copyOnWriteArrayList.add(user);
            copyOnWriteArraySet.add(user);
        }
    }

    public User() {
    }

    public User(Integer userId, String userName, LocalDate birthday) {
        this.userId = userId;
        this.userName = userName;
        this.birthday = birthday;
    }

    @Override
    public int compareTo(User o) {
        // 按 ID 逆序
        return o.getUserId() - this.userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getUserId() != null ? !getUserId().equals(user.getUserId()) : user.getUserId() != null) return false;
        if (getUserName() != null ? !getUserName().equals(user.getUserName()) : user.getUserName() != null)
            return false;
        return getBirthday() != null ? getBirthday().equals(user.getBirthday()) : user.getBirthday() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserId() != null ? getUserId().hashCode() : 0;
        result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
        result = 31 * result + (getBirthday() != null ? getBirthday().hashCode() : 0);
        return result;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
