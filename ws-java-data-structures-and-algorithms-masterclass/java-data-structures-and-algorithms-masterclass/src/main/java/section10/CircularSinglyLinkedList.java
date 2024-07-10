package section10;

import section08.Node;

public class CircularSinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public CircularSinglyLinkedList(int value) {
        Node node = new Node(value);
        node.setNext(node);
        head = node;
        tail = node;
        size = 1;
    }

    public void walkingThroughNFirstElements(int n) {
        int i = 0;
        if (n <= i) {
            System.out.println("Invalid id for an element");
            return;
        }
        Node temp = head;
        if (temp == null) {
            System.out.println("There's no element in this list");
            return;
        }
        if (n == 1) {
            System.out.print(temp.getValue());
        }
        else {
            System.out.print(temp.getValue());
            temp = temp.getNext();
            i++;
            while (i++ < n && temp != null) {
                System.out.print(" -> " + temp.getValue());
                temp = temp.getNext();
            }
        }
    }
}
