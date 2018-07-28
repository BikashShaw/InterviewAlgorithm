package datastructure.linear.generic;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

class LRUNode<K, V> {
    K key;
    V value;
    LRUNode<K, V> next = null;
    LRUNode<K, V> prev = null;

    LRUNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "LRUNode{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

public class LRUCache<K, V> {

    private final Integer maxSize;

    private LRUNode<K, V> head;
    private LRUNode<K, V> tail;

    private Map<K, LRUNode<K, V>> lruMap;

    private LRUCache(Integer maxSize) {
        this.maxSize = maxSize;
        lruMap = new HashMap<>(this.maxSize);
    }

    private LRUNode<K, V> get(K key) {
        return lruMap.get(key);
    }

    private LRUNode<K, V> put(K key, V value) {
        LRUNode<K, V> node;
        if (lruMap.isEmpty()) {
            node = new LRUNode<>(key, value);
            lruMap.put(key, node);
            head = node;
            tail = node;
        } else if (lruMap.size() == 1) {
            node = this.get(key);
            if (node == null) {
                node = new LRUNode<>(key, value);
                lruMap.put(key, node);
                node.next = tail;
                tail.prev = node;
                head = node;
            } else {
                node.value = value;
                lruMap.replace(key, node);
            }
        } else if (lruMap.size() < maxSize) {
            node = this.get(key);
            if (node == null) {
                node = new LRUNode<>(key, value);
                lruMap.put(key, node);
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
                lruMap.remove(tail.key);
                tail = tail.prev;
                tail.next = null;
                node = new LRUNode<>(key, value);
                node.next = head;
                head.prev = node;
                head = node;
                lruMap.put(key, node);
            } else {
                node = updateExistingNode(key, value, node);
            }
        }
        return node;
    }

    private LRUNode<K, V> updateExistingNode(K key, V value, LRUNode<K, V> node) {
        if (head.key.equals(key)) {
            node = updateHead(key, value);
        } else if (tail.key.equals(key)) {
            node = updateTailMovedToHead(key, value);
        } else {
            node = updateNodeMovedToHead(key, value, node);
        }
        return node;
    }

    private LRUNode<K, V> updateNodeMovedToHead(K key, V value, LRUNode<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
        node.value = value;
        lruMap.replace(key, node);
        return node;
    }

    private LRUNode<K, V> updateTailMovedToHead(K key, V value) {
        LRUNode<K, V> node = tail;
        tail = tail.prev;
        tail.next = null;
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
        node.value = value;
        lruMap.replace(key, node);
        return node;
    }

    private LRUNode<K, V> updateHead(K key, V value) {
        LRUNode<K, V> node = head;
        node.value = value;
        lruMap.replace(key, node);
        return node;
    }


    public static void main(String[] args) {
        LRUCache<String, Integer> cacheOne = new LRUCache<>(5);
        System.out.println(cacheOne);
        cacheOne.put("A", 1);
        System.out.println(cacheOne);
        cacheOne.put("A", 2);
        System.out.println(cacheOne);
        cacheOne.put("B", 1);
        System.out.println(cacheOne);

        cacheOne.put("A", 1);
        System.out.println(cacheOne);
        cacheOne.put("B", 2);
        System.out.println(cacheOne);
        cacheOne.put("C", 3);
        System.out.println(cacheOne);

        cacheOne.put("C", 4);
        System.out.println(cacheOne);
        cacheOne.put("C", 3);
        System.out.println(cacheOne);

        cacheOne.put("D", 4);
        System.out.println(cacheOne);

        cacheOne.put("B", 5);
        System.out.println(cacheOne);

        cacheOne.put("E", 6);
        System.out.println(cacheOne);

        cacheOne.put("D", 7);
        System.out.println(cacheOne);

        cacheOne.put("F", 8);
        System.out.println(cacheOne);

        cacheOne.put("D", 9);
        System.out.println(cacheOne);

        cacheOne.put("G", 10);
        System.out.println(cacheOne);

        LRUCache<Long, Double> cacheTwo = new LRUCache<>(7);

        LongStream.range(1L, 100L).forEach(key -> {
            cacheTwo.put(key, Math.random());
            System.out.println(cacheTwo);
        });

    }

    private void print() {
        LRUNode<K, V> node = head;
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }

    @Override
    public String toString() {
        print();
        return "LRUCache{" +
                "maxSize=" + maxSize +
                ", currentSize=" + lruMap.size() +
                ", head=" + head +
                ", tail=" + tail +
                ", lruMap=" + lruMap +
                '}';
    }
}
