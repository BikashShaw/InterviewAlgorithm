package datastructure.linear;

/**
 * Random Pointer Linked List
 * Created by Bikash on 3/19/2017.
 */

class RandNote {
    String data;
    RandNote next;
    RandNote random;

    public  RandNote(String data) {
        this.data = data;
    }

}

public class RandomLinkedList {
    public static RandNote clone(RandNote oldHead) {
        RandNote temp = oldHead;
        RandNote newHead = null;
        int counter = 1;
        //Create new nodes
        while (temp != null) {
            RandNote rn = new RandNote(temp.data + counter);
            rn.next = temp.next;
            temp.next = rn;
            temp = rn.next;
            counter++;
        }
        temp = oldHead;
        RandNote newTemp = temp.next;
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

    public static void main(String[] args) {
        RandNote oldHead = null;
        RandNote r1 = new RandNote("A");
        RandNote r2 = new RandNote("B");
        RandNote r3 = new RandNote("C");
        RandNote r4 = new RandNote("D");
        r1.next = r2;
        r1.random = r3;

        r2.next = r3;
        r2.random = r4;
        r3.next = r4;
        r3.random = r2;
        r4.next = null;
        r4.random = r1;

        oldHead = r1;
        RandNote newHead = clone(r1);

        RandNote tmp = oldHead;
        System.out.println("Old Values");
        while (tmp != null) {
            System.out.println(tmp.data + " random-> " + tmp.random.data);
            tmp = tmp.next;
        }

        tmp = newHead;
        System.out.println("New Values");
        while (tmp != null) {
            System.out.println(tmp.data + " random-> " + tmp.random.data);
            tmp = tmp.next;
        }
    }

}