package edu.dcccd;

/* Write a program:
 * a. to print the tree in inOrder.
 * b. to print the tree in preOrder.
 * c. to print the tree in postOrder.
 * d. to print the tree horizontally.
 * e. to count the number of nodes in a binary tree.
 * f. to count the number of leaves.
 * g. to count the number of right children.
 * h. to find the height of the tree.
 * i. to delete all leaves from a binary tree.*/

import java.security.SecureRandom;

public class Main {

    private void go() {
//        MyBST<Integer> myBst = new MyBST<>();
//        final Integer[] nodes = new Integer[] {34, 42, 22, 6, 7, 9, 1, 89, 77, 100};
//        for ( Integer node : nodes ) myBst.insert(node);
//        MyBST<String> myBst = new MyBST<>();
//        final String[] nodes = new String[] {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
//        for (String node : nodes) myBst.insert(node);
        MyBST<Card> myBst = new MyBST<>();
        final Card[] nodes = new Card[10];
        SecureRandom random = new SecureRandom();
        for ( int i = 0; i < nodes.length; i++ ) {
            myBst.insert(new Card(random.nextInt(Card.RANK_NAMES.length),
                                  random.nextInt(Card.SUIT_NAMES.length)));
        }
        /*  Display tree  */
        System.out.print("Inorder traversal is ");
        myBst.inorder();

        System.out.print("\nPreorder traversal is ");
        myBst.preorder();

        System.out.print("\nPostorder traversal is ");
        myBst.postorder();
        System.out.println();

        myBst.printTree();
        
        System.out.printf("Total nodes are %d.\n", myBst.countNodes());
        System.out.printf("Total leaves are %d.\n", myBst.countLeaves());
        System.out.printf("Total right children are %d.\n", myBst.countRightChildren());
        System.out.printf("The height of the tree is %d.\n", myBst.countHeight());
        System.out.println("Deleting all leaves...");
        myBst.deleteAllLeaves();

        myBst.printTree();
    }

    public static void main(String[] args) {
        new Main().go();
    }
}
