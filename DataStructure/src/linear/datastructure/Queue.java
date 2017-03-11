package linear.datastructure;

/**
 * Created by Bikash on 3/11/2017.
 * Implementing a linear.datastructure.Queue
 */
public class Queue {
    Node first, last;

    public void enQueue(int element) {
        if(first == null) {
            last = new Node(element);
            first = last;
        } else {
            last.next = new Node(element);;
            last = last.next;
        }
    }

    public Node deQueue() {
        if(first != null) {
            Node item = first;
            first = first.next;
            return item;
        }
        return null;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(5);
        queue.enQueue(7);
        queue.enQueue(9);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}
