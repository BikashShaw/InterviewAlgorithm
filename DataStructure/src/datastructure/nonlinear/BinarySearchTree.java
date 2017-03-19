package datastructure.nonlinear;

import java.util.LinkedList;

/**
 * Created by Bikash on 3/11/2017.
 */
public class BinarySearchTree {

    BinaryTreeNode root;
    int size = 0;

    //Time Complexity Average: Θ(log(h)) Worst: O(h)
    public void insert(int data) {
        size++;

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

    public void breadthFirstTraverse(BinaryTreeNode rootNode) {
        java.util.Queue<BinaryTreeNode> binaryTreeNodeQueue = new LinkedList<>();
        binaryTreeNodeQueue.add(rootNode);
        while (!binaryTreeNodeQueue.isEmpty()) {
            BinaryTreeNode polledBinaryTreeNode = binaryTreeNodeQueue.poll();
            System.out.println(polledBinaryTreeNode.data);
            if(polledBinaryTreeNode.leftChild != null) {
                binaryTreeNodeQueue.add(polledBinaryTreeNode.leftChild);
            }

            if(polledBinaryTreeNode.rightChild != null) {
                binaryTreeNodeQueue.add(polledBinaryTreeNode.rightChild);
            }
        }
    }

    public void sumRootToLeaf(BinaryTreeNode rootNode, int sum) {
        if (rootNode == null) {
            System.out.println(sum);
            return;
        }

        if (!(rootNode.leftChild == null && rootNode.rightChild != null)) {
            sumRootToLeaf(rootNode.leftChild, rootNode.data + sum);
        }

        if (!(rootNode.rightChild == null && rootNode.leftChild != null)) {
            sumRootToLeaf(rootNode.rightChild, rootNode.data + sum);
        }
    }


    public static void main(String[] args) {

//        insertAndTraverse();

        BinarySearchTree binarySearchTree = getBinarySearchTree();

        binarySearchTree.sumRootToLeaf(binarySearchTree.root, 0);
    }

    private static void insertAndTraverse() {
        BinarySearchTree binarySearchTree = getBinarySearchTree();

        performTraverse(binarySearchTree);
    }

    private static BinarySearchTree getBinarySearchTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(20);
        binarySearchTree.insert(14);
        binarySearchTree.insert(32);
        binarySearchTree.insert(36);
        binarySearchTree.insert(37);
        binarySearchTree.insert(19);
        binarySearchTree.insert(30);
        binarySearchTree.insert(12);
        binarySearchTree.insert(29);
        return binarySearchTree;
    }

    private static void performTraverse(BinarySearchTree binarySearchTree) {
        System.out.println("Pre-Order Traverse");
        binarySearchTree.preOrderTraverse(binarySearchTree.root);
        System.out.println("In-Order Traverse");
        binarySearchTree.inOrderTraverse(binarySearchTree.root);
        System.out.println("Post-Order Traverse");
        binarySearchTree.postOrderTraverse(binarySearchTree.root);
        System.out.println("Breadth First Traverse");
        binarySearchTree.breadthFirstTraverse(binarySearchTree.root);
    }


}
