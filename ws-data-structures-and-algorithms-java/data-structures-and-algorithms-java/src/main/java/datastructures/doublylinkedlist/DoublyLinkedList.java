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

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = temp.previous;
            tail.next = null;
            temp.previous = null;
        }
        length--;
        return temp;
    }

    public void prepend(int value) {
        Node node = new Node(value);
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            head.previous = node;
            node.next = head;
            head = node;
        }
        length++;
    }

    public Node removeFirst() {
        if (length < 1) return null;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
            temp.next = null;
        }
        length--;
        return temp;
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

    public String printList() {
        String result = "";
        if (length < 1) {
            result = "Lista vazia";
            System.out.println(result);
        }
        else if (length == 1) {
            result = "["+head.value+"] - Length = " + length;
            System.out.println(result);
        } else {
            Node currrent = head;

            while (currrent.next != null) {
                if (currrent.previous == null) result += "["+currrent.value;
                else result += ", "+currrent.value;
                currrent = currrent.next;
            }
            result += ", " + currrent.value + "] - Length = " + length;
            System.out.println(result);
        }
        return result;
    }
}
