package section08;

public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public String rotate(int number) {
        int r = number % size;
        if (r == 0) return "No Rotation";
        int i = 0;
        Node temp = head;
        while (i++ < r-1) {
            temp = temp.getNext();
        }
        tail.setNext(head);
        head = temp.getNext();
        tail = temp;
        temp.setNext(null);
        return "Success";
    }

    public Node get(int i) {
        validPositionToRead(i);
        if (i == 0) return head;
        if (i == size - 1) return tail;
        int p = 0;
        Node temp = head;
        while (p++ < i) {
            temp = temp.getNext();
        }
        return temp;
    }

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

    public void deleteAll() {
        head = null;
        tail = null;
        size = 0;
    }

    public Node pop() {
        return remove(size - 1);
    }

    public Node remove(int i) {
        validPositionToRead(i);
        Node removedNode = head;
        if (size == 1) {
            deleteAll();
            return removedNode;
        }
        if (i == 0) {
            head = head.getNext();
            size--;
            return removedNode;
        }
        Node previous = get(i-1);
        removedNode = previous.getNext();
        previous.setNext(removedNode.getNext());
        return removedNode;
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
