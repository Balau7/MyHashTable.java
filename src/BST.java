import java.util.*;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Entry<K, V>> {
    private class Node {
        K key;
        V value;
        Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class Entry<K, V> {
        private final K key;
        private final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
    }

    private Node root;
    private int size = 0;

    public int size() {
        return size;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public V get(K key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) return current.value;
            else if (cmp < 0) current = current.left;
            else current = current.right;
        }
        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = delete(node.left, key);
        else if (cmp > 0) node.right = delete(node.right, key);
        else {
            size--;
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node minRight = findMin(node.right);
            node.key = minRight.key;
            node.value = minRight.value;
            node.right = delete(node.right, minRight.key);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        List<Entry<K, V>> entries = new ArrayList<>();
        inOrderTraversal(root, entries);
        return entries.iterator();
    }

    private void inOrderTraversal(Node node, List<Entry<K, V>> entries) {
        if (node == null) return;
        inOrderTraversal(node.left, entries);
        entries.add(new Entry<>(node.key, node.value));
        inOrderTraversal(node.right, entries);
    }
}
