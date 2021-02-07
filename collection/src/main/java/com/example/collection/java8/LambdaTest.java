package com.example.collection.java8;

import java.util.Arrays;
import java.util.Comparator;

/**
 * lambda
 * 1.允许将函数作为参数传递给方法（函数式编程、类似 js、python 的函数语法）
 * 2.JVM平台上的语言（Groovy、Scala等）从诞生之日就支持Lambda表达式
 * 3.java8 之前版本只能使用匿名内部类代替Lambda表达式（new Runnable 创建一个线程）
 */
public class LambdaTest {

    public static void main(String[] args) {
//        // 1.e -> System.out.println(e) 作为参数
//        // 2.e的类型由编译器检测得出
//        Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));
//        // 3.集合类型也可以指定 (String e)
//        Arrays.asList("a", "b", "d").forEach((String e) -> System.out.println(e));
//        // 4.lambda 使用函数体
//        Arrays.asList("a", "b", "d").forEach((String e) -> {
//            System.out.println(2);
//            System.out.println(e);
//        });
//        // 5.lambda表达式引用成员变量和局部变量隐式转换为 final 修饰
//        String separator = ",";
//        Arrays.asList("a", "b", "d").forEach((String e) -> {
//            System.out.println(e+separator);
//        });

//        // 6.表达式返回值编译器可以得出，表达式只有一行可以不写 return
//        Arrays.asList("a", "e", "d").sort((String e1,String e2) -> e1.compareTo(e2));
    }
}
