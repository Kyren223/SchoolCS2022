package hw10;

import data.BinaryNode;
import unit4.binTreeCanvasLib.BinTreeCanvas;
import unit4.binTreeUtilsLib.BinTreeUtils;
import unit4.collectionsLib.BinNode;

import java.util.Scanner;

public class Ex2 {
    
    public static void main(String[] args) {
        //System.out.println(createTreeWrapper().toString());
        BinNode<Integer> node = BinTreeUtils.buildRandomTree(30, 0, 10);
        BinTreeCanvas.addTree(node);
        System.out.println(getNodesAtLevel(node, 0, 3));
    }
    
    public static BinNode<Integer> createTreeWrapper() {
        return createTree("root's");
    }
    
    public static BinNode<Integer> createTree(String side) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter " + side + " value: ");
        BinNode<Integer> node = new BinNode<>(in.nextInt());
        if (node.getValue() == -1) return null;
        node.setLeft(createTree("left"));
        node.setRight(createTree("right"));
        return node;
    }
    
    public static void printLeftLeaves(BinNode<Integer> root, boolean isLeft) {
        if (root == null) return;
        if (root.getLeft() == null && root.getRight() == null && isLeft)
            System.out.println(root.getValue() + ", ");
        printLeftLeaves(root.getLeft(), true);
        printLeftLeaves(root.getRight(), false);
    }
    
    public static void printFatParent(BinNode<Integer> root) {
        if (root == null) return;
        int left = root.getLeft() != null ? root.getLeft().getValue() : 0;
        int right = root.getRight() != null ? root.getRight().getValue() : 0;
        if (left + right < root.getValue()) System.out.println(root.getValue() + ", ");
        printFatParent(root.getLeft());
        printFatParent(root.getRight());
    }
    
    public static void printLevelWrapper(BinNode<Integer> root, int lvl) {
        printLevel(root, 0, lvl);
    }
    
    public static void printLevel(BinNode<Integer> root, int currentLvl, int lvl) {
        if (root == null) return;
        if (currentLvl == lvl) System.out.println(root.getValue() + ", ");
        printLevel(root.getLeft(), currentLvl + 1, lvl);
        printLevel(root.getRight(), currentLvl + 1, lvl);
    }
    
    public static int getNumOfLeaves(BinNode<Integer> root) {
        if (root == null) return 0;
        if (root.getLeft() == null && root.getRight() == null) return 1;
        return getNumOfLeaves(root.getLeft()) + getNumOfLeaves(root.getRight());
    }
    
    public static int getCount(BinNode<Integer> root, int num) {
        if (root == null) return 0;
        int x = root.getValue() == num ? 1 : 0;
        return getCount(root.getLeft(), num) + getCount(root.getRight(), num) + x;
    }
    
    public static int getNodesAtLevel(BinNode<Integer> root, int currentLvl, int lvl) {
        if (root == null) return 0;
        if (currentLvl == lvl) return 1;
        int left = getNodesAtLevel(root.getLeft(), currentLvl + 1, lvl);
        int right = getNodesAtLevel(root.getRight(), currentLvl + 1, lvl);
        return left + right;
    }
    
    public static boolean areAllEven(BinNode<Integer> root) {
        if (root == null) return true;
        boolean left = areAllEven(root.getLeft());
        boolean right = areAllEven(root.getRight());
        return left && right && (root.getValue() % 2 == 0);
    }
}
