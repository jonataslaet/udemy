package datastructures.stack;

import datastructures.doublylinkedlist.DoublyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTests {

    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {100000, 220, 330, 5330, 4044, 999, 133, 39393939})
    void testPush(int value) {
        int insertedFirst = 5;
        String expectedResult = "";
        expectedResult += "[" + (value) + "]\n";
        expectedResult += "[" + (value) + "]\n";
        expectedResult += "[" + (insertedFirst) + "]\n";
        expectedResult += "Height = " + 3 + "]\n";
        stack.push(value);
        stack.push(value);
        assertEquals(expectedResult, stack.printStack());
    }

    @Test
    void testConstructor() {
        int insertedFirst = 5;
        String expectedResult = "";
        expectedResult += "[" + (insertedFirst) + "]\n";
        expectedResult += "Height = " + 1 + "]\n";
        assertEquals(expectedResult, stack.printStack());
    }

    @ParameterizedTest
    @ValueSource(ints = {100000, 220, 330, 5330, 4044, 999, 133, 39393939})
    void testPop(int value) {
        int insertedFirst = 5;
        int expectedRemovedValue = value;
        String expectedResult = "";
        expectedResult += "[" + (value) + "]\n";
        expectedResult += "[" + (insertedFirst) + "]\n";
        expectedResult += "Height = " + 2 + "]\n";
        stack.push(value);
        stack.push(value);
        Node removedNode = stack.pop();
        assertEquals(expectedRemovedValue, removedNode.value);
        assertEquals(expectedResult, stack.printStack());
    }
}
