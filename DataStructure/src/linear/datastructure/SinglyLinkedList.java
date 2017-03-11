package linear.datastructure;

/**
 * Created by Bikash on 3/11/2017.
 */
public class SinglyLinkedList {
    Node head;

    //Time Complexity: O(1)
    public void insertFirst(int data) {
        if(head == null) {
            head = new Node(data);
        } else {
            Node temp = new Node(data);
            temp.next = head;
            head = temp;
        }
    }
    //Time Complexity: O(n)
    public void insertLast(int data) {
        Node temp  = new Node(data);
        if(head == null) {
            head = temp;
        }
        Node tempHead = head;
        do {
            tempHead = tempHead.next;
        } while (tempHead.next != null);
        tempHead.next = temp;
    }

    //Time Complexity: O(n)
    public boolean find(int element) {
        boolean found = false;

        Node tempHead = head;

        while (tempHead != null){
            if(tempHead.data == element) {
                found = true;
                break;
            }
            tempHead = tempHead.next;
        }

        return found;
    }

    //Time Complexity: O(n)
    public void traverse() {
        if(head == null) {
            System.out.println("Empty List!");
            return;
        }
        Node temp = head;
        System.out.println("**Start**");
        do {
            System.out.println(temp.data);
            temp = temp.next;

        } while (temp != null);
        System.out.println("**End**");
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.traverse();
        linkedList.insertFirst(3);
        linkedList.insertFirst(5);
        linkedList.insertFirst(7);
        linkedList.traverse();
        linkedList.insertFirst(9);
        linkedList.traverse();
        linkedList.insertLast(11);
        linkedList.insertLast(13);
        linkedList.traverse();
        linkedList.insertFirst(15);
        linkedList.traverse();

        System.out.println("Found 7 in list: " + linkedList.find(7));
        System.out.println("Found 12 in list: " + linkedList.find(12));
    }
}
