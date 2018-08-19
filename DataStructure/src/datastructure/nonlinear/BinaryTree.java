package datastructure.nonlinear;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Bikash on 3/11/2017.
 */
public class BinaryTree {

    public BinaryTreeNode root;
    int size = 0;

    //Also Level order insert
    public void binaryBalancedTreeInsert(int data) {
        size++;

        if (root == null) {
            root = new BinaryTreeNode(data);
        } else {
            java.util.Queue<BinaryTreeNode> binaryTreeNodeQueue = new LinkedList<>();
            binaryTreeNodeQueue.add(root);
            while (!binaryTreeNodeQueue.isEmpty()) {
                BinaryTreeNode node = binaryTreeNodeQueue.poll();
                if (node.leftChild == null) {
                    node.leftChild = new BinaryTreeNode(data);
                    break;
                } else if (node.rightChild == null) {
                    node.rightChild = new BinaryTreeNode(data);
                    break;
                } else {
                    binaryTreeNodeQueue.add(node.leftChild);
                    binaryTreeNodeQueue.add(node.rightChild);
                }
            }
        }
    }

    //Time Complexity Average: Θ(log(h)) Worst: O(h)
    public void binarySearchTreeInsert(int data) {
        size++;

        if (root == null) {
            root = new BinaryTreeNode(data);
        } else {
            BinaryTreeNode tempRoot = root;
            while (true) {
                if (data <= tempRoot.data && tempRoot.leftChild == null) {
                    tempRoot.leftChild = new BinaryTreeNode(data);
                    break;
                } else if (data <= tempRoot.data && tempRoot.leftChild != null) {
                    tempRoot = tempRoot.leftChild;
                    continue;
                } else if (data > tempRoot.data && tempRoot.rightChild == null) {
                    tempRoot.rightChild = new BinaryTreeNode(data);
                    break;
                } else if (data > tempRoot.data && tempRoot.rightChild != null) {
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
        inOrderTraverse(rootNode.leftChild);
        System.out.println(rootNode.data);
        inOrderTraverse(rootNode.rightChild);
    }

    public void postOrderTraverse(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        postOrderTraverse(rootNode.leftChild);
        postOrderTraverse(rootNode.rightChild);
        System.out.println(rootNode.data);
    }

    public void breadthFirstTraverse(BinaryTreeNode rootNode) {
        java.util.Queue<BinaryTreeNode> binaryTreeNodeQueue = new LinkedList<>();
        binaryTreeNodeQueue.add(rootNode);
        while (!binaryTreeNodeQueue.isEmpty()) {
            BinaryTreeNode polledBinaryTreeNode = binaryTreeNodeQueue.poll();
            System.out.println(polledBinaryTreeNode.data);
            if (polledBinaryTreeNode.leftChild != null) {
                binaryTreeNodeQueue.add(polledBinaryTreeNode.leftChild);
            }

            if (polledBinaryTreeNode.rightChild != null) {
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

    //Find Smallest and Largest sum
    public void sumMinMax(BinaryTreeNode rootNode, int sum, Map<String, Integer> minMaxSumMap) {
        if (rootNode == null) {
            if (minMaxSumMap.get("minSum") > sum) {
                minMaxSumMap.put("minSum", sum);
                System.out.println("Current Smallest Sum: " + sum);
            }

            if (minMaxSumMap.get("maxSum") < sum) {
                minMaxSumMap.put("maxSum", sum);
                System.out.println("Current Largest Sum: " + sum);
            }

            System.out.println("Sum: " + sum);
            return;
        }

        if (!(rootNode.leftChild == null && rootNode.rightChild != null)) {
            sumMinMax(rootNode.leftChild, rootNode.data + sum, minMaxSumMap);
        }

        if (!(rootNode.rightChild == null && rootNode.leftChild != null)) {
            sumMinMax(rootNode.rightChild, rootNode.data + sum, minMaxSumMap);
        }
    }

    public boolean isBalanced(BinaryTreeNode rootNode) {
        return (maxDepth(rootNode) - minDepth(rootNode) <= 1);
    }

    public int maxDepth(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(rootNode.leftChild), maxDepth(rootNode.rightChild));
    }

    public int minDepth(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            return 0;
        }

        return 1 + Math.min(minDepth(rootNode.leftChild), minDepth(rootNode.rightChild));
    }

    //O(n) - n is number of nodes
    public int findHeight(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            return -1;
        }

        int leftHeight = 1 + findHeight(rootNode.leftChild);
        int rightHeight = 1 + findHeight(rootNode.rightChild);

        return Math.max(leftHeight, rightHeight);
    }

    public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }

        BinaryTreeNode left = lowestCommonAncestor(root.leftChild, p, q);
        BinaryTreeNode right = lowestCommonAncestor(root.leftChild, p, q);

        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }

    //Time Complexity O(n) - n is number of nodes in tree
    public boolean isBinarySearchTree(BinaryTreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.data < min || node.data > max) {
            return false;
        }

        return isBinarySearchTree(node.leftChild, min, node.data + 1) && isBinarySearchTree(node.rightChild, node.data + 1, max);
    }

