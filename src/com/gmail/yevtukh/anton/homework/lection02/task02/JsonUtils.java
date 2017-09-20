package com.gmail.yevtukh.anton.homework.lection02.task02;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * Created by Anton on 20.09.2017.
 */
public class JsonUtils {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void marshal(Object obj, String savePath) {

        new File(savePath).getParentFile().mkdirs();
        String jsonString = GSON.toJson(obj);

        try(PrintWriter printWriter = new PrintWriter(savePath)) {
            printWriter.println(jsonString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static <T> T unmarshall(Class<T> classToken, String savePath) {

        T object = null;
        try {
            object = GSON.fromJson(new FileReader(savePath), classToken);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
