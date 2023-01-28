package arrays.movezeroes;


public class Solution {
  public void moveZeroes(int[] nums) {
    int[] zeros = new int[nums.length];
    int[] result = new int[nums.length];
    int z = 0, n = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        zeros[z++] = nums[i];
      } else {
        result[n++] = nums[i];
      }
    }
    for (int i = 0; i < z; i++) {
      result[n+i] = zeros[i];
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = result[i];
    }
  }
}
