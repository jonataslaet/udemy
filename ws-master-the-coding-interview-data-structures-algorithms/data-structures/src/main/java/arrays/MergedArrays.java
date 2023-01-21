package arrays;

import java.util.Objects;

public class MergedArrays {

  public static void main(String[] args) {
    //mergeSortedArrays([0, 3, 4, 31],[4, 6, 30]); => [0, 3, 4, 4, 6, 30, 31]

    MyArray xArray = new MyArray(new Object[]{0, 3, 4, 31});
    MyArray yArray = new MyArray(new Object[]{4, 6, 30});

    System.out.println(xArray);
    System.out.println(yArray);
    System.out.println(mergeSortedArrays(xArray, yArray));
  }

  public static MyArray mergeSortedArrays(MyArray a1, MyArray a2) {
    MyArray mergedArray = new MyArray();

    if (a1.getLength() < 1) {
      return a2;
    }

    if (a2.getLength() < 1) {
      return a1;
    }

    Integer x = 0, y = 0;

    Integer itemX = (Integer)a1.get(x);
    Integer itemY = (Integer)a2.get(y);

    while(Objects.nonNull(itemX) || Objects.nonNull(itemY)){
      if (Objects.isNull(itemY) || (Objects.nonNull(itemX) && (itemX < itemY))) {
        mergedArray.push(itemX);
        itemX = getNextElement(a1, ++x);
      } else {
        mergedArray.push(itemY);
        itemY = getNextElement(a2, ++y);
      }
    }

    return mergedArray;
  }

  public static Integer getNextElement(MyArray myArray, Integer i) {
    Integer nextElement = (Integer) myArray.get(i);
    return nextElement;
  }
}
