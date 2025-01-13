package com.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Implementation of an LFU (Least Frequently Used) cache.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class LFUCache<K, V> implements Cache<K, V> {
    private final int capacity;
    private final Map<K, V> values;
    private final Map<K, Integer> frequencies;
    private final TreeMap<Integer, Map<K, Boolean>> frequencyGroups;
    private int hitCount;
    private int missCount;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.values = new HashMap<>();
        this.frequencies = new HashMap<>();
        this.frequencyGroups = new TreeMap<>();
        this.hitCount = 0;
        this.missCount = 0;
    }

    @Override
    public V get(K key) {
        if (!values.containsKey(key)) {
            missCount++;
            return null;
        }
        hitCount++;
        incrementFrequency(key);
        return values.get(key);
    }

    @Override
    public void put(K key, V value) {
        if (capacity == 0) {
            return;
        }
        if (values.containsKey(key)) {
            values.put(key, value);
            incrementFrequency(key);
            return;
        }
        if (values.size() >= capacity) {
            evictLFU();
        }
        values.put(key, value);
        frequencies.put(key, 1);
        frequencyGroups.computeIfAbsent(1, k -> new HashMap<>()).put(key, true);
    }

    private void incrementFrequency(K key) {
        int currentFrequency = frequencies.get(key);
        frequencies.put(key, currentFrequency + 1);

        frequencyGroups.get(currentFrequency).remove(key);
        if (frequencyGroups.get(currentFrequency).isEmpty()) {
            frequencyGroups.remove(currentFrequency);
        }

        frequencyGroups.computeIfAbsent(currentFrequency + 1, k -> new HashMap<>()).put(key, true);
    }

    private void evictLFU() {
        Map.Entry<Integer, Map<K, Boolean>> leastFrequentGroup = frequencyGroups.firstEntry();
        K keyToEvict = leastFrequentGroup.getValue().keySet().iterator().next();
        leastFrequentGroup.getValue().remove(keyToEvict);
        if (leastFrequentGroup.getValue().isEmpty()) {
            frequencyGroups.remove(leastFrequentGroup.getKey());
        }
        values.remove(keyToEvict);
        frequencies.remove(keyToEvict);
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

