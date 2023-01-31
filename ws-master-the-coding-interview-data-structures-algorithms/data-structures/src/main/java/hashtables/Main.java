package hashtables;

import arrays.MyArray;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Integer[] numbers = new Integer[]{2,5,5,2,3,5,1,2,4};

    Map<Integer, Integer> backup = new Hashtable<Integer, Integer>();
    Integer firstRepeatedNumber = null;
    for(var number: numbers){
      if (backup.containsKey(number)) {
        firstRepeatedNumber = number;
        break;
      }
      backup.put(number, 1);
    }

    System.out.println(firstRepeatedNumber);
  }
}
