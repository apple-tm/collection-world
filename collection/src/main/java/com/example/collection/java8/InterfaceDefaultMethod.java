package com.example.collection.java8;

/**
 * 接口默认方法
 * 1.不改变现有接口实现体系的情况下新增方法
 * 2.官方库中的应用是：给java.util.Collection接口添加新方法，如stream()、parallelStream()、forEach()和removeIf()等等。
 * 3.接口新增一个方法实现类不用强制实现，可以覆盖
 */
public interface InterfaceDefaultMethod {
    void test();

    default String test2() {
        System.out.println("test2");
        return "test2";
    }

    static void test3() {
        System.out.println("test3");
    }
}
