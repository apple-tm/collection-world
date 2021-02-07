package com.example.collection.java8;

import java.lang.annotation.*;

/**
 * 重复注解
 * 1.getAnnotationsByType：java8 新特性类类型获取注解
 * 2.注解也是一种类
 */
public class RepeatAnnotation {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters {
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    public @interface Filter {
        String value();
    }

    @Filter("filter1")
    @Filter("filter2")
    public interface FilterAble {

    }

    public static void main(String[] args) {
        for (Filter filter : FilterAble.class.getAnnotationsByType(Filter.class)) {
            System.out.println(filter);
        }
    }
}
