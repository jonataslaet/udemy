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
        tail.setNext(node);
        tail = node;
        size++;
    }

    private void insertBetweenTheBeginningAndTheEnd(int i, int value) {
        Node currentNode = new Node(value);
        Node previousNode = get(i-1);
        currentNode.setNext(previousNode.getNext());
        previousNode.setNext(currentNode);
        size++;
    }

    public void insert(int i, int value) {
        validPositionToInsert(i);
        if (size == 0) {
            createFirstNode(value);
        } else if (i == 0) {
            insertAtTheBeginning(value);
        } else if (i == size) {
            insertAtTheEnd(value);
        } else {
            insertBetweenTheBeginningAndTheEnd(i, value);
        }
    }

    public Node findValue(int value) {
        validPositionToRead(0);
        Node temp = head;
        while (temp != null) {
            if (temp.getValue() == value) return temp;
            temp = temp.getNext();
        }
        return null;
    }

    public Node remove(int i) {
        Node temp = head;
        if (temp == null) {
            return null;
        }
        if (i == 0) {
            if (size == 1) {
                head = null;
                tail = null;
                size--;
                return temp;
            }
            head = head.getNext();
            tail.setNext(head);
            size--;
            return temp;
        }
        Node previous = get(i-1);
        temp = previous.getNext();
        if (i == size - 1) {
            previous.setNext(head);
            tail = previous;
            size--;
            return temp;
        }
        previous.setNext(temp.getNext());
        size--;
        return temp;
    }

    public Integer getSize() {
        return this.size;
    }

    public Node getFirstNode() {
        return this.head;
    }

    public Node getLastNode() {
        return this.tail;
    }

    public Node get(int i) {
        validPositionToRead(i);
        int p = 0;
        Node temp = head;
        while (p++ < i) {
            temp = temp.getNext();
        }
        return temp;
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
