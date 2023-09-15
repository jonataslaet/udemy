package datastructures;

import datastructures.binarysearchtree.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(3);
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(9);
        binarySearchTree.insert(8);
        System.out.println(binarySearchTree.getRoot().getRight().getRight().getLeft().getValue());
        System.out.println(binarySearchTree.contains(3));
        System.out.println(binarySearchTree.contains(5));
    }
}