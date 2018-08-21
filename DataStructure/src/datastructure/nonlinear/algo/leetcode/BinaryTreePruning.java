package datastructure.nonlinear.algo.leetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/binary-tree-pruning/description/
 */
public class BinaryTreePruning {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return null;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            TreeNode left = poll.left;
            if(left != null && !isAllZeroSubtree(left)) {
                queue.add(left);
            } else {
                poll.left = null;
            }

            TreeNode right = poll.right;

            if(right != null && !isAllZeroSubtree(right)) {
                queue.add(right);
            } else {
                poll.right = null;
            }
        }

        return root;
    }

    private boolean isAllZeroSubtree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val != 0) {
            return false;
        }
        if(root.val == 0 && root.left == null && root.right == null) {
            return true;
        }

        return isAllZeroSubtree(root.left) && isAllZeroSubtree(root.right);
    }
}
