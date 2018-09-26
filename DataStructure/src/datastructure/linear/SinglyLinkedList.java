package datastructure.linear;

/**
 * Created by Bikash on 3/11/2017.
 */
public class SinglyLinkedList {
    Node head;

    //Time Complexity: O(1)
    public void insertFirst(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = new Node(data);
            temp.next = head;
            head = temp;
        }
    }

    //Time Complexity: O(n)
    public void insertLast(int data) {
        Node temp = new Node(data);
        if (head == null) {
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

        while (tempHead != null) {
            if (tempHead.data == element) {
                found = true;
                break;
            }
            tempHead = tempHead.next;
        }

        return found;
    }

    //Time Complexity: O(n)
    public void traverse() {
        if (head == null) {
            System.out.println("Empty List!");
            return;
        }
        Node temp = head;
        System.out.println("**Start**");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;

        } while (temp != null);
        System.out.println("\n**End**");
    }

    public void traverseReverse(Node node) {
        if (node == null) {
            return;
        }
        traverseReverse(node.next);
        System.out.print(node.data + " ");
    }

    public Node reverse(Node node) {
        if (node == null) { // No Node
            return null;
        }

        if (node.next == null) { //Only 1 node
            return node;
        }

        Node next = node.next;

        node.next = null;

        Node reverseNode = reverse(next);

        next.next = node;

        return reverseNode;
    }

    public void reverse() {
        Node current = this.head;
        Node previous = null;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        this.head = previous;
    }


    public Node delete(Node head, int target) {
        if(head == null ) {
            return null;
        }
        Node current = head , pre = null;

        while(current != null && current.data != target) {
            pre = current;
            current = current.next;
        }

        if (pre == null) { // head
            head = head.next;
        } else if(current != null) { // found
            pre.next = current.next;
        }

        return head;
    }

    /**
     * Delete Node in a Linked List
     * <strong>URL: https://leetcode.com/problems/delete-node-in-a-linked-list/#/description</strong>
     *
     * @param node
     */
    public void deleteNode(Node node) {
        if (node == null) {
            return;
        }
        Node pre = node;
        while (node.next != null) {
            pre = node;
            node.data = node.next.data;
            node = node.next;
        }
        pre.next = null;
    }


    /**
     * Remove Duplicates from Sorted List <br />
     * <strong>URL: </strong>https://leetcode.com/problems/remove-duplicates-from-sorted-list/#/description
     *
     * @param head - Head of the list
     * @return
     */
    public Node deleteDuplicatesFromSortedList(Node head) {
        Node mover = head;
        if (mover == null) {
            return head;
        }
        while (mover.next != null) {
            if (mover.data == mover.next.data) {
                mover.next = mover.next.next;
            } else {
                mover = mover.next;
            }
        }

        return head;
    }

    public boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //Geeks4Geeks
    public void swap(Node x, Node y) {

        // Nothing to do if x and y are same
        if (x.data == y.data) {
            return;
        }

        Node prevX = null;
        Node currX = head;
        // Search for x (keep track of prevX and currX)
        while (currX != null && currX.data != x.data) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null;
        Node currY = head;
        // Search for y (keep track of prevY and currY)
        while (currY != null && currY.data != y.data) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present, nothing to do
        if (currX == null || currY == null) {
            return;
        }

        /* Swap Previous Pointers */
        // If x is not head of linked list
        if (prevX != null) {
            prevX.next = currY;
        } else { //if x is head
            head = currY;
        }

        // If y is not head of linked list
        if (prevY != null) {
            prevY.next = currX;
        } else { // if y is head
            head = currX;
        }

        /* Swap next pointers */
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
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
        System.out.println("**Traverse in Revere**");
        linkedList.traverseReverse(linkedList.head);
        System.out.println();
        System.out.println("Found 7 in list: " + linkedList.find(7));
        System.out.println("Found 12 in list: " + linkedList.find(12));

        System.out.println("**Recursive Reverse**");
        linkedList.head = linkedList.reverse(linkedList.head);
        linkedList.traverse();
        System.out.println("**Iterative Reverse**");
        linkedList.reverse();
        linkedList.traverse();
        System.out.println("**Deleting 3**");
        linkedList.head = linkedList.delete(linkedList.head, 3);
        linkedList.traverse();

        //15 and 7
        linkedList.swap(linkedList.head, linkedList.head.next.next);
        linkedList.traverse();

        //15 and 5
        linkedList.swap(linkedList.head.next.next, linkedList.head.next.next.next);
        linkedList.traverse();
    }
}
