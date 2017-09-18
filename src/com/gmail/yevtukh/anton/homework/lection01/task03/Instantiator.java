package com.gmail.yevtukh.anton.homework.lection01.task03;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * Created by Anton on 16.09.2017.
 * Создает объекты заданного класса. Если есть, использует конструктор по умолчанию, иначе берет первый попавшийся,
 * передавая в него параметры по умолчанию - 0, false, null
 */
public class Instantiator {

    public static <T> T createInstance(Class<T> classToken)
        throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Constructor constructor;
        try {
            constructor = classToken.getConstructor();
        } catch (NoSuchMethodException e) {
            constructor = classToken.getDeclaredConstructors()[0];
        }
        Object[] defaultParameters = Arrays.stream(constructor.getParameterTypes()).map(clazz -> getDefaultValue(clazz)).toArray();

        return (T)constructor.newInstance(defaultParameters);
    }

    private static Object getDefaultValue(Class<?> classToken) {
        return Array.get(Array.newInstance(classToken, 1), 0);
    }

    /*private static Object getDefaultValue2(Class<?> classToken) {
        if (classToken.isInterface() || Modifier.isAbstract(classToken.getModifiers()))
            throw new IllegalArgumentException
                    ("Can't create an instance of interface or abstract class for " + classToken.getName());
        if (classToken == byte.class || classToken == Byte.class ||
                classToken == short.class || classToken == Short.class ||
                classToken == int.class || classToken == Integer.class ||
                classToken == char.class || classToken == Character.class)
            return 0;
        if (classToken == long.class || classToken == Long.class)
            return 0L;
        if (classToken == boolean.class || classToken == Boolean.class)
            return false;
        if (classToken == float.class || classToken == Float.class)
            return 0f;
        if (classToken == double.class || classToken == Double.class)
            return 0;
        if (classToken == String.class)
            return "";
        return null;
    }*/
}
