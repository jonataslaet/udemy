package arrays;

public class Main {
  public static void main(String[] args) {
    MyArray myArray = new MyArray();
    myArray.push("Element 01");
    myArray.push("Element 02");
    myArray.push("Element 03");
    myArray.push("Element 04");
    myArray.push("Element 05");
    System.out.println(myArray);

    System.out.println(myArray.get(4));
    myArray.pop();
    System.out.println(myArray.get(4));
    myArray.delete(2);

    System.out.println(myArray);
  }
}
