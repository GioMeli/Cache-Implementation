package com.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of an LRU (Least Recently Used) cache.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class LRUCache<K, V> implements Cache<K, V> {
    private final int capacity;
    private final Map<K, DoublyLinkedListNode<K, V>> map;
    private final DoublyLinkedList<K, V> list;
    private int hitCount;
    private int missCount;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new DoublyLinkedList<>();
        this.hitCount = 0;
        this.missCount = 0;
    }

    @Override
    public V get(K key) {
        if (!map.containsKey(key)) {
            missCount++;
            return null;
        }
        DoublyLinkedListNode<K, V> node = map.get(key);
        list.moveToHead(node);
        hitCount++;
        return node.value;
    }

    @Override
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            DoublyLinkedListNode<K, V> node = map.get(key);
            node.value = value;
            list.moveToHead(node);
        } else {
            if (map.size() >= capacity) {
                DoublyLinkedListNode<K, V> tail = list.removeTail();
                if (tail != null) {
                    map.remove(tail.key);
                }
            }
            DoublyLinkedListNode<K, V> newNode = new DoublyLinkedListNode<>(key, value);
            map.put(key, newNode);
            list.addToHead(newNode);
        }
    }

    @Override
    public int getHitCount() {
        return hitCount;
    }

    @Override
    public int getMissCount() {
        return missCount;
    }
}

