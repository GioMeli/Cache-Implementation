package com.cache;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CacheTest {

    @Test
    public void testCacheInterface() {
        Cache<String, Integer> cache = new LRUCache<>(3);

        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3);

        assertEquals(1, cache.get("a"));
        assertEquals(2, cache.get("b"));
        assertNull(cache.get("d")); // Non-existent key should return null
    }
}
