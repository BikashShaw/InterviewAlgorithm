package linear.datastructure;

/**
 * Created by Bikash on 3/11/2017.
 */
public class Node {
    Node next;
    Node back; //Please Note: Not need for Singly Linked Lint, Stack and Queue
    int data;

    Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data: " + this.data;
    }
}
