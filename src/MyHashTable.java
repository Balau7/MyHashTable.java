import java.util.LinkedList;

public class MyHashTable<K, V> {
    private static class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<HashNode<K, V>>[] buckets;
    private int capacity;
    private int size;

    public MyHashTable() {
        capacity = 10;
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    public void put(K key, V value) {
        int index = Math.abs(key.hashCode()) % capacity;
        buckets[index].add(new HashNode<>(key, value));
        size++;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBucketSize(int index) {
        return buckets[index].size();
    }

    public int size() {
        return size;
    }
}
