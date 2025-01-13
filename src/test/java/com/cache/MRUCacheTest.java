package com.cache;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MRUCacheTest {

    @Test
    public void testMRUCacheBasic() {
        Cache<String, Integer> cache = new MRUCache<>(2);

        cache.put("a", 1);
        cache.put("b", 2);
        cache.get("a"); // "a" becomes most recently used
        cache.put("c", 3); // "a" is evicted (most recently used)

        assertEquals(3, cache.get("c"));
        assertNull(cache.get("a"));
        assertEquals(2, cache.get("b"));
    }

    @Test
    public void testMRUCacheEdgeCase() {
        Cache<String, Integer> cache = new MRUCache<>(1);

        cache.put("a", 1);
        cache.put("b", 2); // "a" is evicted due to capacity 1

        assertNull(cache.get("a"));
        assertEquals(2, cache.get("b"));
    }

    @Test
    public void testMRUCacheHitMissCounts() {
        MRUCache<String, Integer> cache = new MRUCache<>(2);

        cache.put("a", 1);
        cache.put("b", 2);

        cache.get("a"); // Hit
        cache.get("c"); // Miss
        cache.get("b"); // Hit

        assertEquals(2, cache.getHitCount());
        assertEquals(1, cache.getMissCount());
    }
}
