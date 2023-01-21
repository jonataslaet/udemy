package arrays;

public class ReverseAString {

  public static void main(String[] args) {
    String word = "Jonatas";
    System.out.println(reverse(word));
  }

  public static String reverse(String word) {
    String reversedString = "";
    int lastId = word.length() - 1;

    for (int i = lastId; i >= 0; i--) {
      reversedString += word.charAt(i);
    }

    return reversedString;
  }
}
