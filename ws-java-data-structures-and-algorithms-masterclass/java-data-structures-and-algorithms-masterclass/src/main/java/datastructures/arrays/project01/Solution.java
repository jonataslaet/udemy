package datastructures.arrays.project01;

public class Solution {

    public static void howManyAboveAverage(int[] array, int average) {
        int quantity = 0;
        for (int value : array) {
            if (value > average) quantity++;
        }
        System.out.println("There are " + quantity + " above the average " + average);
    }
}
