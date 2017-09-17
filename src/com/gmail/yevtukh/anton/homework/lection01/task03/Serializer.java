package com.gmail.yevtukh.anton.homework.lection01.task03;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Anton on 16.09.2017.
 */
//Серализует и десереализует во что-то похожее на JSON
public class Serializer {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String FIELD_SEPARATOR = ": ";
    private static final String VALUES_SEPARATOR = ",";
    private static final String QUOTE_SEPARATOR = "\"";
    private static final String OBJECT_BEGIN = "{";
    private static final String OBJECT_END = "}";
    private static final String ARRAY_BEGIN = "[";
    private static final String ARRAY_END = "]";
    private static final String INDENT = "\t";

    private static final Class<?>[] STANDARD_TYPES = {
            byte.class, Byte.class, short.class, Short.class, int.class, Integer.class, long.class, Long.class,
            char.class, Character.class, boolean.class, Boolean.class, float.class,
            Float.class, double.class, Double.class, String.class
    };

    private String savePath;

    public Serializer(String savePath) {
        this.savePath = savePath;
        new File(savePath).getParentFile().mkdirs();
    }

    public void serializeObject(Object obj) {
        FileIOUtils.writeToFile(objectToString(obj), savePath);
    }

    public <T> T deserializeObject(Class<T> classToken) {
        return parseObject(classToken, new String[]{FileIOUtils.readFromFile(savePath)});
    }

    private String objectToString(Object obj) {
        return objectToString(obj, 1);
    }

    private String objectToString(Object obj, int indentCount) {
        if (isStandardType(obj.getClass()))
            return (obj.getClass() == String.class ? QUOTE_SEPARATOR + obj + QUOTE_SEPARATOR : obj.toString());
        String indent = String.join("", Collections.nCopies(indentCount, INDENT));
        StringBuffer result = new StringBuffer(OBJECT_BEGIN + LINE_SEPARATOR);
        Class<?> objectClass = obj.getClass();
        Field[] savedFields = getSavedFields(objectClass);

        try {
            for (Field field : savedFields) {
                result.append(indent + QUOTE_SEPARATOR + field.getName() + QUOTE_SEPARATOR + FIELD_SEPARATOR);
                Class<?> fieldType = field.getType();
                field.setAccessible(true);
                if (isStandardType(fieldType))
                    result.append(fieldType == String.class ?
                    QUOTE_SEPARATOR + field.get(obj) + QUOTE_SEPARATOR : field.get(obj));
                else if (fieldType.isArray()) {
                    System.out.println(field.get(obj).getClass().getName());
                    result.append(arrayToString(field.get(obj), indentCount + 1));
                }
                else {
                    result.append(objectToString(field.get(obj), indentCount + 1));
                }
                result.append(VALUES_SEPARATOR + LINE_SEPARATOR);
            }
            result.replace(result.lastIndexOf(VALUES_SEPARATOR),
                    result.lastIndexOf(VALUES_SEPARATOR) + VALUES_SEPARATOR.length(), "");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Can't access the some field for object " + obj.toString());
        }
        indent = indent.substring(0, indent.lastIndexOf(INDENT));
        result.append(indent + OBJECT_END);
        return result.toString();
    }

    private String arrayToString(Object obj, int indentCount) {
        if (!obj.getClass().isArray())
            throw new IllegalArgumentException("Object is not an array");

        String indent = String.join("", Collections.nCopies(indentCount, INDENT));
        StringBuffer result = new StringBuffer(ARRAY_BEGIN + LINE_SEPARATOR);
        int arrayLength = Array.getLength(obj);
        for (int i = 0; i < arrayLength; i++)
            result.append(indent + objectToString(Array.get(obj, i), indentCount) +
                    ((i < arrayLength - 1) ? VALUES_SEPARATOR : "") + LINE_SEPARATOR);
        indent = indent.substring(0, indent.lastIndexOf(INDENT));
        result.append(indent + ARRAY_END);
        return result.toString();
    }

    private  <T> T parseObject(Class<T> classToken, String[] objectStringContainer) {
        try {
            String objectString = objectStringContainer[0];
            T instance = Instantiator.createInstance(classToken);
            objectString = objectString.substring(objectString.indexOf(LINE_SEPARATOR) + LINE_SEPARATOR.length(),
                    objectString.lastIndexOf(OBJECT_END));
            objectStringContainer[0] = objectString;
            Field[] savedFields = getSavedFields(classToken);
            for (Field field : savedFields) {
                field.setAccessible(true);
                field.set(instance, parseField(field, objectStringContainer));
            }
            return instance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Unable to create an instance for the class: " + classToken.getName());
        }
    }

