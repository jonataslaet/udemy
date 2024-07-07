package section08;

public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public void insert(int i, int value){
        Node node = new Node(value);
        validPositionToInsert(i);
        if (size == 0) {
            this.head = node;
            this.tail = node;
        } else if (i == 0) {
            node.setNext(head);
            head = node;
        } else if (i == size) {
            tail.setNext(node);
            tail = node;
        } else {
            int p = 1;
            Node temp = head;
            while (temp.getNext() != null) {
                if (p++ == i) {
                    node.setNext(temp.getNext());
                    temp.setNext(node);
                    break;
                }
                temp = temp.getNext();
            }
        }
        size++;
    }

    private void validPositionToInsert(int i) {
        if (i > this.size || i < 0) {
            throw new IndexOutOfBoundsException("Invalid position for this value to be inserted");
        }
    }

    public void showAll() {
        Node temp = head;
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

}
