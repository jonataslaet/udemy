package arrays.twosum;

import arrays.MyArray;
import java.util.HashMap;
import java.util.Map;

public class SolutionMyArray {
  public MyArray twoSum(MyArray nums, int target) {
    MyArray myTargetIds = new MyArray(new Object[2]);

    Map<Integer, Integer> mapa = new HashMap<>();
    for(int i = 0; i < nums.getLength(); i++) {
      int difference = target - (Integer) nums.get(i);
      if (mapa.containsKey(difference)) {
        myTargetIds.push(i);
        myTargetIds.push(mapa.get(difference));
      }
      mapa.put((Integer)nums.get(i), i);
    }

    return myTargetIds;
  }
}
