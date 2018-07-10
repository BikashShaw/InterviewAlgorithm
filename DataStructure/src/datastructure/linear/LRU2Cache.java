package datastructure.linear;

import java.util.HashMap;
import java.util.Map;

class LRU2Node<K, V> {
    K key;
    V value;
    LRU2Node<K, V> next = null;
    LRU2Node<K, V> prev = null;

    LRU2Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "LRU2Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

public class LRU2Cache<K, V> {

    private final Integer maxSize;

    private LRU2Node<K, V> head;
    private LRU2Node<K, V> tail;

    private Map<K, LRU2Node<K, V>> lru2Map;

    private LRU2Cache(Integer maxSize) {
        this.maxSize = maxSize;
        lru2Map = new HashMap<>(this.maxSize);
    }

    private LRU2Node<K, V> get(K key) {
        return lru2Map.get(key);
    }

    private LRU2Node<K, V> put(K key, V value) {
        LRU2Node<K, V> node;
        if (lru2Map.isEmpty()) {
            node = new LRU2Node<>(key, value);
            lru2Map.put(key, node);
            head = node;
            tail = node;
        } else if (lru2Map.size() == 1) {
            node = this.get(key);
            if (node == null) {
                node = new LRU2Node<>(key, value);
                lru2Map.put(key, node);
                node.next = tail;
                tail.prev = node;
                head = node;
            } else {
                node.value = value;
                lru2Map.replace(key, node);
            }
        } else if (lru2Map.size() < maxSize) {
            node = this.get(key);
            if (node == null) {
                node = new LRU2Node<>(key, value);
                lru2Map.put(key, node);
                node.next = head;
                head.prev = node;
                head = node;
            } else {
                node = updateExistingNode(key, value, node);
            }

        } else {
            node = this.get(key);
            if (node == null) {
                System.out.println(String.format("Evicting... %s", tail));
                lru2Map.remove(tail.key);
                tail = tail.prev;
                tail.next = null;
                node = new LRU2Node<>(key, value);
                node.next = head;
                head.prev = node;
                head = node;
                lru2Map.put(key, node);
            } else {
                node = updateExistingNode(key, value, node);
            }
        }
        return node;
    }

    private LRU2Node<K, V> updateExistingNode(K key, V value, LRU2Node<K, V> node) {
        if (head.key.equals(key)) {
            node = updateHead(key, value);
        } else if (tail.key.equals(key)) {
            node = updateTailMovedToHead(key, value);
        } else {
            node = updateNodeMovedToHead(key, value, node);
        }
        return node;
    }

    private LRU2Node<K, V> updateNodeMovedToHead(K key, V value, LRU2Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
        node.value = value;
        lru2Map.replace(key, node);
        return node;
    }

    private LRU2Node<K, V> updateTailMovedToHead(K key, V value) {
        LRU2Node<K, V> node = tail;
        tail = tail.prev;
        tail.next = null;
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
        node.value = value;
        lru2Map.replace(key, node);
        return node;
    }

    private LRU2Node<K, V> updateHead(K key, V value) {
        LRU2Node<K, V> node = head;
        node.value = value;
        lru2Map.replace(key, node);
        return node;
    }


    public static void main(String[] args) {
        LRU2Cache<String, Integer> lru2Cache = new LRU2Cache<>(5);
        System.out.println(lru2Cache);
        lru2Cache.put("A", 1);
        System.out.println(lru2Cache);
        lru2Cache.put("A", 2);
        System.out.println(lru2Cache);
        lru2Cache.put("B", 1);
        System.out.println(lru2Cache);

        lru2Cache.put("A", 1);
        System.out.println(lru2Cache);
        lru2Cache.put("B", 2);
        System.out.println(lru2Cache);
        lru2Cache.put("C", 3);
        System.out.println(lru2Cache);

        lru2Cache.put("C", 4);
        System.out.println(lru2Cache);
        lru2Cache.put("C", 3);
        System.out.println(lru2Cache);

        lru2Cache.put("D", 4);
        System.out.println(lru2Cache);

        lru2Cache.put("B", 5);
        System.out.println(lru2Cache);

        lru2Cache.put("E", 6);
        System.out.println(lru2Cache);

        lru2Cache.put("D", 7);
        System.out.println(lru2Cache);

        lru2Cache.put("F", 8);
        System.out.println(lru2Cache);

        lru2Cache.put("D", 9);
        System.out.println(lru2Cache);

        lru2Cache.put("G", 10);
        System.out.println(lru2Cache);
    }

    private void print() {
        LRU2Node<K, V> node = head;
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }

    @Override
    public String toString() {
        print();
        return "LRU2Cache{" +
                "maxSize=" + maxSize +
                ", currentSize=" + lru2Map.size() +
                ", head=" + head +
                ", tail=" + tail +
                ", lru2Map=" + lru2Map +
                '}';
    }
}
