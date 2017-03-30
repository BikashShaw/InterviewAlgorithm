package datastructure.nonlinear;

/**
 * Created by Bikash on 3/30/2017.
 *  <ol>
 *     <li>
 *         Every node is either red or black.
 *     </li>
 *     <li>
 *         Every leaf (NIL) is black.
 *     </li>
 *     <li>
 *         If a node is red, then both its children are black.
 *     </li>
 *     <li>
 *         Every simple path from a node to a descendant leaf contains the same number of black nodes.
 *     </li>
 * </ol>
 */
public class RedBlackTree {

    private RedBlackNode root;
    private static RedBlackNode nilNode;

    /* Static initializer for nilNode */
    {
        nilNode = new RedBlackNode(-1);
        nilNode.color = RedBlackColor.BLACK;
        nilNode.leftChild = nilNode;
        nilNode.rightChild = nilNode;
    }

    private RedBlackTree(int data) {
        root = new RedBlackNode(data, nilNode, nilNode, 1);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmtry() {
        this.root = null;
    }

    public RedBlackNode insert(int data) {

        return  insert(this.root, data);
    }

    public RedBlackNode insert(RedBlackNode node, int data) {
        if (node == null) {
            node = new RedBlackNode(data);
            return node;
        }

        return node;
    }

    public void inOrderTraverse(RedBlackNode rootNode) {
        if (rootNode == null) {
            return;
        }
        inOrderTraverse(rootNode.leftChild);
        System.out.println(rootNode.data);
        inOrderTraverse(rootNode.rightChild);
    }

}
