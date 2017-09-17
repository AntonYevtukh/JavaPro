package com.gmail.yevtukh.anton.homework.lection01.task03;

/**
 * Created by Anton on 16.09.2017.
 */
public class Runner {

    public static void main(String[] args) {
        Serializer serializer = new Serializer("D:\\text.txt");
        serializer.serializeObject(new ClassD());
        System.out.println(serializer.deserializeObject(ClassD.class));
    }
}
