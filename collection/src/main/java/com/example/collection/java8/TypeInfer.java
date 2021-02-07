package com.example.collection.java8;

/**
 * 类型推断
 * 1.java8 编译器增强
 */
public class TypeInfer<T> {

    public static<T> T defaultValue() {
        return null;
    }

    public T get(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

    public static void main(String[] args) {
        final TypeInfer<String> typeInfer = new TypeInfer<>();
        typeInfer.get("hello", TypeInfer.<String>defaultValue());
        typeInfer.get("hello", TypeInfer.defaultValue());

    }
}
