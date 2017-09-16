package com.gmail.yevtukh.anton.homework.lection01.task02;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Anton on 16.09.2017.
 */
public class Saver {

    public static void save(TextContainer textContainer) {
        Class<?> textContainerClass = textContainer.getClass();
        boolean success = false;

        if (!textContainerClass.isAnnotationPresent(SaveTo.class))
            System.err.println("Annotation SaveTo is not present in TextContainer class declaration");

        String savePath = textContainerClass.getAnnotation(SaveTo.class).path();

        try {
            for (Method method : textContainerClass.getMethods()) {
                if (method.isAnnotationPresent(Save.class)) {
                    method.setAccessible(true);
                    method.invoke(textContainer, savePath);
                    success = true;
                    break;
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.err.println("Error calling \"save()\" method");
            e.printStackTrace();
        }

        if (!success)
            System.out.println("Failed to find \"save()\" method in the TextContainer class.");
        else
            System.out.println("TextContainer content successfully saved into:\n" + savePath);

    }
}
