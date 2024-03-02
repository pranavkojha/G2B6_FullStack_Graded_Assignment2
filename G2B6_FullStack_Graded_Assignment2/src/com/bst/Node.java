package com.bst;

/**
 * This is the node class that represents each node of a tree
 */
public class Node {
    // Attributes
    private int value;
    private Node left;
    private Node right;

    // Constructor
    public Node(int value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }

    // Getters and setters defined below.

    /**
     * Returns the data of node.
     * @return Returns integer data or value of this node.
     */
    public int getValue() {
        return value;
    }

    /**
     * This setter is used to set value of a node. 
     * 
     * @param value This method sets data in each node. 
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 
     * @return This method returns the left child of this node.
     */
    public Node getLeft() {
        return this.left;
    }

    /**
     *
     * @param left This method sets the left child of this node.
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     *
     * @return This method returns the right child of this node.
     */
    public Node getRight() {
        return right;
    }

    /**
     *
     * @param right This method sets the right child of this node.
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * This method is used to set child node of given parent node. If value < parent then
     * child node is set as left Child, otherwise, the nodes is set as right Child.
     *
     * @param parent Parent node.
     * @param child Child node.
     */
    public void setChild(Node parent, Node child) {
        if(child.getValue() < parent.getValue()) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    /**
     * This method prints all nodes in the give nodes and child nodes.
     *
     * @return String with all nodes, including all child nodes.
     */
    @Override
    public String toString() {
        return "BinaryTree{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
