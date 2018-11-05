package edu.dcccd;

public class BST<T extends Comparable<? super T>> {
    protected BSTNode<T> root = null;

    BST() {}                                            // Constructor

    public void insert (T t) {                          // insert
        BSTNode<T> p = root, prev = null;
        while (p != null) {
            prev = p;
            if (t.compareTo(p.element) < 0)
                p = p.left;
            else p = p.right;
        }
        if (root == null)
            root = new BSTNode<T>(t);
        else if (t.compareTo(prev.element) < 0)
            prev.left  = new BSTNode<T>(t);
        else prev.right = new BSTNode<T>(t);
    }
    public T search(T el) {                             // search
        BSTNode<T> p = root;
        while (p != null)
            if (el.equals(p.element))
                return p.element;
            else if (el.compareTo(p.element) < 0)
                p = p.left;
            else p = p.right;
        return null;
    }
    protected void visit(BSTNode<T> p) {                // visit
        System.out.print(p.element + " ");
    }
    public void inorder() {
        inorder(root);
    }           // inorder traversal
    protected void inorder(BSTNode<T> p) {
        if (p != null) {
            inorder(p.left);
            visit(p);
            inorder(p.right);
        }
    }
    public void printTree() {
        printTree(root,0);
    }       // print tree horizontally
    protected void printTree(BSTNode<T> p, int depth) {
        if (p != null) {
            printTree(p.right,depth+1);
            for (int i = 1; i <= depth; i++)
                System.out.print("     ");
            System.out.println(p.element);
            printTree(p.left,depth+1);
        }
    }
}
