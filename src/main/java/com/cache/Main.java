package com.cache;

public class Main {
    public static void main(String[] args) {
        Cache<Integer, String> lruCache = new LRUCache<>(3);
        lruCache.put(1, "One");
        lruCache.put(2, "Two");
        lruCache.put(3, "Three");
        System.out.println(lruCache.get(1)); // Output: One
        lruCache.put(4, "Four"); // Evicts key 2
        System.out.println(lruCache.get(2)); // Output: null
    }
}

