package datastructures.doublylinkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(7);
        doublyLinkedList.printList();
        doublyLinkedList.append(3);
        doublyLinkedList.printList();
    }
}
