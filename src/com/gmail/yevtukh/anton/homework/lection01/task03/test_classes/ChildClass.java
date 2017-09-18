package com.gmail.yevtukh.anton.homework.lection01.task03.test_classes;

import com.gmail.yevtukh.anton.homework.lection01.task03.Save;

/**
 * Created by Anton on 18.09.2017.
 */
public class ChildClass extends ParentClass {

    @Save
    private double[] doubleArray;
    @Save
    private Boolean booleanField;
    private Object emptyField = null;

    public ChildClass() {
        super(0,0,null);
    }

    public ChildClass(ParentClass parentClass, double[] doubleArray, Boolean booleanField) {
        super(parentClass);
        this.doubleArray = doubleArray;
        this.booleanField = booleanField;
    }
}
