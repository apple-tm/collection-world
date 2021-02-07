package com.example.collection.java8;

import java.util.Optional;

/**
 * 避免空指针判断逻辑污染源代码
 */
public class OptionalTest {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Optional<String> fullName = Optional.ofNullable(null);
        System.out.println(fullName.isPresent());

        System.out.println(fullName.orElseGet(() -> "[none]"));
    }
}
