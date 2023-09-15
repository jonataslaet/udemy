package datastructures.binarysearchtree;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {

    }

    public boolean insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return true;
        }
        Node temp = root;
        while (temp != null) {
            if (value == temp.getValue()) return false;
            if (value < temp.getValue()) {
                if (temp.getLeft() == null) {
                    temp.setLeft(node);
                    return true;
                }
                temp = temp.getLeft();
            } else if (value > temp.getValue()) {
                if (temp.getRight() == null) {
                    temp.setRight(node);
                    return true;
                }
                temp = temp.getRight();
            }
        }
        return false;
    }

    public Node getRoot() {
        return this.root;
    }
}
