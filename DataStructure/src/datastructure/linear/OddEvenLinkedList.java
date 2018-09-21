package datastructure.linear;

/**
 * Description: https://leetcode.com/problems/odd-even-linked-list/description/
 */
public class OddEvenLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //TODO
    public ListNode oddEvenList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode next = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        //[1,2,3,4,5]
        ListNode head = new ListNode(1);
        add(head, 2,3,4,5);

        System.out.println(head);

    }

    private static void add(ListNode head, int ... values) {
        ListNode node = head;

        for (int value : values) {
            node.next = new ListNode(value);
            node = node.next;
        }
    }
}
