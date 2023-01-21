package arrays.twosum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int[] twoSum(int[] nums, int target) {
    int[] xy = new int[] {-1, -1};

    Map<Integer, Integer> mapa = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
      int difference = target - nums[i];
      if (mapa.containsKey(difference)) {
        xy[0] = i;
        xy[1] = mapa.get(difference);
      }
      mapa.put(nums[i], i);
    }

    return xy;
  }
}
