package com.cache;

/**
 * Interface for a generic cache.
 * 
 * @param <K> the type of keys used in the cache
 * @param <V> the type of values stored in the cache
 */
public interface Cache<K, V> {
    /**
     * Retrieves a value associated with the given key.
     * 
     * @param key the key
     * @return the value associated with the key, or null if the key does not exist
     */
    V get(K key);

    /**
     * Inserts a key-value pair into the cache.
     * 
     * @param key the key
     * @param value the value
     */
    void put(K key, V value);

    /**
     * Returns the number of cache hits.
     * 
     * @return the number of hits
     */
    int getHitCount();

    /**
     * Returns the number of cache misses.
     * 
     * @return the number of misses
     */
    int getMissCount();
}

