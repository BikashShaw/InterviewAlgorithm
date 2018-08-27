package datastructure.nonlinear;

/**
 * Created by Bikash on 4/25/2017.
 * Description: https://leetcode.com/problems/invert-binary-tree/description/
 */
public class InvertBinaryTreeProblem {

    public BinaryTreeNode invertTree(BinaryTreeNode root) {

        helper(root);

        return root;
    }

    private void helper(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        BinaryTreeNode l = root.leftChild;

        root.leftChild = root.rightChild;
        root.rightChild = l;

        helper(root.leftChild);
        helper(root.rightChild);
    }


}
