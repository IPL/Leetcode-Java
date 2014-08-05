import java.util.*;
public class LRUCache {

    private LRUMap mMap;

    public LRUCache(int capacity) {
        mMap = new LRUMap(capacity);
    }

    public int get(int key) {
        if (mMap.containsKey(key))
            return mMap.get(key);
        else
            return -1;
    }

    public void set(int key, int value) {
        mMap.put(key, value);
    }

    private class LRUMap extends LinkedHashMap<Integer, Integer> {
        private int mCapacity;

        /*  Constructs an empty LinkedHashMap instance with the specified 
         *      initial capacity, load factor and ordering mode.
         *  Parameters:
         *      initialCapacity the initial capacity
         *      loadFactor the load factor
         *      accessOrder the ordering mode - true for access-order, 
         *                                      false for insertion-order
         *  Throws:
         *      java.lang.IllegalArgumentException if the initial capacity 
         *      is negative or the load factor is nonpositive
         */
        public LRUMap(int capacity) {
            super(capacity, 0.75f, true);
            mCapacity = capacity;
        }

        // true if the eldest entry should be removed from the map; 
        // false if it should be retained.
        @Override
        protected boolean removeEldestEntry(
                java.util.Map.Entry<Integer, Integer> eldest) {
            return size() > mCapacity;
        }
    }
}