package bagrut.summer2022;

import data.BinaryNode;

public class Ex2 {
    public static void main(String[] args) {
        BinaryNode<Character> u1 = new BinaryNode<Character>('u');
        BinaryNode<Character> p1 = new BinaryNode<Character>('p');
        BinaryNode<Character> l1 = new BinaryNode<Character>('l');
        BinaryNode<Character> u2 = new BinaryNode<Character>('u');
        BinaryNode<Character> e1 = new BinaryNode<Character>('e');
        BinaryNode<Character> n1 = new BinaryNode<Character>('n');
        BinaryNode<Character> p2 = new BinaryNode<Character>('p');
        BinaryNode<Character> tree1 = new BinaryNode<Character>('h');
        tree1.setLeft(n1); n1.setLeft(p1);
        tree1.setRight(e1); e1.setLeft(u1);
        e1.setRight(l1); l1.setRight(p2); p2.setRight(u2);
        System.out.println("Ex 1: " + isWordFromRoot(tree1, "help"));
    
        BinaryNode<Character> v1 = new BinaryNode<Character>('v');
        BinaryNode<Character> e3 = new BinaryNode<Character>('e');
        BinaryNode<Character> l2 = new BinaryNode<Character>('l');
        BinaryNode<Character> p3 = new BinaryNode<Character>('p');
        BinaryNode<Character> tree2 = new BinaryNode<Character>('h');
        tree2.setRight(v1); v1.setRight(e3); e3.setLeft(l2); l2.setLeft(p3);
        System.out.println("Ex 2: " + isWordFromRoot(tree2, "help"));
    }
    
    public static boolean isWordFromRoot(BinaryNode<Character> tree, String string) {
        if (string.length() == 0) return true;
        if (tree == null) return false;
        String trimmed = string.substring(1);
        return tree.getData() == string.charAt(0) && (
                isWordFromRoot(tree.getLeft(), trimmed) || isWordFromRoot(tree.getRight(), trimmed));
    }
    
}