    private Object parseField(Field field, String[] objectStringContainer) {
        String objectString = checkAndRemoveFieldName(objectStringContainer[0], field);
        if (isStandardType(field.getType())) {
            String fieldValue = objectString.substring(0, objectString.indexOf(LINE_SEPARATOR));
            if (fieldValue.lastIndexOf(VALUES_SEPARATOR) != -1)
                fieldValue = fieldValue.substring(0, fieldValue.lastIndexOf(VALUES_SEPARATOR));
            objectStringContainer[0] = objectString.substring(objectString.indexOf(LINE_SEPARATOR) + LINE_SEPARATOR.length());
            return parseStandard(field.getType(), fieldValue);
        }
        else if (field.getType().isArray()) {
            objectStringContainer[0] = objectString;
            String arrayString = getNestedObjectString(objectStringContainer, ARRAY_BEGIN, ARRAY_END);
            return parseArray(field.getType(), new String[]{arrayString});
        }
        else {
            objectStringContainer[0] = objectString;
            String nestedObjectString = getNestedObjectString(objectStringContainer, OBJECT_BEGIN, OBJECT_END);
            //System.out.println(nestedObjectString);
            return parseObject(field.getType(), new String[]{nestedObjectString});
        }
    }

    private Object parseStandard(Class<?> standardToken, String standardString) {
        if (standardToken == byte.class || standardToken == Byte.class)
            return Byte.parseByte(standardString);
        if (standardToken == short.class || standardToken == Short.class)
            return Short.parseShort(standardString);
        if (standardToken == int.class || standardToken == Integer.class)
            return Integer.parseInt(standardString);
        if (standardToken == long.class || standardToken == Long.class)
            return Long.parseLong(standardString);
        if (standardToken == char.class || standardToken == Character.class)
            return standardString.charAt(0);
        if (standardToken == boolean.class || standardToken == Boolean.class)
            return Boolean.parseBoolean(standardString);
        if (standardToken == float.class || standardToken == Float.class)
            return Float.parseFloat(standardString);
        if (standardToken == double.class || standardToken == Double.class)
            return Double.parseDouble(standardString);
        return standardString.substring(standardString.indexOf
                (QUOTE_SEPARATOR) + QUOTE_SEPARATOR.length(), standardString.lastIndexOf(QUOTE_SEPARATOR));
    }

    private Object parseArray(Class<?> classToken, String[] objectStringContainer){
        String objectString = objectStringContainer[0];
        objectString = objectString.substring(objectString.indexOf(LINE_SEPARATOR) + LINE_SEPARATOR.length(),
                objectString.lastIndexOf(ARRAY_END)).trim();
        Class<?> arrayElementType = classToken.getComponentType();
        List<Object> arrayElementsList = new ArrayList<>();
        if (isStandardType(arrayElementType)) {
            arrayElementsList = Arrays.stream(objectString.split(LINE_SEPARATOR)).map(elementString -> {
                if (elementString.lastIndexOf(VALUES_SEPARATOR) != -1)
                    elementString = elementString.substring(0, elementString.lastIndexOf(VALUES_SEPARATOR));
                return parseStandard(arrayElementType, elementString.trim());
            }).collect(Collectors.toList());
        } else if (arrayElementType.isArray()) {

        }
        Object[] array = arrayElementsList.toArray();
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Array.get(array, i);
        }
        return result;
    }

    private String checkAndRemoveFieldName(String objectString, Field field) {
        String fieldName = objectString.trim().substring(0, objectString.indexOf(FIELD_SEPARATOR));
        fieldName = fieldName.substring(fieldName.indexOf(QUOTE_SEPARATOR) + 1, fieldName.lastIndexOf(QUOTE_SEPARATOR));
        if (!fieldName.equals(field.getName()))
            throw new RuntimeException("Field name in the class differs from appropriate name in the file");
        return objectString.substring(objectString.indexOf(FIELD_SEPARATOR) + FIELD_SEPARATOR.length());
    }

    private String getNestedObjectString(String[] objectStringContainer, String beginToken, String endToken) {
        int nestingCounter = 1;
        int length = 0;
        int beginTokenPosition;
        int endTokenPosition;
        String objectString = objectStringContainer[0];
        String result;
        objectString = objectString.substring(objectString.indexOf(beginToken) + 1);
        while (nestingCounter != 0) {
            beginTokenPosition = objectString.indexOf(beginToken);
            endTokenPosition = objectString.indexOf(endToken);
            if (beginTokenPosition != -1 && beginTokenPosition < endTokenPosition) {
                objectString = objectString.substring(beginTokenPosition + beginToken.length());
                length += beginTokenPosition + beginToken.length();
                nestingCounter++;
            }
            else {
                objectString = objectString.substring(endTokenPosition + endToken.length());
                length += (endTokenPosition + endToken.length());
                nestingCounter--;
            }

        }
        result = objectStringContainer[0].substring(0, length + 1); //!?
        objectStringContainer[0] = objectString;
        //System.out.println(result);
        return result;
    }

    private Field[] getSavedFields(Class<?> classToken) {
        List<Field> savedFields = new ArrayList<>();

        do {
            for (Field field : classToken.getDeclaredFields())
                //if (field.isAnnotationPresent(Save.class))
                    savedFields.add(field);
            classToken = classToken.getSuperclass();
        } while (classToken != Object.class);

        return savedFields.stream().toArray(Field[]::new);
    }

    private boolean isStandardType(Class<?> classToken) {
        for (Class<?> standardType : STANDARD_TYPES)
            if (standardType == classToken)
                return true;
        return false;
    }
}
