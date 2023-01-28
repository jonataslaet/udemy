package arrays.containsduplicate;


import java.util.HashMap;
import java.util.Map;

public class Solution {
  public boolean containsDuplicate(int[] nums) {
    Map<Integer, Integer> backup = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (backup.containsKey(nums[i]) && backup.get(nums[i]) > 0) {
        return true;
      } else {
        backup.put(nums[i], 1);
      }
    }

    return false;
  }
}
