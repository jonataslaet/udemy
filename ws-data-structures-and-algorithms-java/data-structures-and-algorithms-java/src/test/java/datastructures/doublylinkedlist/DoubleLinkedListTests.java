package datastructures.doublylinkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleLinkedListTests {

    private DoublyLinkedList doublyLinkedList;

    @BeforeEach
    void setUp() {
        doublyLinkedList = new DoublyLinkedList(5);
    }

    @Test
    void testAppend() {
        doublyLinkedList.append(3);
        assertEquals(doublyLinkedList.printList(), "[5, 3] - Length = 2");
    }

    @Test
    void testAppendAndRemoveLast() {
        doublyLinkedList.append(3);
        doublyLinkedList.removeLast();
        assertEquals(doublyLinkedList.printList(), "[5] - Length = 1");
    }

    @Test
    void testAppendAndRemoveFirst() {
        doublyLinkedList.append(3);
        doublyLinkedList.removeFirst();
        assertEquals(doublyLinkedList.printList(), "[3] - Length = 1");
    }

    @Test
    void testPrepend() {
        doublyLinkedList.prepend(3);
        assertEquals(doublyLinkedList.printList(), "[3, 5] - Length = 2");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void testGet(int index) {
        doublyLinkedList.prepend(3);
        doublyLinkedList.append(5);
        assertEquals(doublyLinkedList.printValueByIndex(index), "Node = "+ doublyLinkedList.get(index).value +" | Index = " + index);
    }
}
