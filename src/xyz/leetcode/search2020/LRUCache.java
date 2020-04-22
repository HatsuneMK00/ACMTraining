package xyz.leetcode.search2020;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int mCapacity;
    private Map<Integer, CacheLine> storage;
    private int clock = 0;

    public LRUCache(int capacity) {
        mCapacity = capacity;
        storage = new HashMap<>();
    }

    public int get(int key) {
        if (storage.containsKey(key)) {
            CacheLine line = storage.get(key);
            line.lastUsed = clock++;
            return line.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (storage.containsKey(key)) {
            CacheLine line = storage.get(key);
            line.value = value;
            line.lastUsed = clock++;
            return;
        }
        if (storage.size() >= mCapacity) {
            int delete = findLRUCacheLine();
            storage.remove(delete);
        }
        storage.put(key, new CacheLine(value, clock++));
    }

    private int findLRUCacheLine() {
        int keyLRU = 0;
        int time = Integer.MAX_VALUE;
        for (Integer key : storage.keySet()) {
            CacheLine line = storage.get(key);
            if (line.lastUsed < time) {
                time = line.lastUsed;
                keyLRU = key;
            }
        }
        return keyLRU;
    }

    public static class CacheLine {
        int value;
        int lastUsed;

        public CacheLine(int value, int lastUsed) {
            this.value = value;
            this.lastUsed = lastUsed;
        }
    }
}
