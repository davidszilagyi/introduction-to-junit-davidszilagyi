package main;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by david_szilagyi on 2017.05.09..
 */
public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        } else {
            this.filePath = filePath;
            this.fromLine = fromLine - 1;
            this.toLine = toLine - 1;
        }
    }

    private String read() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String text = "";
        String line;
        try {
            while ((line = br.readLine()) != null) {
                text += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public String readLines() throws IOException  {
        String text = "";
        String[] textList = read().split("\n");
        for(int index = fromLine; index < toLine; index ++) {
            text += textList[index] + "\n";
        }
        return text;
    }
}
