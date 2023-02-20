package hw10;

import unit4.collectionsLib.BinNode;
import unit4.collectionsLib.Queue;

import java.lang.invoke.SerializedLambda;

public class Ex3 {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
         BinTreeLambda lambda = (x) -> {
             if (x != null) q.insert(x.getValue());
        };
         while (!q.isEmpty()) System.out.println(q.remove());
    }
    
    interface BinTreeLambda {
        void run(BinNode<Integer> x);
    }
    
    public static void treeValuesByLevel(BinNode<Integer> root, BinTreeLambda lambda) {
        Queue<BinNode<Integer>> q = new Queue<>();
        
    }
    
    public static void printByLevelWrapper(BinNode<Integer> root) {
        Queue<BinNode<Integer>> q = new Queue<>();
        printByLevel(root, q);
        while (!q.isEmpty()) {
            BinNode<Integer> x = q.remove();
            System.out.println(x != null ? x.getValue() : "null");
        }
    }
    
    public static void printByLevel(BinNode<Integer> root, Queue<BinNode<Integer>> q) {
        if (root == null) return;
        q.insert(root);
        
    }
}
