package com.gmail.yevtukh.anton.homework.lection01.task03;

/**
 * Created by Anton on 17.09.2017.
 */
public class ClassB extends ClassA {

    private int i = 0;
    private ClassA classA;

    ClassB (boolean manual) {
        super(manual);
        if (manual) {
            classA = new ClassA(manual);
            i = 14;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "ClassB{" +
                "i=" + i +
                ", classA=" + classA +
                '}';
    }
}
