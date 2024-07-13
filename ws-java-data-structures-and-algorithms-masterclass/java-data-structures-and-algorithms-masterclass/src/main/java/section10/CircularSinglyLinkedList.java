package section10;

import section08.Node;

public class CircularSinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public CircularSinglyLinkedList(int value) {
        createFirstNode(value);
    }

    private void createFirstNode(int value) {
        Node node = new Node(value);
        node.setNext(node);
        head = node;
        tail = node;
        size = 1;
    }

    private void insertAtTheBeginning(int value) {
        Node node = new Node(value);
        node.setNext(head);
        head = node;
        tail.setNext(node);
        size++;
    }

    private void insertAtTheEnd(int value) {
        Node node = new Node(value);
        node.setNext(head);
        tail = node;
        size++;
    }

    public void insert(int i, int value) {
        validPositionToInsert(i);
        if (size == 0) {
            createFirstNode(value);
        } else if (i == 0) {
            insertAtTheBeginning(value);
        } else if (i == size - 1) {
            insertAtTheEnd(value);
        } else {
            Node newNode = new Node(value);
            Node temp = head;
            int p = 0;
            while (p++ < i-1) {
                temp = temp.getNext();
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
    }

    private void validPositionToInsert(int i) {
        if (i > this.size || i < 0) {
            throw new IndexOutOfBoundsException("Invalid position for this value to be inserted");
        }
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
