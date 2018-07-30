package sort.stack;

import java.util.Stack;

import static sort.Util.print;

public class SortUsingStack {

    public static void sort(int arr[]) {
        Stack<Integer> sortedStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if(sortedStack.isEmpty()) {
                sortedStack.push(num);
            } else {
                Integer topPeek = sortedStack.peek();
                if(topPeek >= num) {
                    sortedStack.push(num);
                } else {
                    Integer topPop = sortedStack.pop();
                    tempStack.push(topPop);
                    while (!tempStack.isEmpty()) {
                        topPeek = sortedStack.peek();
                        if(topPeek >= num) {
                            sortedStack.push(num);
                            while (!tempStack.isEmpty()) {
                                sortedStack.push(tempStack.pop());
                            }
                        } else {
                            tempStack.push(sortedStack.pop());
                        }
                    }
                }
            }

            sortedStack.forEach(System.out::println);
        }
    }
    public static void main(String[] args) {
        int[] arr = {6, 2, 8, 5, 3, 9, 4, 1, 7, 0};

        System.out.println("*BEFORE SORT**");
        print(arr);
        System.out.println("***********");
        sort(arr);

        System.out.println("*AFTER SORT**");
        print(arr);
        System.out.println("***********");
    }
}
