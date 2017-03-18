package datastructure.nonlinear;

import datastructure.linear.Node;

/**
 * Created by Bikash on 3/11/2017.
 */
public class BinarySearchTree {

    BinaryTreeNode root;

    //Time Complexity Average: Θ(log(h)) Worst: O(h)
    public void insert(int data) {
        if (root == null) {
            root = new BinaryTreeNode(data);
        } else {
            BinaryTreeNode tempRoot = root;
            while (true) {
                if (data <= tempRoot.data && tempRoot.leftChild == null) {
                    tempRoot.leftChild = new BinaryTreeNode(data);
                    break;
                } else if(data <= tempRoot.data && tempRoot.leftChild != null) {
                    tempRoot = tempRoot.leftChild;
                    continue;
                } else if (data > tempRoot.data && tempRoot.rightChild == null) {
                    tempRoot.rightChild = new BinaryTreeNode(data);
                    break;
                }else if(data > tempRoot.data && tempRoot.rightChild != null) {
                    tempRoot = tempRoot.rightChild;
                    continue;
                }
            }
        }
    }

    public void preOrderTraverse(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        System.out.println(rootNode.data);
        preOrderTraverse(rootNode.leftChild);
        preOrderTraverse(rootNode.rightChild);
    }

    public void inOrderTraverse(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        preOrderTraverse(rootNode.leftChild);
        System.out.println(rootNode.data);
        preOrderTraverse(rootNode.rightChild);
    }

    public void postOrderTraverse(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        preOrderTraverse(rootNode.leftChild);
        preOrderTraverse(rootNode.rightChild);
        System.out.println(rootNode.data);
    }

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(20);
        binarySearchTree.insert(14);
        binarySearchTree.insert(32);
        binarySearchTree.insert(36);
        binarySearchTree.insert(37);
        binarySearchTree.insert(19);
        binarySearchTree.insert(30);

        performTraverse(binarySearchTree);

    }

    private static void performTraverse(BinarySearchTree binarySearchTree) {
        System.out.println("Pre-Order Traverse");
        binarySearchTree.preOrderTraverse(binarySearchTree.root);
        System.out.println("In-Order Traverse");
        binarySearchTree.inOrderTraverse(binarySearchTree.root);
        System.out.println("Post-Order Traverse");
        binarySearchTree.postOrderTraverse(binarySearchTree.root);
    }


}
