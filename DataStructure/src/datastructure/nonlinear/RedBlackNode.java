package datastructure.nonlinear;

/**
 * Created by Bikash on 3/30/2017.
 *
 */
public class RedBlackNode {

    int data;
    RedBlackNode leftChild, rightChild;
    RedBlackColor color;
    int size; //subtree count

    public RedBlackNode(int data) {
        this(data, null, null, 1);
    }

    public RedBlackNode(int data, RedBlackNode leftChild, RedBlackNode rightChild, int size) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.color = RedBlackColor.RED;
        this.size = size;
    }

    public RedBlackNode(int data, int size) {
        this(data, null, null, size);
    }

    public boolean isRed() {
        return color == RedBlackColor.RED;
    }

    public int getSize() {
        return size;
    }
}
