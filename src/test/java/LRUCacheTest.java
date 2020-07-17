import important.LRUCache;

public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.size());
        System.out.println(lruCache.toString());
    }
}
