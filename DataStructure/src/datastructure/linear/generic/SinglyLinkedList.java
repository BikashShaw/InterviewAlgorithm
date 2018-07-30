package datastructure.linear.generic;

import java.util.Arrays;


public class SinglyLinkedList<E> {

    private class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    Node<E> head;

    int size;


    SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    void add(E value) {
        Node<E> node = head;
        if (node == null) {
            node = new Node<>(value);
            head = node;
        } else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(value);
        }
        this.size++;
    }

    void addAll(E... values) {
        Arrays.stream(values).forEachOrdered(this::add);
    }

    void addFirst(E value) {
        Node<E> node = new Node<>(value);
        node.next = head;
        head = node;
        this.size++;
    }

    void reverse() {
        Node<E> current = head;
        Node<E> prev = null;

        while (current != null) {
            Node<E> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    int size() {
        return this.size;
    }

    @Override
    public String toString() {
        Node<E> node = head;
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (node != null) {
            builder.append(node.value);
            if (node.next != null) {
                builder.append(" , ");
            }

            node = node.next;
        }

        builder.append("]");

        return builder.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.addAll(5, 6, 7);
        list.addFirst(0);

        System.out.println(list);

        list.reverse();

        System.out.println(list);

        System.out.println("List size: " + list.size());
    }
}
