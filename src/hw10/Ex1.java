package hw10;

import data.BinaryNode;

public class Ex1 {
    public static void main(String[] args) {
    
    }
    
    public static void printEven(BinaryNode<Integer> root) {
        if (root == null) return;
        System.out.println(root.getData());
        printEven(root.getLeft());
        printEven(root.getRight());
    }
    
    public static void printLeavesCount(BinaryNode<Character> root) {
        System.out.println(printLeaves(root));
    }
    public static int printLeaves(BinaryNode<Character> root) {
        if (root == null) return 0;
        if (root.getLeft() == null && root.getRight() == null) return 1;
        return printLeaves(root.getLeft()) + printLeaves(root.getRight());
    }
    
    public static boolean contains(BinaryNode<Integer> root, int x) {
        if (root.getData() == x) return true;
        return contains(root.getLeft(), x) || contains(root.getRight(), x);
    }
    
    public static boolean isWholesomeTree(BinaryNode<Double> root) {
        if (root == null) return false;
        if (root.getLeft() == null && root.getRight() == null) return true;
        return isWholesomeTree(root.getLeft()) && isWholesomeTree(root.getRight());
    }
    
}
