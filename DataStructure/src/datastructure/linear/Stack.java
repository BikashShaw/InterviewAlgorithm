package datastructure.linear;

/**
 * Created by Bikash on 3/11/2017.
 * Simple Stack implementation
 */
public class Stack {
    Node top;

    public void push(int element){
        Node t = new Node(element);
        t.next = top;
        top = t;
    }

    public Node pop() {
        if (top != null){
            Node t = top;
            top = top.next;
            return t;
        }
        return null;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(7);
        stack.push(9);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
