package section08;

public class Main {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(0, 10);
        list.insert(0, 20);
        list.insert(0, 30);
        Node removedNode = null;
//        removedNode = list.pop();
        removedNode = list.remove(1);
        System.out.println("Removed node value = " + removedNode.getValue());
        list.showAll();
    }
}
