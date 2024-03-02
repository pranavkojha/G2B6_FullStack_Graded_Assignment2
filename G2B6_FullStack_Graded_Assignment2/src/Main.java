/**
 * Group assigment 2
 *
 * @author Pranav Kumar Ojha, Faisal Raza Khan, Haritha, Shreya Singh, Prajna
 *
 * Q1. This class show how to plan floor construction for skyscraper.
 *
 * Q2. This class shows how to convert a balanced BST to a Skewed tree.
 *
 * Example -
 *
 * Input:
 *                   50
 *                 /    \
 *                30     60
 *               / \    /
 *              10 20   55
 *
 * Output:
 *      10
 *       \
 *        20
 *         \
 *          30
 *           \
 *            50
 *             \
 *              55
 *               \
 *                60
 */

import com.bst.BinarySearchTree;
import com.bst.Node;
import com.floor.FloorPlan;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Test BST code.
        System.out.println("**************************");
        System.out.println("Testing skewed BST code");
        testBST();
        System.out.println("**************************\n");

        // Testing floor plan.
        System.out.println("**************************");
        System.out.println("Testing floor plan");
        testFloor();
        System.out.println("**************************\n");
    }
    public static void testFloor() {
        //Integer[] input = {3,1,2};
        FloorPlan fp = new FloorPlan();
        fp.printFloorPlan();
    }
    public static void testBST() {
        // Create BST
        Node Tree = new Node(50);
        BinarySearchTree bst = new BinarySearchTree(Tree);
        bst.insertNode(30);
        bst.insertNode(60);
        bst.insertNode(10);
        bst.insertNode(20);
        bst.insertNode(55);
        System.out.println("Binary Tree created: \n" + bst.getRoot() + "\n");

        // Print skewed tree with sorted method.
        BinarySearchTree skewed_bst = new BinarySearchTree();
        skewed_bst = bst.getRightSkewedTree("sort");
        System.out.println(" Sorted BST Method 1: \n" + skewed_bst.getRoot());

        // Print skewed tree using in-order traversal method.
        skewed_bst = bst.getRightSkewedTree("inorder");
        System.out.println("Inorder BST Method 2: \n" + skewed_bst.getRoot());
    }
}