package linear.datastructure;

/**
 * Created by Bikash on 3/11/2017.
 */
public class DoublyLinkedList {

    Node head;
    private Node tail;
    private int size = 0;

    //Time Complexity: O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    //Time Complexity: O(1)
    public void insertFirst(int data) {
        System.out.println("Insert First: " + data);
        if(head == null) {
            head = new Node(data);
            tail = head;
        } else  {
            Node temp = new Node(data);
            temp.next = head;
            head.back = temp;
            head = temp;
        }
        size++;
    }
    //Time Complexity: O(1)
    public void insertLast(int data) {
        System.out.println("Insert Last: " + data);
        if(head == null) {
            head = new Node(data);
            tail = head;
        } else  {
            Node temp = new Node(data);
            tail.next = temp;
            temp.back = tail;
            tail = temp;
        }
        size++;
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
    //Time Complexity: O(n)
    public void reverseTraverse() {
        if(tail == null) {
            System.out.println("Empty List!");
            return;
        }
        Node temp = tail;
        System.out.println("**Start**");
        do {
            System.out.println(temp.data);
            temp = temp.back;

        } while (temp != null);
        System.out.println("**End**");
    }


    //Time Complexity: O(1)
    public void deleteFirst() {
        System.out.println("Delete First: " + head.data);
        head = head.next;
        head.back = null;

    }

    //Time Complexity: O(1)
    public void deleteLast() {
        System.out.println("Delete Last: " + tail.data);
        tail = tail.back;
        tail.next = null;
    }


    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        performTraverse(linkedList);
        linkedList.insertFirst(3);
        linkedList.insertFirst(5);
        linkedList.insertLast(7);
        performTraverse(linkedList);
        linkedList.insertLast(9);
        linkedList.insertFirst(11);
        linkedList.insertFirst(13);
        performTraverse(linkedList);
        linkedList.deleteFirst();
        linkedList.deleteFirst();
        performTraverse(linkedList);
        linkedList.deleteLast();
        linkedList.deleteLast();
        performTraverse(linkedList);
    }

    private static void performTraverse(DoublyLinkedList linkedList) {
        System.out.println("Is Empty List: " + linkedList.isEmpty());
        System.out.println("Traverse:");
        linkedList.traverse();
        System.out.println("Reverse Traverse:");
        linkedList.reverseTraverse();
    }
}
