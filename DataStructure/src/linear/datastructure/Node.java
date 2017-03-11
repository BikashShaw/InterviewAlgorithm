package linear.datastructure;

/**
 * Created by Bikash on 3/11/2017.
 */
public class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data: " + this.data;
    }
}
