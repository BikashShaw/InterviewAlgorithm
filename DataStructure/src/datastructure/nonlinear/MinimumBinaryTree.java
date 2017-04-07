package datastructure.nonlinear;

/**
 * Convert sorted array to minimum height binary search tree
 * Created by Bikash on 3/30/2017.
 */
public class MinimumBinaryTree {

    public BinaryTree createMinimumHeightBinaryTree(int arr[]) {

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.root = createMinimumHeightBinaryTree(arr,  0, arr.length - 1);

        return binaryTree;
    }


    private BinaryTreeNode createMinimumHeightBinaryTree(int arr[], int low, int high) {
        if(low > high)  {
            return null;
        }

        int mid = (high + low) / 2;

        BinaryTreeNode node = new BinaryTreeNode(arr[mid]);

        node.leftChild = createMinimumHeightBinaryTree(arr,  low,mid-1);

        node.rightChild = createMinimumHeightBinaryTree(arr,  mid+1,high);

        return node;

    }



    public static void main(String[] args) {
        MinimumBinaryTree minBST = new MinimumBinaryTree();
        BinaryTree binarySearchTree = minBST.createMinimumHeightBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        binarySearchTree.inOrderTraverse(binarySearchTree.root);
        System.out.println("Is Balanced: " + binarySearchTree.isBalanced(binarySearchTree.root));

        BinaryTree binaryTree = minBST.createMinimumHeightBinaryTree(new int[]{8, 7, 3, 4, 11, 6, 2, 7, 9});

        System.out.println("Is Binary Search Tree: " +  binaryTree.isBinarySearchTree(binaryTree.root,  Integer.MIN_VALUE, Integer.MAX_VALUE));

        BinaryTree bTree1 = minBST.createMinimumHeightBinaryTree(new int[]{5,8,9,10,11,12,13});
        System.out.println("***");
        bTree1.inOrderTraverse(bTree1.root);
        System.out.println("---");
        bTree1.preOrderTraverse(bTree1.root);
        BinaryTree bTree2 = minBST.createMinimumHeightBinaryTree(new int[]{8,9,10});
        System.out.println("***");
        bTree2.inOrderTraverse(bTree2.root);
        System.out.println("---");
        bTree1.preOrderTraverse(bTree2.root);
        System.out.println("Is sub tree: " + bTree1.isSubTree(bTree1.root, bTree2.root));
        ;


    }
}
