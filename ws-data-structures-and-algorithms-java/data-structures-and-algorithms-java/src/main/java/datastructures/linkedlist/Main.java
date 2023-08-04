package datastructures.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(5);

        myLinkedList.append(7);
        myLinkedList.append(8);
        myLinkedList.prepend(3);
        myLinkedList.set(0, 2);
        myLinkedList.insert(1, 4);
        myLinkedList.remove(3);
        myLinkedList.reverse();
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();
        myLinkedList.printList();

        myLinkedList.removeLast();
        myLinkedList.removeFirst();
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();
        myLinkedList.printList();
    }
}