package datastructures.doublylinkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
