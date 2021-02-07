package com.example.collection.java8;

import com.sun.tools.javac.resources.compiler;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 方法参数名
 * 1.默认关闭
 * 2.-parameters参数编译会得到正确的结果
 */
public class ParameterName {
//    maven 项目添加命令行参数
//    <plugin>
//    <groupId>org.apache.maven.plugins</groupId>
//    <artifactId>maven-compiler-plugin</artifactId>
//    <version>3.1</version>
//    <configuration>
//        <compilerArgument>-parameters</compilerArgument>
//        <source>1.8</source>
//        <target>1.8</target>
//    </configuration>
//    </plugin>

    public static void main(String[] args) {
        try {
//            Method method = ParameterName.class.getMethod("main", String[].class);
//            // 输出 arg0 ，这个特性java8 默认关闭， 带-parameters参数编译会得到正确的结果
//            for (Parameter parameter : method.getParameters()) {
//                System.out.println(parameter.getName());
//            }
            test("123", 11);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test(String s, Integer i) throws Exception {
        Method method = ParameterName.class.getMethod("test", String.class, Integer.class);
        // 输出 arg0 ，这个特性java8 默认关闭， 带-parameters参数编译会得到正确的结果
        for (Parameter parameter : method.getParameters()) {
            System.out.println(parameter.getName());
        }
    }
}
