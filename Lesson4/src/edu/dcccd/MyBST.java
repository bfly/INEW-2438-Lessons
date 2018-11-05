package edu.dcccd;

class MyBST<T extends Comparable<? super T>> extends BST<T> {

    private int rights;

    MyBST() {}      // constructor

    void preorder() {                // preOrder traversal
        preorder(root);
    }
    private void preorder(BSTNode<T> p) {
        if (p != null) {
            visit(p);
            preorder(p.left);
            preorder(p.right);
        }
    }

    void postorder() {                // postOrder traversal
        postorder(root);
    }
    private void postorder(BSTNode<T> p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            visit(p);
        }
    }

    /*
   * To count number of nodes
   */
    int countNodes() {
        return countNodes(root);
    }       // count nodes
    private int countNodes(BSTNode<T> node) {
        if (node == null) return 0;
        else return 1 + countNodes(node.left) + countNodes(node.right);
    }

   /*
   * To count height of the tree
   */
   int countHeight() {
        return countHeight(root);
    }       // count height
   private int countHeight(BSTNode<T> node) {
        if (node == null) return 0;
        else return 1 + max(countHeight(node.left), countHeight(node.right));
   }
    private int max(int left, int right) {
        return (left > right) ? left : right;
    }
   /*
   * To count number of leaves in the tree
   */
   int countLeaves() {
        return countLeaves(root);
    }           // count leaves
   private int countLeaves(BSTNode<T> node) {
       if (node == null) return 0;
       else if (node.left == null && node.right == null)
           return 1;
       else
           return countLeaves(node.left) + countLeaves(node.right);
   }

   /*
   * To count number of right children
   */
   int countRightChildren() {
       rights = 0;
       countRightChildren(root);
       return rights;
    }       // count right children
   private void countRightChildren(BSTNode<T> node) {
       if ( node != null ) {
            if(node.right != null) rights++;
            countRightChildren(node.right);
            countRightChildren(node.left);
       }
   }

   /*
   * To delete all the leaf nodes in the tree
    */
    void deleteAllLeaves() {
        deleteAllLeaves(root);
    }   // delete all leaves

    private BSTNode<T> deleteAllLeaves(BSTNode<T> node) {
        if (node == null) return null;
        else if (node.left == null && node.right == null) return null;
        else {
            node.left = deleteAllLeaves(node.left);
            node.right = deleteAllLeaves(node.right);
            return node;
        }
    }
}
