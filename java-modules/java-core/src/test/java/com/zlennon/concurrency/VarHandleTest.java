package com.zlennon.concurrency;

import org.junit.Test;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class VarHandleTest {
    private String plainStr;    //普通变量
    private static String staticStr;    //静态变量
    private String reflectStr;    //通过反射生成句柄的变量
    private String[] arrayStr = new String[10];    //数组变量

    private static VarHandle plainVar;    //普通变量句柄
    private static final VarHandle staticVar;    //静态变量句柄
    private static final VarHandle reflectVar;    //反射字段句柄
    private static final VarHandle arrayVar;    //数组句柄

    static {
        try {
            MethodHandles.Lookup l = MethodHandles.lookup();
            plainVar = l.findVarHandle(VarHandleTest.class, "plainStr", String.class);
            staticVar = l.findStaticVarHandle(VarHandleTest.class, "staticStr", String.class);
            reflectVar = l.unreflectVarHandle(VarHandleTest.class.getDeclaredField("reflectStr"));
            arrayVar = MethodHandles.arrayElementVarHandle(String[].class);
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        MethodHandles.Lookup l = MethodHandles.lookup();
        VarHandleTest varHandleTest = new VarHandleTest();
        System.out.println(this.plainStr);
        plainVar.weakCompareAndSet(this,null,"test");
        System.out.println(this.plainStr);
    }
}