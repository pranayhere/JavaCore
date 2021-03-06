package com.pranay.interview.design;

/**
 * 706. Design HashMap
 * https://leetcode.com/problems/design-hashmap/
 */

// open addressing and linear probing
public class MyHashMap {
    private static final double LOAD_FACTOR = 0.75;
    private Node[] nodes;
    private int size; // number of keys

    class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[5];
        size = 0;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = hash(key);
        for (Node x = nodes[idx]; x != null; x = x.next) {
            if (x.key == key) {
                x.val = value;
                return;
            }
        }

        nodes[idx] = new Node(key, value, nodes[idx]);
        size++;

        double loadFactor = (double) size / nodes.length;
        if (loadFactor > LOAD_FACTOR)
            rehash();
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = hash(key);
        for (Node x = nodes[idx]; x != null; x = x.next) {
            if (x.key == key)
                return x.val;
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = hash(key);
        Node pre = new Node(-1, -1, nodes[idx]);

        for (Node prev = pre; prev.next != null; prev = prev.next) {
            if (prev.next.key == key) {
                prev.next = prev.next.next;
                break;
            }
        }

        nodes[idx] = pre.next;
        size--;
    }


    private int hash(int key) {
        return key % nodes.length;
    }

    private void rehash() {
        Node[] tmp = nodes;
        nodes = new Node[tmp.length * 2];
        size = 0;

        for (Node head: tmp) {
            for (Node x = head; x != null; x = x.next) {
                put(x.key, x.val);
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);            // returns 1
        hashMap.get(3);            // returns -1 (not found)
        hashMap.put(2, 1);         // update the existing value
        hashMap.get(2);            // returns 1
        hashMap.remove(2);    // remove the mapping for 2
        hashMap.get(2);            // returns -1 (not found)
    }
}