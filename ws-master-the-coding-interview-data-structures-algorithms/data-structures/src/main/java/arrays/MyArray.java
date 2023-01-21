package arrays;

import java.util.Arrays;

public class MyArray {
  private Integer length;
  private Object[] data;

  public MyArray() {
    this.data = new Object[10];
    this.length = 0;
  }

  public MyArray(Object[] elements) {
    this.data = elements;
    this.length = elements.length;
  }

  public Object get(int index) {
    if (index < this.length) {
      return this.data[index];
    }
    return null;
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

  public Integer getLength() {
    return this.length;
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
