package com.gmail.yevtukh.anton.homework.lection01.task03.test_classes;

import com.gmail.yevtukh.anton.homework.lection01.task03.Save;

import java.util.Arrays;

/**
 * Created by Anton on 18.09.2017.
 */
public class ContainerClass {

    @Save
    private ChildClass[] childClassArray;
    @Save
    private short[][] shortMatrix;

    public ContainerClass(ChildClass[] childClassArray, short[][] shortMatrix) {
        this.childClassArray = childClassArray;
        this.shortMatrix = shortMatrix;
    }

    @Override
    public String toString() {
        return "ContainerClass{" +
                "childClassArray=" + Arrays.toString(childClassArray) +
                ", shortMatrix=" + Arrays.toString(shortMatrix) +
                '}';
    }
}
