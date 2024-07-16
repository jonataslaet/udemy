package section10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import section08.Node;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircularSinglyLinkedListTests {

    @Test
    void testFindValueShouldFind() {
        int firstValue = 90;
        CircularSinglyLinkedList list = new CircularSinglyLinkedList(firstValue);
        list.insert(0, 80);
        list.insert(0, 60);
        list.insert(0, 50);

        int expectedValue = 60;
        Node resultNode = list.findValue(60);
        assertEquals(expectedValue, resultNode.getValue());
    }

    @Test
    void testInsertAtAfterBeginningAndBeforeRightAfterTheEnd() {
        int firstValue = 90;
        CircularSinglyLinkedList list = new CircularSinglyLinkedList(firstValue);
        list.insert(0, 80);
        list.insert(0, 60);
        list.insert(0, 50);

        String expectedList = "50 -> 60 -> 70 -> 80 -> 90";
        list.insert(2, 70);
        String resultedList = getOutputFromList(list, 5);
        assertEquals(expectedList, resultedList);
    }

    @Test
    void testInsertAtRightAfterTheEnd() {
        int firstValue = 70;
        CircularSinglyLinkedList list = new CircularSinglyLinkedList(firstValue);
        String expectedList = "70 -> 80";
        list.insert(1, 80);
        String resultedList = getOutputFromList(list, 2);
        assertEquals(expectedList, resultedList);
    }

    @Test
    void testInsertAtTheBeginning() {
        int firstValue = 70;
        CircularSinglyLinkedList list = new CircularSinglyLinkedList(firstValue);
        String expectedList = "80 -> 70";
        list.insert(0, 80);
        String resultedList = getOutputFromList(list, 2);
        assertEquals(expectedList, resultedList);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void testWalkingThroughFirstNElements(int quantityOfElements) {
        int firstValue = 70;
        CircularSinglyLinkedList list = new CircularSinglyLinkedList(firstValue);
        String expectedList = "70";
        for (int i = 1; i < quantityOfElements; i++) {
            expectedList = expectedList.concat(" -> " + firstValue);
        }
        String resultedList = getOutputFromList(list, quantityOfElements);

        assertEquals(expectedList, resultedList);
    }

    private String getOutputFromList(CircularSinglyLinkedList list, int n) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        list.walkingThroughNFirstElements(n);
        System.setOut(originalOut);
        return outputStream.toString().trim();
    }
}
