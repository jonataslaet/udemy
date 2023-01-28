package arrays.maximumsubarray;


public class Solution {
  public int maxSubArray(int[] nums) {
    int max_current = 0;
    int max_so_far = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      max_current += nums[i];
      if (max_current > max_so_far) {
        max_so_far = max_current;
      }
      if (max_current < 0) {
        max_current = 0;
      }
    }

    return max_so_far;
  }
}
