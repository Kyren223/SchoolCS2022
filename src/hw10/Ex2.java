package hw10;

import data.BinaryNode;
import unit4.binTreeCanvasLib.BinTreeCanvas;
import unit4.binTreeUtilsLib.BinTreeUtils;
import unit4.collectionsLib.BinNode;

import java.util.Scanner;

public class Ex2 {
    
    public static void main(String[] args) {
        //System.out.println(createTreeWrapper().toString());
        BinNode<Integer> node = BinTreeUtils.buildRandomTree(10, 1, 11);
        BinTreeCanvas.addTree(node);
        System.out.println(containsDivisibleByTen(node));
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
    
    public static boolean containsDivisibleByTen(BinNode<Integer> root) {
        if (root == null) return false;
        boolean left = containsDivisibleByTen(root.getLeft());
        boolean right = containsDivisibleByTen(root.getRight());
        return left || right || (root.getValue() % 10 == 0);
    }
    
    public static boolean isSumTreeWrapper(BinNode<Integer> root) {
        return isSumTree(root).isBool();
    }
    public static BoolInt isSumTree(BinNode<Integer> root) {
        if (root == null) return new BoolInt(true, 0);
        BoolInt left = isSumTree(root.getLeft());
        BoolInt right = isSumTree(root.getRight());
        boolean leftAndRight = left.isBool() && right.isBool();
        int sum = left.getInt() + right.getInt();
        return new BoolInt(leftAndRight && sum == root.getValue(), sum + root.getValue());
    }
    
    public static boolean isWholesomeTree(BinNode<Integer> root) {
        if (root == null) return false;
        if (root.getLeft() == null && root.getRight() == null) return true;
        boolean left = isWholesomeTree(root.getLeft());
        boolean right = isWholesomeTree2(root.getRight());
        return left && right;
    }
    
    public static boolean isWholesomeTree2(BinNode<Integer> root) {
        if (!root.hasLeft() && !root.hasRight()) return true; // Leaf
        root.getValue(); // If root is null, throws NPE
        try {
            // Catches potential NPE
            isWholesomeTree2(root.getLeft());
            isWholesomeTree2(root.getRight());
        } catch (NullPointerException e) {return false;}
        return true; // No NPE so it has 2 childs
    }
    
    public static boolean isDownwardTree(BinNode<Integer> root) {
        if (root.hasLeft() && root.hasRight()) return false;
        BinNode<Integer> child = root.hasLeft() ? root.getLeft() : root.getRight();
        if (child == null) return true;
        int childValue = child.getValue();
        return root.getValue() > childValue;
    }
    
    
}
