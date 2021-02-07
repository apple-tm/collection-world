package com.example.collection.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MethodRefer {

    public static MethodRefer create(final Supplier<MethodRefer> supplier) {
        return supplier.get();
    }

    public static void test1(final MethodRefer methodRefer) {
        System.out.println(methodRefer.toString());
    }

    public void test2(final MethodRefer methodRefer) {
        System.out.println(methodRefer.toString());
    }

    public void test3() {
        System.out.println(this.toString());
    }

    public static void main(String[] args) {
        // 1.方法引用的类型是构造器引用
        MethodRefer methodRefer1 = MethodRefer.create(MethodRefer::new);
        List<MethodRefer> list = Arrays.asList(methodRefer1);

        // 2.方法引用的类型是静态方法
        list.forEach(MethodRefer::test1);

        // 3.方法引用的类型是成员方法并且方法没有入参（可以使用类引用）
        list.forEach(MethodRefer::test3);

        // 4.方法引用的类型是成员方法有入参（只能使用对象引用）
        list.forEach(methodRefer1::test2);
    }
}
