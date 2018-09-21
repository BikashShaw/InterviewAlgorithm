package datastructure.nonlinear.algo.amazon;

public class DistanceBetweenTwoBSTNodes
{

    Node root = null;
    public static void main(String[] args) {
        int values[] = {5, 6, 3, 1, 2, 4};
        new DistanceBetweenTwoBSTNodes().bstDistance(values, values.length, 2, 4);
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int bstDistance(int[] values, int n,
                           int node1, int node2)
    {

        for (int val : values) {
            insert(val);
        }


        return findDistance(root, node1, node2);
    }

    // METHOD SIGNATURE ENDS

    void insert(int val) {
        root = insertValue(root, val);
    }

    Node insertValue(Node root, int val) {

        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (val < root.val)
            root.left = insertValue(root.left, val);
        else if (val > root.val)
            root.right = insertValue(root.right, val);

        return root;

    }

    Node lowestCommonAncestor(Node root, int node1, int node2)
    {
        if (root == null)
            return root;
        if (root.val == node1 || root.val == node2)
            return root;

        Node left = lowestCommonAncestor(root.left, node1, node2);
        Node right = lowestCommonAncestor(root.right, node1, node2);

        if (left != null && right != null)
            return root;
        if (left != null)
            return lowestCommonAncestor(root.left, node1, node2);
        else
            return lowestCommonAncestor(root.right, node1, node2);
    }


    int findLevel(Node root, int nodeVal, int level)
    {
        if (root == null)
            return -1;
        if (root.val == nodeVal)
            return level;
        int left = findLevel(root.left, nodeVal, level + 1);
        if (left == -1)
            return findLevel(root.right, nodeVal, level + 1);
        return left;
    }

    int findDistance(Node root, int node1, int node2)
    {
        Node lca = lowestCommonAncestor(root, node1, node2);

        int d1 = findLevel(lca, node1, 0);
        int d2 = findLevel(lca, node2, 0);

        return d1 + d2;
    }

}

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

}

