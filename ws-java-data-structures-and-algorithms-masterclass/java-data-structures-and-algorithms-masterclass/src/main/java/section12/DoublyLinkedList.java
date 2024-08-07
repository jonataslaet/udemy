package section12;

import section08.Node;

public class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;
    private int size;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(int value) {
        this.createFirstNode(value);
    }

    private void insertAtTheBeginning(int value) {
        DoublyNode node = new DoublyNode(value);
        node.setNext(head);
        head.setPrevious(node);
        head = node;
        this.size++;
    }

    public void insert(int i, int value) {
        validPositionToInsert(i);
        if (isEmptyList()) {
            createFirstNode(value);
        } else if (i == 0) {
            insertAtTheBeginning(value);
        }
    }

    private void createFirstNode(int value) {
        DoublyNode node = new DoublyNode(value);
        node.setNext(null);
        node.setPrevious(null);
        this.head = node;
        this.tail = node;
        this.size = 1;
    }

    private void validPositionToInsert(int i) {
        if (i > this.size || i < 0) {
            throw new IndexOutOfBoundsException("Invalid position for this value to be inserted");
        }
    }

    private void validPositionToRead(int i) {
        if (i >= this.size || i < 0) {
            throw new IndexOutOfBoundsException("Invalid position for this value to be read");
        }
    }

    private boolean isEmptyList() {
        return size == 0;
    }

    public void showAllFromHeadToTail() {
        DoublyNode temp = head;
        if (temp == null) {
            System.out.println("There's no element in this list");
        } else {
            System.out.print(temp.getValue());
            temp = temp.getNext();
        }
        while (temp != null) {
            System.out.print(" -> " + temp.getValue());
            temp = temp.getNext();
        }
    }

    public void showAllFromTailToHead() {
        DoublyNode temp = tail;
        if (temp == null) {
            System.out.println("There's no element in this list");
        } else {
            System.out.print(temp.getValue());
            temp = temp.getPrevious();
        }
        while (temp != null) {
            System.out.print(" -> " + temp.getValue());
            temp = temp.getPrevious();
        }
    }
}
