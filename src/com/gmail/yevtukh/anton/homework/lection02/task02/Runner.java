package com.gmail.yevtukh.anton.homework.lection02.task02;

/**
 * Created by Anton on 20.09.2017.
 */
public class Runner {

    private static final String SAVE_PATH = "D:\\Storage\\Work\\Java\\Projects\\#ProgUA\\JavaPro" +
            "\\src\\com\\gmail\\yevtukh\\anton\\homework\\lection02\\task02\\person.json";

    public static void main(String[] args) {

        Person person = new Person("Anton", "Yevtukh", new String[]{"gmail.com", "172ir.kiev.ua"},
                new String[]{"093-077-XX-XX", "050-XXX-XX-XX"},
                new Address("Ukraine", "Kyiv", "Pryrichna"));

        JsonUtils.marshal(person, SAVE_PATH);
        System.out.println(JsonUtils.unmarshall(Person.class, SAVE_PATH));
    }
}
