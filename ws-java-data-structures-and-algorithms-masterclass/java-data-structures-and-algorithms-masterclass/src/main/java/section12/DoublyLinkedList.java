package section12;

public class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;
    private int size;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(int value) {
        this.createFirstNode(value);
    }

    private void createFirstNode(int value) {
        DoublyNode node = new DoublyNode(value);
        node.setNext(null);
        node.setPrevious(null);
        this.head = node;
        this.tail = node;
        this.size = 1;
    }

    public void showAll() {
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
}
