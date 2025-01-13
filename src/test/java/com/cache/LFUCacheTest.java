package com.cache;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LFUCacheTest {

    @Test
    public void testLFUCacheBasic() {
        Cache<String, Integer> cache = new LFUCache<>(2);

        cache.put("a", 1);
        cache.put("b", 2);
        cache.get("a"); // "a" frequency = 2
        cache.put("c", 3); // "b" (least frequently used) should be evicted

        assertNull(cache.get("b"));
        assertEquals(1, cache.get("a"));
        assertEquals(3, cache.get("c"));
    }

    @Test
    public void testLFUCacheTieBreaker() {
        Cache<String, Integer> cache = new LFUCache<>(2);

        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3); // "a" and "b" have same frequency, but "a" is evicted because it is oldest

        assertNull(cache.get("a"));
        assertEquals(2, cache.get("b"));
        assertEquals(3, cache.get("c"));
    }

    @Test
    public void testLFUCacheHitMissCounts() {
        LFUCache<String, Integer> cache = new LFUCache<>(2);

        cache.put("a", 1);
        cache.put("b", 2);

        cache.get("a"); // Hit
        cache.get("c"); // Miss
        cache.get("b"); // Hit

        assertEquals(2, cache.getHitCount());
        assertEquals(1, cache.getMissCount());
    }
}
