package arrays.maximumsubarray;

import arrays.MyArray;

public class Main {
  public static void main(String[] args) {
    SolutionMyArray solutionMyArray = new SolutionMyArray();
    MyArray myArray = new MyArray(new Object[]{-2,1,-3,4,-1,2,1,-5,4});
    System.out.println(solutionMyArray.maxSubArray(myArray));
  }
}
