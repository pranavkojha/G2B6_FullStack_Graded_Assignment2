package com.bst;

import java.util.ArrayList;

/**
 * This class implements Binary Search Tree Implementation.
 */
public class BinarySearchTree {
    private Node root;
    private Node skewedTreeRoot;
    private Node prevNode;

    // Constructors.
    public BinarySearchTree() {
        this.root = null;
        this.skewedTreeRoot = null;
        this.prevNode = null;
    }

    public BinarySearchTree(Node tree) {
        this.root = tree;
        this.skewedTreeRoot = null;
        this.prevNode = null;
    }

    /**
     *
     * @return this method return root node of the BST.
     */
    public Node getRoot(){
        return this.root;
    }

    /**
     * This method is used to insert node into this BST.
     * @param val Integer value to be inserted.
     */
    public void insertNode(int val) {
        Node node = new Node(val);
        this.insertNode(node);
    }

    /**
     * This method is used to insert node into this BST.
     * @param child Node to be insterted.
     */
    public void insertNode(Node child) {
        //System.out.println("\t\tInserting child: " + child);
        if(this.root==null) {
            this.root = child;
            return;
        } else {
            Node parent = this.findNodeInsertionLocation(this.root, child);
            parent.setChild(parent, child);
        }
    }

    /**
     * This method returns the parent node under which a node needs to be inserted.
     *
     * @param subTree Node that needs to be traversed.
     * @param newNode New child node that needs to be inserted.
     * @return parent Node under which given child node should be inserted.
     */
    private Node findNodeInsertionLocation(Node subTree, Node newNode) {
        // If given Subtree is a leaf node insert child under at the subTree.
        if(subTree.getLeft() == null && subTree.getRight()==null)
            return subTree;

        // If child is smaller than given tree, we traverse the left Sub-Tree.
        if(newNode.getValue() < subTree.getValue()) {
            if (subTree.getLeft() == null) {
                return subTree;
            } else {
                return findNodeInsertionLocation(subTree.getLeft(), newNode);
            }
        }
        // If child is greater than or equal to given tree, we traverse the right Sub-Tree.
        else
        {
            if (subTree.getRight() == null) {
                return subTree;
            } else {
                return findNodeInsertionLocation(subTree.getRight(), newNode);
            }
        }
    }

    /**
     * This routine traverse BST in-order which gives the elements in sorted order (ascending).
     *
     * @param node Tree root.
     * @param arrayList This array stores the elements in sorted order.
     */
    private void inOrderTraversal(Node node, ArrayList<Integer> arrayList) {
        if(node==null) {
            return;
        }
        inOrderTraversal(node.getLeft(), arrayList);
        arrayList.add(node.getValue());
        inOrderTraversal(node.getRight(), arrayList);
    }

    /**
     * This method returns skewed tree by:
     *  1. Traversing tree in-order to get all nodes in ascending order.
     *  2. Creates a new BST using the sorted elements and returns this newly created BST.
     *
     * @return new skewed BST.
     */
    private BinarySearchTree getRightSkewedTree_sort() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Fetch all nodes in sorted order into arrayList
        inOrderTraversal(this.root, arrayList);

        // Create a new skewed Binary tree by going over each element in arrayList.
        BinarySearchTree bst = new BinarySearchTree();
        arrayList.forEach((n) -> bst.insertNode(n));
        return bst;
    }

    /**
     * This method goes calls a recursive method that actually implements the logic to create
     * skewed BST.
     *
     * @return Skewed BST.
     */
    private BinarySearchTree getRightSkewedTree_inOrder() {
        getRightSkewedTree_inOrderImpl(this.root);
        BinarySearchTree skewed_tree = new BinarySearchTree(this.skewedTreeRoot);

        // Reset temp values
        this.prevNode = null;
        this.skewedTreeRoot = null;

        return skewed_tree;
    }

    /**
     * This method traverses in-order to create a skewed tree as the nodes are traversed
     * in ascending order in a BST.
     *
     * @param root_node SubTree that needs to be traversed.
     */
    private void getRightSkewedTree_inOrderImpl(Node root_node) {
        if(root_node==null) {
            return;
        }

        // Goto the left most node.
        getRightSkewedTree_inOrderImpl(root_node.getLeft());

        // Start constructing the skewed tree.
        if(this.skewedTreeRoot==null) {
            // If skewed tree does not exist create a new one with left node as null.
            this.skewedTreeRoot=root_node;
            this.skewedTreeRoot.setLeft(null);
            // save prevNode for next iteration.
            this.prevNode = root_node;
        } else {
            // As we are trversnig in-order we will get the next value in ascending order.
            // Set next node as right node.
            this.prevNode.setRight(root_node);
            root_node.setLeft(null);
            this.prevNode = root_node;
        }

        // Traverse the right node.
        getRightSkewedTree_inOrderImpl(root_node.getRight());
    }

    /**
     * We have implemented 2 ways of constructing a right skewed BST. This method decides which
     * of the 2 implementations of skewed tree implementation is invoked based on "method"
     * parameter.
     *
     * @param method String that defines if we will use the sort method or inorder traversal to
     *               create a right skewed BST.
     * @return Right skewed BST.
     */
    public BinarySearchTree getRightSkewedTree(String method) {
        com.bst.BinarySearchTree bst = new com.bst.BinarySearchTree();
        switch(method) {
            case "sort":
                return getRightSkewedTree_sort();
            default:
                return getRightSkewedTree_inOrder();
        }
    }
}
