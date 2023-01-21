package arrays;

import arrays.MyArray;
import arrays.twosum.Solution;
import arrays.twosum.SolutionMyArray;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  static Map<Integer, Integer> mapa = new HashMap<>();

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = new int[]{3,3};
    for (int a : solution.twoSum(nums, 6)) {
      System.out.println(a);
    }

    MyArray myArray = new MyArray(new Object[]{2,7,11,5});
    SolutionMyArray solutionMyArray = new SolutionMyArray();
    System.out.println(solutionMyArray.twoSum(myArray, 9));
  }
}
