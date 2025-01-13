package com.cache;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LRUCacheTest {

    @Test
    public void testLRUCacheBasic() {
        Cache<String, Integer> cache = new LRUCache<>(2);

        cache.put("a", 1);
        cache.put("b", 2);
        assertEquals(1, cache.get("a")); // "a" is accessed, "b" should be least recently used
        cache.put("c", 3); // "b" should be evicted
        assertNull(cache.get("b"));
        assertEquals(1, cache.get("a"));
        assertEquals(3, cache.get("c"));
    }

    @Test
    public void testLRUCacheCapacityZero() {
        Cache<String, Integer> cache = new LRUCache<>(0);

        cache.put("a", 1);
        assertNull(cache.get("a")); // Nothing should be stored since capacity is 0
    }

    @Test
    public void testLRUCacheHitMissCounts() {
        LRUCache<String, Integer> cache = new LRUCache<>(2);

        cache.put("a", 1);
        cache.put("b", 2);

        cache.get("a"); // Hit
        cache.get("c"); // Miss
        cache.get("b"); // Hit

        assertEquals(2, cache.getHitCount());
        assertEquals(1, cache.getMissCount());
    }
}
