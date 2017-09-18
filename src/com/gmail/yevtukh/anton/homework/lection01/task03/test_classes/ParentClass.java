package com.gmail.yevtukh.anton.homework.lection01.task03.test_classes;

import com.gmail.yevtukh.anton.homework.lection01.task03.Save;

/**
 * Created by Anton on 18.09.2017.
 */
public class ParentClass {

    @Save
    private int intField;
    @Save
    private Integer integerField;
    @Save
    private String stringField;

    public ParentClass(int intField, Integer integerField, String stringField) {
        this.intField = intField;
        this.integerField = integerField;
        this.stringField = stringField;
    }

    public ParentClass(ParentClass parentClass) {
        this.intField = parentClass.intField;
        this.integerField = parentClass.integerField;
        this.stringField = parentClass.stringField;
    }

    //TODO
    @Override
    public String toString() {
        return "BaseClass{" +
                "intField=" + intField +
                ", integerField=" + integerField +
                ", stringField='" + stringField + '\'' +
                '}';
    }
}
