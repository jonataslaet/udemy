package datastructures.queue;

public class Queue {
    private int length;
    private Node first;
    private Node last;

    public Queue(int value) {
        Node node = new Node(value);
        first = node;
        last = node;
        length = 1;
    }

    public void enqueue(int value) {
        Node node = new Node(value);
        if (length == 0) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        length++;
    }

    public Node dequeue() {
        Node temp = first;
        if (length == 0) return temp;
        else if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public String printQueue() {
        String result = "";
        Node temp = first;
        while (temp != null) {
            result += "[" + temp.value + "]\n";
            temp = temp.next;
        }
        result += "Length = " + this.getLength() + "]\n";
        return result;
    }

    private int getLength() {
        return this.length;
    }
}
