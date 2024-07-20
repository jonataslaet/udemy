package section10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import section08.Node;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class CircularSinglyLinkedListTests {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9})
    void testRemoveAtPosition0ofAListWithMoreThan2Elements(int size) {
        int lastValue = 80;
        CircularSinglyLinkedList list = new CircularSinglyLinkedList(lastValue);
        for (int i = 0; i < size-1; i++) {
            lastValue = 81 + i;
            list.insert(list.getSize(), lastValue);
        }

        Node removedNode = list.remove(0);

        assertEquals(80, removedNode.getValue());
        assertEquals(size-1, list.getSize());
        assertNotNull(list.getFirstNode());
        assertNotNull(list.getLastNode());
        assertEquals(81, list.getFirstNode().getValue());
        assertEquals(lastValue, list.getLastNode().getValue());
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9})
    void testRemoveAtPosition1ofAListWithMoreThan2Elements(int size) {
        int lastValue = 80;
        CircularSinglyLinkedList list = new CircularSinglyLinkedList(lastValue);
        for (int i = 0; i < size-1; i++) {
            lastValue = 81 + i;
            list.insert(list.getSize(), lastValue);
        }

        Node removedNode = list.remove(1);

        assertEquals(81, removedNode.getValue());
        assertEquals(size-1, list.getSize());
        assertNotNull(list.getFirstNode());
        assertNotNull(list.getLastNode());
        assertEquals(80, list.getFirstNode().getValue());
        assertEquals(lastValue, list.getLastNode().getValue());
    }

    @Test
    void testRemoveAtPosition1ofASize2List() {
        int firstValue = 90;
        CircularSinglyLinkedList list = new CircularSinglyLinkedList(firstValue);
        list.insert(0, 80);
        Node removedNode = list.remove(1);

        assertEquals(90, removedNode.getValue());
        assertEquals(1, list.getSize());
        assertNotNull(list.getFirstNode());
        assertNotNull(list.getLastNode());
        assertEquals(list.getFirstNode(), list.getLastNode());
    }

    @Test
    void testRemoveAtPositionOofASize2List() {
        int firstValue = 90;
        CircularSinglyLinkedList list = new CircularSinglyLinkedList(firstValue);
        list.insert(0, 80);
        Node removedNode = list.remove(0);

        assertEquals(80, removedNode.getValue());
        assertEquals(1, list.getSize());
        assertNotNull(list.getFirstNode());
        assertNotNull(list.getLastNode());
        assertEquals(list.getFirstNode(), list.getLastNode());
    }

    @Test
    void testRemoveAtPositionOofASize1List() {
        int firstValue = 90;
        CircularSinglyLinkedList list = new CircularSinglyLinkedList(firstValue);
        Node removedNode = list.remove(0);
        assertEquals(90, removedNode.getValue());
        assertEquals(0, list.getSize());
        assertNull(list.getFirstNode());
        assertNull(list.getLastNode());
    }

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
