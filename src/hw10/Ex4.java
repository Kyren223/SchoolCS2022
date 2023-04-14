package hw10;

import unit4.binTreeCanvasLib.BinTreeCanvas;
import unit4.collectionsLib.BinNode;

import java.util.Random;

public class Ex4 {
    public static void main(String[] args) {
        Random random = new Random();
        BinNode<Integer> bt1 = new BinNode<>(random.nextInt());
        bt1.setLeft(new BinNode<>(random.nextInt()));
        bt1.setRight(new BinNode<>(random.nextInt()));
        bt1.getRight().setLeft(new BinNode<>(random.nextInt()));
        bt1.getRight().setRight(new BinNode<>(random.nextInt()));
        BinNode<Integer> bt2 = new BinNode<>(random.nextInt());
        bt2.setLeft(new BinNode<>(random.nextInt()));
        bt2.setRight(new BinNode<>(random.nextInt()));
        bt2.getRight().setLeft(new BinNode<>(random.nextInt()));
        //bt2.getRight().setRight(new BinNode<>(random.nextInt()));
        System.out.println(isSameTree(bt1,bt2));
    }
    
    public static void printStrings(BinNode<String> root, char c) {
        if (root == null) return;
        if (root.getValue().contains(String.valueOf(c))) System.out.println(root.getValue());
        printStrings(root.getLeft(), c);
        printStrings(root.getRight(), c);
    }
    
    public static void replace(BinNode<String> root, String s1, String s2) {
        if (root == null) return;
        if (root.getValue().equals(s1)) root.setValue(s2);
        replace(root.getLeft(), s1, s2);
        replace(root.getRight(), s1, s2);
    }
    
    public static int numNodesInLevel(BinNode<Integer> root, int level) {
        return numNodesInLevelHelper(root, 0, level);
    }
    
    public static int numNodesInLevelHelper(BinNode<Integer> root, int curr, int level) {
        if (root == null) return 0;
        if (curr == level) return 1;
        int left = numNodesInLevelHelper(root.getLeft(), curr + 1, level);
        int right = numNodesInLevelHelper(root.getRight(), curr + 1, level);
        return left + right;
    }
    
    public static BinNode<String> buildIdent(BinNode<String> root) { 
        if (root == null) return null;
        BinNode<String> nbt = new BinNode<>(root.getValue());
        nbt.setLeft(buildIdent(root.getLeft()));
        nbt.setRight(buildIdent(root.getRight()));
        return nbt;
    }
    
    public static BinNode<Integer> buildRandomTree(int maxLevels) {
        BinNode<Integer> nbt = buildRandomTree(maxLevels, 0);
        if (nbt == null) nbt = new BinNode<Integer>(new Random().nextInt());
        return nbt;
    }
    
    public static BinNode<Integer> buildRandomTree(int maxLevels, int curr) {
        if (curr > maxLevels) return null;
        Random random = new Random();
        if (random.nextInt() % 3 == 0) return null;
        BinNode<Integer> nbt = new BinNode<>(random.nextInt());
        nbt.setLeft(buildRandomTree(maxLevels, curr + 1));
        nbt.setRight(buildRandomTree(maxLevels, curr + 1));
        return nbt;
    }
    
    public static BinNode<Integer> buildTree(int[] preorder, int[] inorder) {
        return null;
    }
    
    public static int getChildDifference(BinNode<Integer> root) {
        if (root == null) return 0;
        return getSingleChildCount(root.getLeft()) - getSingleChildCount(root.getRight());
    }
    
    public static int getSingleChildCount(BinNode<Integer> root) {
        if (root == null) return 0;
        int left = getSingleChildCount(root.getLeft());
        int right = getSingleChildCount(root.getRight());
        boolean dis = root.hasLeft() ^ root.hasRight();
        return left + right + (dis ? 1 : 0);
    }
    
    public static boolean isSameTree(BinNode<Integer> bt1, BinNode<Integer> bt2) {
        if (bt1 == null && bt2 == null) return true;
        if (bt1 == null || bt2 == null) return false;
        return isSameTree(bt1.getLeft(), bt2.getLeft()) && isSameTree(bt1.getRight(), bt2.getRight());
    }
    
    /*
    B.1. 2/42 (1/21)
      2. 15 5/7 (110/7)
    */
    
}
