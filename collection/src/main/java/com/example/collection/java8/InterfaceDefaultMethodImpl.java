package com.example.collection.java8;

public class InterfaceDefaultMethodImpl implements  InterfaceDefaultMethod{
    @Override
    public void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        InterfaceDefaultMethod interfaceDefaultMethod = new InterfaceDefaultMethodImpl();
        interfaceDefaultMethod.test();
        interfaceDefaultMethod.test2();
        InterfaceDefaultMethod.test3();
    }
}
