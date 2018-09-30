package sort.linkedlist;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class SortList {

    ListNode head;

    public static void main(String[] args) {
        int[] elements = {4,19,14,5,-3,1,8,5,11,15};

        SortList sortList = new SortList();
        sortList.buildList(elements);

        System.out.println("*BEFORE SORT**");
        sortList.print();
        System.out.println("***********");

        sortList.sortList();

        System.out.println("*AFTER SORT**");
        sortList.print();
        System.out.println("***********");
    }

    private void buildList(int[] elements) {
        head = null;
        ListNode node = null;

        for (int element : elements) {
            if (head == null) {
                head = new ListNode(element);
                node = head;
            } else {
                node.next = new ListNode(element);
                node = node.next;
            }
        }
    }

    public void sortList() {
        ListNode node = head;
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }

        quickSort(1, size);

    }


    public void quickSort(int low, int high) {
        if (low < high) {
            int partition = partition(low, high);
            quickSort( low, partition - 1);
            quickSort( partition + 1, high);
        }
    }

    public int partition(int low, int high) {
        ListNode pivot = nodeAt(high);
        int i = low - 1;
        for (int j = low; j <= high; j++) {
            ListNode jNode = nodeAt(j);
            if (jNode.val < pivot.val) {
                i++;
                swap(nodeAt(i), jNode);
                print();
            }
        }
        i++;
        swap(nodeAt(i), pivot);
        print();
        return i;
    }

    private ListNode nodeAt(int position) {

        ListNode node = head;
        int size = 1;

        while (size++ < position) {
            node = node.next;
        }

        System.out.println("Position # " + position + " value = " + node.val);

        return node;
    }

    private void swap( ListNode x, ListNode y) {
       int temp = x.val;
       x.val = y.val;
       y.val = temp;
    }

    private void print() {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }
}
