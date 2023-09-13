package datastructures.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTests {

    private LinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {100000, 220, 330, 5330, 4044, 999, 133, 39393939})
    void testAppend(int value) {
        linkedList.append(value);
        assertEquals(linkedList.printList(), "[5, "+value+"] - Length = 2");
    }

    @Test
    void testAppendAndRemoveLast() {
        linkedList.append(3);
        linkedList.removeLast();
        assertEquals(linkedList.printList(), "[5] - Length = 1");
    }

    @Test
    void testAppendAndRemoveFirst() {
        linkedList.append(3);
        linkedList.removeFirst();
        assertEquals(linkedList.printList(), "[3] - Length = 1");
    }

    @ParameterizedTest
    @ValueSource(ints = {100000, 220, 330, 5330, 4044, 999, 133, 39393939})
    void testPrepend(int value) {
        linkedList.prepend(value);
        assertEquals(linkedList.printList(), "["+value+", 5] - Length = 2");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void testGet(int index) {
        linkedList.prepend(3);
        linkedList.append(5);
        assertEquals(linkedList.printValueByIndex(index), "Node = "+ linkedList.get(index).value +" | Index = " + index);
    }
}
