package com.gmail.yevtukh.anton.homework.lection01.task02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Anton on 16.09.2017.
 */
@SaveTo(path = "D:\\Storage\\Work\\Java\\Projects\\#ProgUA\\JavaPro\\src\\com\\gmail\\yevtukh\\anton\\" +
        "homework\\lection01\\task02\\text.txt")
public class TextContainer {

    private String text;

    public TextContainer(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Save
    public void save(String path) {
        File file = new File(path);
        file.getParentFile().mkdirs();
        try (PrintWriter printWriter = new PrintWriter(path)) {
            printWriter.println(text);
        } catch (FileNotFoundException e) {
            System.err.println("Failed to create file for save");
            e.printStackTrace();
        }
    }
}
