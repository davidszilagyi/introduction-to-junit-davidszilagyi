package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by david_szilagyi on 2017.05.09..
 */
class FilePartReaderTest {
    FilePartReader fpr;

    @BeforeEach
    void setUp() {
        fpr = new FilePartReader("/home/david_szilagyi/Codecool/Codes/Java/JUnit/src/main/test.txt", 1, 2);
    }

    @Test
    void readLines() throws IOException {
        String[] test = new String[]{"When you are ready, your job is to cover your code with tests,\n"};
            assertEquals(test[0], fpr.readLines());
    }

    @Test
    void illegalArgumentExecption() {
        assertThrows(IllegalArgumentException.class, () -> new FilePartReader("/home/david_szilagyi/Codecool/Codes/Java/JUnit/src/main/test.txt", 2, 1));
        assertThrows(IllegalArgumentException.class, () -> new FilePartReader("/home/david_szilagyi/Codecool/Codes/Java/JUnit/src/main/test.txt", 0, 10));
    }

    @Test
    void fileNotFoundExecption() {
        fpr = new FilePartReader("cfvgjk", 1, 10);
        assertThrows(FileNotFoundException.class, () -> fpr.readLines());
    }

}