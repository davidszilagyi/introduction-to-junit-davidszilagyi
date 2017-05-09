package main;

import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by david_szilagyi on 2017.05.09..
 */
class FileWordAnalyzerTest {
    FilePartReader fpr;
    FileWordAnalyzer fwa;
    ArrayList<String> testABC;
    ArrayList<String> testWords1 = new ArrayList<>();
    ArrayList<String> testWords2 = new ArrayList<>();
    @BeforeEach
    void setUp() {
        fpr = new FilePartReader("/home/david_szilagyi/Codecool/Codes/Java/JUnit/src/main/test.txt", 1, 2);
        fwa = new FileWordAnalyzer(fpr);
        String[] test = new String[] {"are", "code", "cover", "is", "job", "ready,", "tests,", "to", "When", "with", "you", "your", "your"};
        testABC = new ArrayList<>(Arrays.asList(test));
        testWords1.add("code");
        testWords2.add("hiba");
    }
    @org.junit.jupiter.api.Test
    void wordsByABC() throws IOException {
        assertEquals(testABC, fwa.wordsByABC());
    }

    @org.junit.jupiter.api.Test
    void wordsContainingSubString() throws IOException {
        assertEquals(testWords1, fwa.wordsContainingSubString("code"));
        assertNotEquals(testWords2, fwa.wordsContainingSubString("hiba"));
    }

}