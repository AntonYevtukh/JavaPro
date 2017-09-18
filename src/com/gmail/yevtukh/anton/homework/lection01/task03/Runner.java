package com.gmail.yevtukh.anton.homework.lection01.task03;

import com.gmail.yevtukh.anton.homework.lection01.task03.test_classes.ChildClass;
import com.gmail.yevtukh.anton.homework.lection01.task03.test_classes.ContainerClass;
import com.gmail.yevtukh.anton.homework.lection01.task03.test_classes.ParentClass;

/**
 * Created by Anton on 16.09.2017.
 */
public class Runner {

    public static void main(String[] args) {
        Serializer serializer = new Serializer("D:\\Storage\\Work\\Java\\Projects\\#ProgUA\\JavaPro\\src" +
                "\\com\\gmail\\yevtukh\\anton\\homework\\lection01\\task03\\SaveFile.json");

        ParentClass parentClass1 = new ParentClass(10, 20, "Hello!");
        ParentClass parentClass2 = new ParentClass(14, 88, "Heil!");
        ChildClass childClass1 = new ChildClass(parentClass1, new double[]{0.0,1.0}, false,
                "It will not be serialized");
        ChildClass childClass2 = new ChildClass(parentClass2, new double[3], true,
                "It will not be serialized");
        short[][] shortMatrix = {{1, 2, 3}, {10, 9, 8}};
        ContainerClass containerClass = new ContainerClass(new ChildClass[]{childClass1, childClass2}, shortMatrix);

        System.out.println("ContainerClass instance before serialization:\n" + containerClass.toString());
        serializer.serializeObject(containerClass);
        System.out.println("ContainerClass instance got by deserialization from file:");
        System.out.println(serializer.deserializeObject(ContainerClass.class));
    }
}
