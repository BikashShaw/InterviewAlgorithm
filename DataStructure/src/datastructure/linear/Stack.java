package datastructure.linear;

/**
 * Created by Bikash on 3/11/2017.
 * Simple Stack implementation
 */
public class Stack {
    Node top;
    Node max;
    Node min;
    int size = 0;

    public void push(int element){
        System.out.println("Pushing: " + element);

        Node t = new Node(element);
        t.next = top;
        top = t;
        if(max == null || max.data < top.data) {
            top.oldMax = max;
            max = top;
        }
        if(min == null || min.data > top.data) {
            top.oldMin = min;
            min = top;
        }
        size++;
    }

    public Node pop() {

        if (top != null){
            System.out.println("Poping: " + top.data);
            Node t = top;
            if(top !=null && top.oldMax != null){
                max = top.oldMax;
            }
            if(top !=null && top.oldMin !=null) {
                min = top.oldMin;
            }
            top = top.next;
            size--;

            return t;
        }
        System.out.println("Empty Stack!");
        max = null;
        min = null;
        return null;
    }

    public  Node maximum() {
        return max;
    }

    public  Node minimum() {
        return min;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(5);
        System.out.println("Size: " + stack.size());
        System.out.println("Max: " + stack.maximum().data);
        System.out.println("Min: " + stack.minimum().data);
        stack.push(7);
        System.out.println("Size: " + stack.size());
        System.out.println("Max: " + stack.maximum().data);
        System.out.println("Min: " + stack.minimum().data);
        stack.push(9);
        System.out.println("Size: " + stack.size());
        System.out.println("Max: " + stack.maximum().data);
        System.out.println("Min: " + stack.minimum().data);
        stack.push(3);
        System.out.println("Size: " + stack.size());
        System.out.println("Max: " + stack.maximum().data);
        System.out.println("Min: " + stack.minimum().data);
        stack.push(11);
        System.out.println("Size: " + stack.size());
        System.out.println("Max: " + stack.maximum().data);
        System.out.println("Min: " + stack.minimum().data);



        System.out.println(stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Max: " + stack.maximum().data);
        System.out.println("Min: " + stack.minimum().data);
        System.out.println(stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Max: " + stack.maximum().data);
        System.out.println("Min: " + stack.minimum().data);
        System.out.println(stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Max: " + stack.maximum().data);
        System.out.println("Min: " + stack.minimum().data);
        System.out.println(stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Max: " + stack.maximum().data);
        System.out.println("Min: " + stack.minimum().data);
        System.out.println(stack.pop());
        System.out.println("Size: " + stack.size());

    }
}
