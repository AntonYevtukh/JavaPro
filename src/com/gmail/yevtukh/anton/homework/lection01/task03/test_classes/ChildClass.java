package com.gmail.yevtukh.anton.homework.lection01.task03.test_classes;

import com.gmail.yevtukh.anton.homework.lection01.task03.Save;

import java.util.Arrays;

/**
 * Created by Anton on 18.09.2017.
 */
public class ChildClass extends ParentClass {

    @Save
    private double[] doubleArray;
    @Save
    private Boolean booleanField;
    private String nonSavedField;

    public ChildClass() {
        super(0,0,null);
    }

    public ChildClass(ParentClass parentClass, double[] doubleArray, Boolean booleanField, String nonSavedField) {
        super(parentClass);
        this.doubleArray = doubleArray;
        this.booleanField = booleanField;
        this.nonSavedField = nonSavedField;
    }

    //TODO
    @Override
    public String toString() {
        return super.toString() +
                "ChildClass{" +
                "doubleArray=" + Arrays.toString(doubleArray) +
                ", booleanField=" + booleanField +
                ", nonSavedField='" + nonSavedField + '\'' +
                '}';
    }
}
