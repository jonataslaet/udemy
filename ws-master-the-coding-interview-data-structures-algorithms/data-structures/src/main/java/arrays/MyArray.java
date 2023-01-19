package arrays;

import java.util.Arrays;

public class MyArray {
  private int length;
  private Object[] data = new Object[5];

  public Object get(int index) {
    return this.data[index];
  }

  public Object push(Object element) {
    this.data[this.length] = element;
    return this.data[this.length++];
  }

  public Object pop() {
    Object removedElement = this.data[this.length-1];
    this.data[this.length-1] = null;
    this.length--;
    return removedElement;
  }

  public Object delete(int index) {
    Object deletedItem = this.data[index];
    shiftElements(index);
    return deletedItem;
  }

  private void shiftElements(int index) {
    for (int i = index; i < this.length-1; i++) {
      this.data[i] = this.data[i+1];
    }
    this.pop();
  }

  @Override
  public String toString() {
    return "MyArray{" +
        "length=" + length +
        ", data=" + Arrays.toString(data) +
        '}';
  }
}
