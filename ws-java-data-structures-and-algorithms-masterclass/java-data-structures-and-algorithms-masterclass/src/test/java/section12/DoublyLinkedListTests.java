package section12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoublyLinkedListTests {

    @Test
    void testCreateDoublyLinkedListWithFirstNode() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(0, 12);
        list.insert(0, 11);
        list.insert(0, 10);
        String actualOutput = getOutputFromListFromHeadToTail(list);
        String expectedOutput = "10 -> 11 -> 12";
        assertEquals(expectedOutput, actualOutput);

        actualOutput = getOutputFromListFromTailToHead(list);
        expectedOutput = "12 -> 11 -> 10";
        assertEquals(expectedOutput, actualOutput);
    }

    @ParameterizedTest
    @ValueSource(ints = {-199, 323, 445, 512, 632, 733, 855})
    void testCreateDoublyLinkedListWithFirstNode(int value) {
        DoublyLinkedList list = new DoublyLinkedList(value);
        String actualOutput = getOutputFromListFromHeadToTail(list);
        String expectedOutput = "" + value;
        assertEquals(expectedOutput, actualOutput);
        assertEquals(expectedOutput, getOutputFromListFromTailToHead(list));
    }

    private String getOutputFromListFromHeadToTail(DoublyLinkedList list) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        list.showAllFromHeadToTail();
        System.setOut(originalOut);
        return outputStream.toString().trim();
    }

    private String getOutputFromListFromTailToHead(DoublyLinkedList list) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        list.showAllFromTailToHead();
        System.setOut(originalOut);
        return outputStream.toString().trim();
    }
}
