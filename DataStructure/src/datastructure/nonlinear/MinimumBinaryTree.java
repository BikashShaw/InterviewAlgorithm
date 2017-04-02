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
    }
}