    public boolean isSubTree(BinaryTreeNode treeNode, BinaryTreeNode subTreeNode) {
        if (treeNode == null || subTreeNode == null) {
            return false;
        }
        if (treeNode.data == subTreeNode.data) {
            return compareEachNode(treeNode, subTreeNode);
        } else {
            return isSubTree(treeNode.leftChild, subTreeNode) || isSubTree(treeNode.rightChild, subTreeNode);
        }


    }

    private boolean compareEachNode(BinaryTreeNode treeNode, BinaryTreeNode subTreeNode) {
        if (subTreeNode == null) {
            return true;
        } else if (treeNode == null) {
            return false;
        } else {
            return treeNode.data == subTreeNode.data && compareEachNode(treeNode.leftChild, subTreeNode.leftChild)
                    && compareEachNode(treeNode.rightChild, subTreeNode.rightChild);
        }
    }


    public static void main(String[] args) {

        insertAndTraverse();

        BinaryTree binarySearchTree = getBinarySearchTree();

        System.out.println("Height of tree: " + binarySearchTree.findHeight(binarySearchTree.root));
        System.out.println("Is Binary Search tree: " + binarySearchTree.isBinarySearchTree(binarySearchTree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        binarySearchTree.sumRootToLeaf(binarySearchTree.root, 0);

        Map<String, Integer> map = new HashMap<>();
        map.put("minSum", Integer.MAX_VALUE);
        map.put("maxSum", Integer.MIN_VALUE);
        binarySearchTree.sumMinMax(binarySearchTree.root, 0, map);
    }

    private static void insertAndTraverse() {
        BinaryTree binarySearchTree = getBinarySearchTree();

        performTraverse(binarySearchTree);

        BinaryTreeNode lca = binarySearchTree.lowestCommonAncestor(binarySearchTree.root,
                binarySearchTree.root.leftChild.leftChild.rightChild, binarySearchTree.root.leftChild.rightChild);

        System.out.println("Lowest Common Ancestor: " + lca.data);

    }

    private static BinaryTree getBinarySearchTree() {
        BinaryTree binarySearchTree = new BinaryTree();
        binarySearchTree.binarySearchTreeInsert(20);
        binarySearchTree.binarySearchTreeInsert(14);
        binarySearchTree.binarySearchTreeInsert(32);
        binarySearchTree.binarySearchTreeInsert(36);
        binarySearchTree.binarySearchTreeInsert(37);
        binarySearchTree.binarySearchTreeInsert(19);
        binarySearchTree.binarySearchTreeInsert(30);
        binarySearchTree.binarySearchTreeInsert(12);
        binarySearchTree.binarySearchTreeInsert(29);
        return binarySearchTree;
    }


    private static void performTraverse(BinaryTree binarySearchTree) {
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

