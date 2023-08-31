package datastructures.doublylinkedlist;

public class DoublyLinkedList {
    private Node tail;
    private Node head;
    private Integer length;

    public DoublyLinkedList(Integer value) {
        Node node = new Node(value);
        tail = node;
        head = node;
        length = 1;
    }

    public void append(int value) {
        Node node = new Node(value);
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        length++;
    }

    public void printHead() {
        System.out.println("Head: " + head.value);
    }

    public void printTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void printLength() {
        System.out.println("Length: " + length);
    }

    public void printList() {
        if (length < 1) {
            System.out.println("Lista vazia");
        }
        else if (length == 1) {
            System.out.println("["+head.value+"] - Length = " + length);
        } else {
            Node currrent = head;
            while (currrent.next != null) {
                System.out.print("["+currrent.value);
                currrent = currrent.next;
            }
            System.out.println(", " + currrent.value + "] - Length = " + length);
        }
    }
}
