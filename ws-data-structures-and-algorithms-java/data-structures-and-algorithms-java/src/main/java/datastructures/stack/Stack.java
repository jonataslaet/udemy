package datastructures.stack;

public class Stack {
    private int height;
    private Node top;

    public Stack(int value) {
        top = new Node(value);
        height = 1;
    }

    public void push(int value) {
        Node node = new Node(value);
        if (height == 0) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
        height++;
    }

    public String printStack() {
        String result = "";
        Node temp = top;
        while (temp != null) {
            result += "[" + temp.value + "]\n";
            temp = temp.next;
        }
        result += "Height = " + this.getHeight() + "]\n";
        return result;
    }

    public int getHeight() {
        return this.height;
    }
}
