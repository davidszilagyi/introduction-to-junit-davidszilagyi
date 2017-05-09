package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by david_szilagyi on 2017.05.09..
 */
public class FileWordAnalyzer {
    FilePartReader pr;

    public FileWordAnalyzer(FilePartReader pr) {
        this.pr = pr;
    }

    public ArrayList wordsByABC() throws IOException {
        ArrayList<String> tempArray = new ArrayList<>(Arrays.asList(pr.readLines().replaceAll("\n", "").split(" ")));
        Collections.sort(tempArray, String.CASE_INSENSITIVE_ORDER);
        return tempArray;
    }

    public ArrayList wordsContainingSubString(String subString) throws IOException {
        ArrayList<String> tempArray = new ArrayList<>();
        String[] tempList = pr.readLines().replaceAll("\n", "").split(" ");
        for(String word: tempList) {
            if(word.equalsIgnoreCase(subString)) {
                tempArray.add(word);
            }
        }
        return tempArray;
    }
}
