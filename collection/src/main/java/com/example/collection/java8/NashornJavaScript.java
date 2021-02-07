package com.example.collection.java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *  Nashorn JavaScript引擎
 *  1.在JVM上开发和运行JS应用。
 *  2.Ctrl + Alt +t 代码快捷键
 */
public class NashornJavaScript {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine js = manager.getEngineByName("JavaScript");
        System.out.println(js.getClass().getName());

        try {
            Object i = js.eval("function f() { return 1;}; f() + 1;");
            System.out.println(i);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
