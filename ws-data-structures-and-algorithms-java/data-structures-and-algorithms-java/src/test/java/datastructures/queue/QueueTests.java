package datastructures.queue;

import datastructures.stack.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTests {

    private Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {100000, 220, 330, 5330, 4044})
    void testQueue(int value) {
        int insertedFirst = 5;
        String expectedResult = "";
        expectedResult += "[" + (insertedFirst) + "]\n";
        expectedResult += "[" + (value) + "]\n";
        expectedResult += "[" + (value) + "]\n";
        expectedResult += "Length = " + 3 + "]\n";
        queue.enqueue(value);
        queue.enqueue(value);
        assertEquals(expectedResult, queue.printQueue());
    }

    @ParameterizedTest
    @ValueSource(ints = {100000, 220, 330, 5330, 4044})
    void testDequeue(int value) {
        int expectedDequeuedValue = 5;
        String expectedResult = "";
        expectedResult += "[" + (value) + "]\n";
        expectedResult += "[" + (value) + "]\n";
        expectedResult += "Length = " + 2 + "]\n";
        queue.enqueue(value);
        queue.enqueue(value);
        Node dequeuedNode = queue.dequeue();
        assertEquals(expectedDequeuedValue, dequeuedNode.value);
        assertEquals(expectedResult, queue.printQueue());
    }
}
