package datastructure.linear;

/**
 * Random Pointer Linked List
 * Created by Bikash on 3/19/2017.
 */

class RandomListNode {
    String label;
    RandomListNode next;
    RandomListNode random;

    public RandomListNode(String data) {
        this.label = data;
    }

}

public class RandomLinkedList {
    public static RandomListNode clone(RandomListNode oldHead) {
        RandomListNode temp = oldHead;
        RandomListNode newHead = null;
        int counter = 1;
        //Create new nodes - Single List
        while (temp != null) {
            RandomListNode rn = new RandomListNode(temp.label + counter);
            rn.next = temp.next;
            temp.next = rn;
            temp = rn.next;
            counter++;
        }
        temp = oldHead;
        print(temp);
        temp = oldHead;
        RandomListNode newTemp = temp.next;
        //Assign random pointers
        while (temp != null) {
            newTemp.random = temp.random.next;
            if(temp.next != null && newTemp.next != null) {
                temp = temp.next.next;
                newTemp = newTemp.next.next;
            } else  {
                temp = null;
                newTemp = null;
            }
        }

        newHead = oldHead.next;
        temp = oldHead;
        newTemp = newHead;
        //Separate into two list
        while (temp != null) {
            temp.next = temp.next.next;
            newTemp.next = newTemp.next !=null ? newTemp.next.next : null;

            temp = temp.next;
            newTemp = newTemp.next;
        }

        return newHead;
    }

    private static void print(RandomListNode temp) {
        while (temp!= null) {
            System.out.print(temp.label + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        RandomListNode oldHead = null;
        RandomListNode r1 = new RandomListNode("A");
        RandomListNode r2 = new RandomListNode("B");
        RandomListNode r3 = new RandomListNode("C");
        RandomListNode r4 = new RandomListNode("D");
        r1.next = r2;
        r1.random = r3;

        r2.next = r3;
        r2.random = r4;
        r3.next = r4;
        r3.random = r2;
        r4.next = null;
        r4.random = r1;

        oldHead = r1;
        RandomListNode newHead = clone(r1);

        RandomListNode tmp = oldHead;
        System.out.println("Old Values");
        while (tmp != null) {
            System.out.println(tmp.label + " random-> " + tmp.random.label);
            tmp = tmp.next;
        }

        tmp = newHead;
        System.out.println("New Values");
        while (tmp != null) {
            System.out.println(tmp.label + " random-> " + tmp.random.label);
            tmp = tmp.next;
        }
    }

}