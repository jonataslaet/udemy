package datastructures.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        Node temp = head;
        if (length == 0) return null;
        if (length == 1) {
            head = null;
            tail = null;
            length = 0;
            return temp;
        }

        Node current = head;
        while(current.next != null) {
            temp = current;
            current = current.next;
        }
        tail = temp;
        tail.next = null;
        temp = null;
        length--;

        return current;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        if (length == 1) {
            temp.next = null;
            head = null;
            tail = null;
            length = 0;
            return temp;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return head;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node node = get(index);
        if (node != null) {
            node.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node previousNode = get(index - 1);
        Node newNode = new Node(value);
        newNode.next = previousNode.next;
        previousNode.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) removeLast();
        Node previous = get(index - 1);
        Node temp = previous.next;
        previous.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node previous = null;
        Node after = temp.next;
        while (after != null) {
            after = temp.next;
            temp.next = previous;
            previous = temp;
            temp = after;
        }
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void printList() {
        Node temp = head;
        System.out.println("Nodes: ");
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println();
    }
}
