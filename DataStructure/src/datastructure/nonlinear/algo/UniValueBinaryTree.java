package datastructure.nonlinear.algo;

import datastructure.nonlinear.BinaryTree;
import datastructure.nonlinear.BinaryTreeNode;

public class UniValueBinaryTree {

    public static void main(String[] args) {
        BinaryTree nonUniValBinarySearchTree = new BinaryTree();
        nonUniValBinarySearchTree.binaryBalancedTreeInsert(10);
        nonUniValBinarySearchTree.binaryBalancedTreeInsert(11);
        nonUniValBinarySearchTree.binaryBalancedTreeInsert(9);
        nonUniValBinarySearchTree.binaryBalancedTreeInsert(7);
        nonUniValBinarySearchTree.binaryBalancedTreeInsert(15);
        nonUniValBinarySearchTree.binaryBalancedTreeInsert(8);
        nonUniValBinarySearchTree.binaryBalancedTreeInsert(12);

        nonUniValBinarySearchTree.breadthFirstTraverse(nonUniValBinarySearchTree.root);
        System.out.println(isUniValueBinaryTree(nonUniValBinarySearchTree.root));


        BinaryTree uniValBinarySearchTree = new BinaryTree();
        uniValBinarySearchTree.binaryBalancedTreeInsert(5);
        uniValBinarySearchTree.binaryBalancedTreeInsert(5);
        uniValBinarySearchTree.binaryBalancedTreeInsert(5);
        uniValBinarySearchTree.binaryBalancedTreeInsert(5);
        uniValBinarySearchTree.binaryBalancedTreeInsert(5);
        uniValBinarySearchTree.binaryBalancedTreeInsert(5);
        uniValBinarySearchTree.binaryBalancedTreeInsert(5);

        System.out.println(isUniValueBinaryTree(uniValBinarySearchTree.root));

    }

    public static boolean isUniValueBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.leftChild != null && root.leftChild.data != root.data) {
            return false;
        }
        if (root.rightChild != null && root.rightChild.data != root.data) {
            return false;
        }

        return isUniValueBinaryTree(root.leftChild) && isUniValueBinaryTree(root.rightChild);
    }
}
