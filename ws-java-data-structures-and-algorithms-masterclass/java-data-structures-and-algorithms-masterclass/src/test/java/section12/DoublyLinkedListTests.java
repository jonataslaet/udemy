package section12;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoublyLinkedListTests {

    @ParameterizedTest
    @ValueSource(ints = {-199, 323, 445, 512, 632, 733, 855})
    void testCreateDoublyLinkedListWithFirstNode(int value) {
        DoublyLinkedList list = new DoublyLinkedList(value);
        String actualOutput = getOutputFromList(list);
        String expectedOutput = "" + value;
        assertEquals(expectedOutput, actualOutput);
    }

    private String getOutputFromList(DoublyLinkedList list) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        list.showAll();
        System.setOut(originalOut);
        return outputStream.toString().trim();
    }
}
