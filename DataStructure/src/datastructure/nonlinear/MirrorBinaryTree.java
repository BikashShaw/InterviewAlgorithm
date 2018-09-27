package datastructure.nonlinear;

/**
 * Created by Bikash on 4/1/2017.
 */
public class MirrorBinaryTree {

    public boolean isMirror(BinaryTreeNode rootNode) {
        if(rootNode != null) {
            return isMirror(rootNode.leftChild, rootNode.rightChild);
        }

        return false;
    }

    private boolean isMirror(BinaryTreeNode nodeA, BinaryTreeNode nodeB) {

        if(nodeA == null && nodeB == null) {
            return true;
        }
        if(nodeA==null || nodeB==null) {
            return false;
        }
        return nodeA.data == nodeB.data && isMirror(nodeA.leftChild, nodeB.rightChild) && isMirror(nodeA.rightChild, nodeB.leftChild);

    }

    public static void main(String[] args) {
        MinimumBinaryTree minimumBinaryTree = new MinimumBinaryTree();
        BinaryTree mirrorBTree = minimumBinaryTree.createMinimumHeightBinaryTree(new int[]{30,30,50, 60, 50,30,30});
        System.out.println("**Mirror Binary Tree InOrder Traverse**");
        mirrorBTree.inOrderTraverse(mirrorBTree.root);

        MirrorBinaryTree mirrorBinaryTree = new MirrorBinaryTree();

        System.out.println("Is mirror: " + mirrorBinaryTree.isMirror(mirrorBTree.root));

        BinaryTree nonMirrorBTree = minimumBinaryTree.createMinimumHeightBinaryTree(new int[]{31,30,50, 60, 50,30,30});
        System.out.println("**Non-Mirror Binary Tree InOrder Traverse**");
        mirrorBTree.inOrderTraverse(nonMirrorBTree.root);
        System.out.println("Is mirror: " + mirrorBinaryTree.isMirror(nonMirrorBTree.root));
    }
}
