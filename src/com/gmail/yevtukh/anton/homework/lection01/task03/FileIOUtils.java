package com.gmail.yevtukh.anton.homework.lection01.task03;

import java.io.*;

/**
 * Created by Anton on 16.09.2017.
 */
public class FileIOUtils {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void writeToFile(String text, String fileName) {
        File file = new File(fileName);
        file.getParentFile().mkdirs();

        try(PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.println(text);
        } catch (FileNotFoundException e) {
            System.err.println("Unable to create file " + fileName);
            e.printStackTrace();
        }
    }

    public static String readFromFile(String fileName) {
        StringBuffer result = new StringBuffer("");
        String line;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((line = bufferedReader.readLine()) != null)
                result.append(line).append(LINE_SEPARATOR);
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find the file " + fileName);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IOException " + e.getMessage());
            e.printStackTrace();
        }
        return result.toString();
    }
}
