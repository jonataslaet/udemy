package section08;

public class Main {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(0, 10);
        list.insert(1, 20);
        list.insert(2, 30);
        list.insert(3, 40);
        list.insert(4, 50);

        list.showAll();
        String rotated = list.rotate(3);
        System.out.println("Rotated = " + rotated);
        list.showAll();
    }
}
