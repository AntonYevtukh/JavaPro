package com.gmail.yevtukh.anton.homework.lection01.task03;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Anton on 16.09.2017.
 */
public class ClassA {

    private int i;
    private Integer I;
    private String s;
    private int[] iArray;
    private String[] sArray;

    public ClassA(boolean manual) {
        if (manual) {
            i = 1;
            I = 2;
            s = "HelloWorld";
            iArray = new int[]{1, 2, 3};
            sArray = new String[]{"one", "two", "three"};
        }
    }

    @Override
    public String toString() {
        return "ClassA{" +
                "i=" + i +
                ", I=" + I +
                ", s='" + s + '\'' +
                ", iArray=" + Arrays.toString(iArray) +
                ", sArray=" + Arrays.toString(sArray) +
                '}';
    }
}
