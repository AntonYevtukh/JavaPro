package com.gmail.yevtukh.anton.homework.lection01.task01;

/**
 * Created by Anton on 15.09.2017.
 */
public class TestClass {

    @TestAnnotation(a = 14, b = 88)
    public void test1(int a, int b) {
        System.out.println("Parameters given to method \"test1()\": a = " + a + ", b = " + b + ".");
    }

    @TestAnnotation(a = 10, b = 20)
    public void test2(int a, String b) {
        System.out.println("Parameters given to method \"test2()\": a = " + a + ", b = " + b + ".");
    }
}
