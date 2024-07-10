package section10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import section08.SinglyLinkedList;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CircularSinglyLinkedListTests {

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
