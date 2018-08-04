package com.piddamsetty.praneetwebpro1.services;

import java.io.*;

/**
 * Created by praneet on 8/2/18.
 */
public class FileServices {

    public String fileReader(String fileName) {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error while reading from file: " + fileName + " Exception:  " + e.getMessage());
        }
        String content = contentBuilder.toString();
        return content;
    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    public String resourceFileRead(String path) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(path);
            return readFromInputStream(inputStream);
        } catch (Exception e) {
            System.out.println("Error while reading from file: " + path + " Exception:  " + e.getMessage());
        }
        return "Something Went Wrong";
    }
}
