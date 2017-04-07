package datastructure.linear;

import java.util.Stack;

/**
 *  Sort a stack using Java API and and Comparator & Using another stack
 * Created by Bikash on 4/7/2017.
 */
public class SortedStack {


    private void sortByAPI(Stack<Integer> stack) {
        System.out.println(stack);

        stack.sort((x, y) -> ((x > y) ? -1 : ((x == y) ? 1 : 0)));

        System.out.println(stack);
    }

    private Stack<Integer> sort(Stack<Integer> stack) {
        if(stack == null || stack.isEmpty()) {
            return stack;
        }

        System.out.println(stack);

        Stack<Integer> newStack = new Stack<>();

        newStack.push(stack.pop());

        while(!stack.isEmpty()) {
            int temp = stack.pop();
            while (!newStack.isEmpty() && temp > newStack.peek()) {
                stack.push(newStack.pop());
            }
            newStack.push(temp);
        }
        return newStack;
    }

    public static void main(String[] args) {
        SortedStack sortedStack = new SortedStack();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(4);
        stack.push(3);
        stack.push(1);
        stack.push(5);

        sortedStack.sortByAPI(stack);
    }
}
