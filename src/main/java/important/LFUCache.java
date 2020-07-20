package important;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {
    public static void main(String[] args) {
//        LFUCache lfuCache = new LFUCache(2);
//        lfuCache.put(1, 1);
//        lfuCache.put(2, 2);
//        System.out.println(lfuCache.get(1));
//        lfuCache.put(3, 3);
//        System.out.println(lfuCache.get(2));
//        System.out.println(lfuCache.get(3));
//        lfuCache.put(4, 4);
//        System.out.println(lfuCache.get(1));
//        System.out.println(lfuCache.get(3));
//        System.out.println(lfuCache.get(4));
        LFUCache lfuCache = new LFUCache(0);
        lfuCache.get(0);
        lfuCache.put(0, 0);
    }

    private int capacity;
    private Map<Integer, Integer> cacheMap;
    private Map<Integer, Integer> numMap;
    private Map<Integer, Integer> timeMap;
    private int time = 0;
    private PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer integer, Integer t1) {
            if (numMap.getOrDefault(integer, 0) == numMap.getOrDefault(t1, 0)) {
                if (timeMap.getOrDefault(integer, 0) == timeMap.getOrDefault(t1, 0)) {
                    return 0;
                }
                return timeMap.getOrDefault(integer, 0) > timeMap.getOrDefault(t1, 0) ? 1 : -1;
            }
            return numMap.getOrDefault(integer, 0) > numMap.getOrDefault(t1, 0) ? 1 : -1;
        }
    });

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.numMap = new HashMap<>();
        this.timeMap = new HashMap<>();
        this.queue.clear();
    }

    public int get(int key) {
        if (cacheMap.get(key) == null) {
            return -1;
        } else {
            int num = numMap.getOrDefault(key, 0);
            numMap.put(key, num + 1);
            timeMap.put(key, ++time);
            queue.remove(key);
            queue.add(key);
            return cacheMap.get(key);
        }
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        Integer put = cacheMap.put(key, value);
        if (put != null) {
            queue.remove(key);
        }
        if (cacheMap.size() > capacity) {
            if (!queue.isEmpty()) {
                Integer poll = queue.remove();
                cacheMap.remove(poll);
                timeMap.remove(poll);
                numMap.remove(poll);
            }
        }
        timeMap.put(key, ++time);
        numMap.put(key, numMap.getOrDefault(key, 0) + 1);
        queue.add(key);
    }

}
