package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileReader {

    public static String readFile(String filename) {
        File dataFile = new File(filename);
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(dataFile);
            StringBuilder output = new StringBuilder();

            final char[] buffer = new char[1024];
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int numberCharRead;
            while ((numberCharRead = reader.read(buffer)) != -1) {
                output.append(buffer, 0, numberCharRead);
            }
            reader.close();
            return output.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}