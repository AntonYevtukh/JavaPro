package com.gmail.yevtukh.anton.homework.lection01.task01;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Anton on 15.09.2017.
 */
public class Runner {

    public static void main(String[] args) {
        TestClass testClass = new TestClass();

        try {
            Class<?> clazz = testClass.getClass();
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(TestAnnotation.class)) {
                    if (!isParametersMatches(method, TestAnnotation.class)) {
                        System.out.println("The method parameters for annotated method \"" + method.getName() +
                                "\" do not match the annotation parameters");
                        continue;
                    }
                    TestAnnotation testAnnotation = method.getAnnotation(TestAnnotation.class);
                    if (!method.isAccessible())
                        method.setAccessible(true);
                    method.invoke(testClass, getAnnotationParameters(testAnnotation));
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.err.println("Can't call the method");
            e.printStackTrace();
        }
    }

    //Проверить, что параметры аннотации и параметры метода совпадают по количеству и типу
    private static boolean isParametersMatches(Method method, Class<? extends Annotation> annotationClass) {

        Class<?>[] annotationParameterTypes = Arrays.stream(annotationClass.getDeclaredMethods()).
                map(Method::getReturnType).toArray(Class<?>[]::new);
        Class<?>[] methodParameterTypes = method.getParameterTypes();

        if (method.getParameterCount() != annotationParameterTypes.length || method.getParameterCount() == 0)
            return false;
        for (int i = 0; i < methodParameterTypes.length; i++)
            if (methodParameterTypes[i] != annotationParameterTypes[i])
                return false;

        return true;
    }

    //получить параметры(атрбуты) аннотации, используя рефлексию
    private static Object[] getAnnotationParameters(Annotation annotation) {

        //Вся прелесть проверяемых исключенй. А можно как-то изящнее?
        return Arrays.stream(annotation.annotationType().getDeclaredMethods()).map(method -> {
            try {
                return method.invoke(annotation);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        }).toArray();
    }
}