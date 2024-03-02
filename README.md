# G2B6_FullStack_Graded_Assignment2
GL Group Graded Assignment 2 - G2B6 group

## Q1. Floor plan

### Sample output

## Q2. Skewed BST
We have implements 2 ways to create skewed BST:
 Method 1: Uses sorting of elements in BST and create a new BST.
   <pre> bst.getRightSkewedTree("sort"); </pre>
 Method 2: Makes use of in-order traversal to print the BST. 
   <pre> bst.getRightSkewedTree("inorder");</pre>

### Sample output

<pre>Binary Tree created: 
BinaryTree{value=50, left=BinaryTree{value=30, left=BinaryTree{value=10, left=null, right=BinaryTree{value=20, left=null, right=null}}, right=null}, right=BinaryTree{value=60, left=BinaryTree{value=55, left=null, right=null}, right=null}}

 Sorted BST Method 1: 
BinaryTree{value=10, left=null, right=BinaryTree{value=20, left=null, right=BinaryTree{value=30, left=null, right=BinaryTree{value=50, left=null, right=BinaryTree{value=55, left=null, right=BinaryTree{value=60, left=null, right=null}}}}}}
Inorder BST Method 2: 
BinaryTree{value=10, left=null, right=BinaryTree{value=20, left=null, right=BinaryTree{value=30, left=null, right=BinaryTree{value=50, left=null, right=BinaryTree{value=55, left=null, right=BinaryTree{value=60, left=null, right=null}}}}}}
</pre>
