package datastructure.linear.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoublyLinkedList<E> {

    private class Node<T> {
        T value;
        Node<T> next;
        Node<T> back;


        Node(T value) {
            this.value = value;
            this.next = null;
            this.back = null;
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

    public void addAll(E ... values) {
        Arrays.stream(values).forEach(this::add);
    }

    public void remove(E value) {

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
            if(node.next != null) {
                builder.append(", ");
            }
            node = node.next;
        }


        builder.append("]");

        return builder.toString();

    }


    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>(1);
        System.out.println(doublyLinkedList);

        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        System.out.println(doublyLinkedList);

        doublyLinkedList.addAll(4, 5, 6, 7);
        System.out.println(doublyLinkedList);

        System.out.println("List size: " + doublyLinkedList.getSize());

    }
}
