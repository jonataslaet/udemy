package section08;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SinglyLinkedListTests {

    @Test
    void testRemoveElementAtTheMiddleOfANonEmptyList() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(0, 10);
        list.insert(0, 20);
        list.insert(0, 30);
        int expectedRemovedNodeValue = 20;
        int removedNodeValue = list.remove(1).getValue();
        String resultedList = getOutputFromList(list);
        String expectedList = "30 -> 10";

        assertEquals(expectedRemovedNodeValue, removedNodeValue);
        assertEquals(expectedList, resultedList);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3, 4, 5, 6, 7, 8})
    void testRemoveElementAtInvalidPositionOfListOfSize2(int invalidPosition) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(0, 10);
        list.insert(0, 20);

        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(invalidPosition);
        });
        String expectedMessage = "Invalid position for this value to be read";
        String actualMessage = exception.getLocalizedMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 1})
    void testRemoveElementAtInvalidPositionOfEmptyList(int invalidPosition) {
        SinglyLinkedList list = new SinglyLinkedList();
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(invalidPosition);
        });
        String expectedMessage = "Invalid position for this value to be read";
        String actualMessage = exception.getLocalizedMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testRemoveElementAtTheEndOfANonEmptyList() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(0, 10);
        list.insert(0, 20);
        list.insert(0, 30);
        int expectedNodeValue = 10;
        int removedNodeValue = list.pop().getValue();
        String resultedList = getOutputFromList(list);
        String expectedList = "30 -> 20";

        assertEquals(expectedNodeValue, removedNodeValue);
        assertEquals(expectedList, resultedList);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 1})
    void testInsertElementAtInvalidPositionOfEmptyList(int invalidPosition) {
        SinglyLinkedList list = new SinglyLinkedList();
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.insert(invalidPosition, 10);
        });
        String expectedMessage = "Invalid position for this value to be inserted";
        String actualMessage = exception.getLocalizedMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3, 4, 5, 6, 7, 8})
    void testInsertElementAtInvalidPositionOfListOfSize2(int invalidPosition) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(0, 10);
        list.insert(0, 20);

        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.insert(invalidPosition, 30);
        });
        String expectedMessage = "Invalid position for this value to be inserted";
        String actualMessage = exception.getLocalizedMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testInsertThreeElementsAtTheBeginningOfList() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(0, 10);
        list.insert(0, 20);
        list.insert(0, 30);
        list.insert(0, 40);

        String actualOutput = getOutputFromList(list);
        String expectedOutput = "40 -> 30 -> 20 -> 10";

        assertEquals(expectedOutput, actualOutput);

    }

    @Test
    void testInsertThreeElementsAtTheEndOfList() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(0, 10);
        list.insert(1, 20);
        list.insert(2, 30);
        list.insert(3, 40);

        String actualOutput = getOutputFromList(list);
        String expectedOutput = "10 -> 20 -> 30 -> 40";

        assertEquals(expectedOutput, actualOutput);

    }

    private String getOutputFromList(SinglyLinkedList list) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        list.showAll();
        System.setOut(originalOut);
        return outputStream.toString().trim();
    }
}
