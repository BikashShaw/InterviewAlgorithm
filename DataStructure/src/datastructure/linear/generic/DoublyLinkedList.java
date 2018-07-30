package datastructure.linear.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoublyLinkedList<E> {

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> back;


        Node(T value) {
            this.value = value;
            this.next = null;
            this.back = null;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private Integer size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public DoublyLinkedList(E value) {
        head = tail = new Node<>(value);
        size = 1;
    }

    public List<E> values() {
        Node<E> node = head;
        List<E> values = new ArrayList<>();

        while (node != null) {
            values.add(node.value);
            node = node.next;
        }
        return values;
    }

    public void add(E value) {
        if (head == null) {
            head = tail = new Node<>(value);
        } else {
            Node<E> node = new Node<>(value);
            node.back = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void addAll(E... values) {
        Arrays.stream(values).forEach(this::add);
    }

    /**
     * Base 0 (zero)
     *
     * @param index
     */
    public Node<E> remove(int index) {
        if (index < 0 && index >= this.size) {
            throw new IllegalArgumentException("Index is outside range");
        }

        Node<E> removed = null;
        if (index == 0) {
            removed = head;

            head = head.next;
            head.back = null;
        } else if (index == size - 1) {
            removed = tail;
            tail = tail.back;
            tail.next = null;
        } else {
            int i = 0;
            Node<E> node = head;
            while (i <= index) {
                removed = node;
                node = node.next;
                i++;
            }

            removed.back.next = removed.next;
            removed.next.back = removed.back;

        }
        if(removed!=null){
            this.size--;
        }
        return removed;
    }

    /**
     * Base 0 (zero)
     *
     * @param index
     */
    public Node<E> insert(E value, int index) {
        if (index < 0 && index >= this.size) {
            throw new IllegalArgumentException("Index is outside range");
        }
        Node<E> inserted = new Node<>(value);

        if (index == 0) {
            inserted.next = head;
            head.back = inserted;
            head = inserted;
        } else if (index == size - 1) {
            inserted.back = tail;
            tail.next = inserted;
            tail = inserted;
        } else {
            Node<E> node = head;
            int i = 0;
            while (i < index) {
                node = node.next;
                i++;
            }
            inserted.next = node;
            node.back.next = inserted;
            inserted.back = node.back;
            node.back = inserted;
        }

        this.size++;
        return inserted;
    }

    public void swap(int index1, int index2) {
        Node<E> removedIndex1Node = this.remove(index1);
        this.insert(removedIndex1Node.value, index2);

        Node<E> removeIndex2Node = this.remove(index2 - 1);
        this.insert(removeIndex2Node.value, index1);

    }


    public Integer getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("[");

        Node<E> node = head;

        while (node != null) {
            builder.append(node.value);
            if (node.next != null) {
                builder.append(", ");
            }
            node = node.next;
        }


        builder.append("]");

        return builder.toString();

    }


    public static void main(String[] args) {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>("A");
        System.out.println(doublyLinkedList);

        doublyLinkedList.add("B");
        doublyLinkedList.add("C");
        System.out.println(doublyLinkedList);

        doublyLinkedList.addAll("D", "E", "F", "G");
        System.out.println(doublyLinkedList);

        System.out.println("List size: " + doublyLinkedList.getSize());

        Node<String> removedNode = doublyLinkedList.remove(3);

        System.out.println("Removed: " + removedNode);

        System.out.println(doublyLinkedList);

        System.out.println("List size: " + doublyLinkedList.getSize());

        Node<String> insertedNode = doublyLinkedList.insert("E", 3);

        System.out.println("Inserted: " + insertedNode);

        System.out.println("List size: " + doublyLinkedList.getSize());

        System.out.println(doublyLinkedList);

        System.out.println("Swap index 1 with 4");

        doublyLinkedList.swap(1, 4);

        System.out.println(doublyLinkedList);

        System.out.println("List size: " + doublyLinkedList.getSize());

    }
}
