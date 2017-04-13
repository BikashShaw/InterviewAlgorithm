package datastructure.linear;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by uc0010 on 4/13/2017.
 */
public class LRUCache {
    private Map<String, Node> cache;
    private Node head;
    private Node tail;

    private int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;

    }

    public Node get(String key) {
        return cache.get(key);
    }

    public Node put(String key, int value) {
        Node node = null;
        if(cache.isEmpty()) {
            node = new Node(value);
            node.back = null;
            node.next = null;
            this.head = node;
            this.tail = node;
            cache.put(key, node);
        } else if(cache.containsKey(key)) {
            node = cache.get(key);
            Node back = node.back;
            Node next = node.next;
            back.next = next;
            next.back = back;
            node.next = head;
            head.back = null;
        } else if(cache.size() <= capacity) {
                node = new Node(value);
                node.back = null;
                node.next = this.head;
                this.head = node;
                cache.put(key, node);
        }


        return node;
    }

    private Set<String> keySet() {
        return cache.keySet();


    }

    private void printValues() {
        Node temp = this.head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void printAll() {
        for (String key : cache.keySet()) {
            System.out.print(key + " : " + cache.get(key) + "; ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
        lruCache.put("A", 1);
        lruCache.put("B", 2);
        lruCache.put("A", 2);
        lruCache.printAll();
        lruCache.printValues();
    }


}
