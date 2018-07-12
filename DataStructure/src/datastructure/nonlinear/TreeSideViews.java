package datastructure.nonlinear;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

enum ViewType {
    LEFT,
    RIGHT
}

class TreeNode<T> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
        left = null;
        right = null;
    }
}

class Tree<T> {
    TreeNode<T> root;

    void inorder(TreeNode<T> node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.println(node.value);
        inorder(node.right);
    }

    List<T> view(TreeNode<T> root, ViewType viewType) {
        List<T> view = new ArrayList<>();
        Queue<TreeNode<T>> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }

        while (!q.isEmpty()) {
            view.add(q.peek().value);

            Queue<TreeNode<T>> nextLevel = new LinkedList<>();

            while (!q.isEmpty()) {
                TreeNode<T> node = q.poll();
                if (viewType == ViewType.LEFT) {
                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                }
            }
            q = nextLevel;
        }
        return view;
    }
}

public class TreeSideViews {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.root = new TreeNode<>(4);
        tree.root.left = new TreeNode<>(5);

        TreeNode<Integer> node = new TreeNode<>(2);
        tree.root.right = node;

        TreeNode<Integer> l = new TreeNode<>(3);
        node.left = l;

        TreeNode<Integer> r = new TreeNode<>(1);
        node.right = r;

        l.left = new TreeNode<>(6);

        l.right = new TreeNode<>(7);

        System.out.println("Inorder traversal");
        tree.inorder(tree.root);

        System.out.println("Left View");
        tree.view(tree.root, ViewType.LEFT).forEach(System.out::println);

        System.out.println("Right View");
        tree.view(tree.root, ViewType.RIGHT).forEach(System.out::println);
    }
}
