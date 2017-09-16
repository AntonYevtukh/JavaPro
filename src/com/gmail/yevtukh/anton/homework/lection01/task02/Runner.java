package com.gmail.yevtukh.anton.homework.lection01.task02;

/**
 * Created by Anton on 16.09.2017.
 */
public class Runner {

    public static void main(String[] args) {

        TextContainer textContainer = new TextContainer("Hello, World!");
        Saver.save(textContainer);
    }
}
