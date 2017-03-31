package datastructure.nonlinear;

/**
 * Convert sorted array to minimum height binary search tree
 * Created by Bikash on 3/30/2017.
 */
public class MinBST {

    public  BinarySearchTree creatBST(int arr[]) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.root = creatBST(arr,  0, arr.length - 1);

        return binarySearchTree;
    }


    private BinaryTreeNode creatBST(int arr[],  int low, int high) {
        if(low > high)  {
            return null;
        }

        int mid = (high + low) / 2;

        BinaryTreeNode node = new BinaryTreeNode(arr[mid]);

        node.leftChild = creatBST(arr,  low,mid-1);

        node.rightChild = creatBST(arr,  mid+1,high);

        return node;

    }



    public static void main(String[] args) {
        MinBST minBST = new MinBST();
        BinarySearchTree binarySearchTree = minBST.creatBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        binarySearchTree.inOrderTraverse(binarySearchTree.root);
        System.out.println("Is Balanced: " + binarySearchTree.isBalanced(binarySearchTree.root));
    }
}
