package arrays.maximumsubarray;

import arrays.MyArray;
import java.util.HashMap;
import java.util.Map;

public class SolutionMyArray {
  public int maxSubArray(MyArray nums) {
    int max_current = 0;
    int max_so_far = Integer.MIN_VALUE;

    for (int i = 0; i < nums.getLength(); i++) {
      max_current += (int)nums.get(i);
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
