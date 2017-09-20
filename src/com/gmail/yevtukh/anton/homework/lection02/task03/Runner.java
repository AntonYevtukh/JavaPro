package com.gmail.yevtukh.anton.homework.lection02.task03;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Anton on 20.09.2017.
 */
public class Runner {

    private static final String SAVE_PATH = "D:\\Files\\query.xml";
    private static final String QUERY_STRING = "http://query.yahooapis.com/v1/public/yql?format=xml" +
            "&q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22USDEUR%22,%20%22USDUAH%22)" +
            "&env=store://datatables.org/alltableswithkeys";

    public static void main(String[] args) {

        try {
            saveResponseToFile(QUERY_STRING, SAVE_PATH);
            System.out.println(XmlUtils.unmarshal(Query.class, SAVE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void saveResponseToFile(String requestString, String savePath) throws IOException {

        HttpURLConnection http = (HttpURLConnection) new URL(requestString).openConnection();
        new File(savePath).getParentFile().mkdirs();

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(savePath));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null)
                printWriter.println(line);
        } finally {
            http.disconnect();
        }
    }
}
