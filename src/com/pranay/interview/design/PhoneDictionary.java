package com.pranay.interview.design;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class PhoneDictionary {
    Queue<Integer> minHeap;
    Set<Integer> hs;

    public PhoneDictionary(int maxNumbers) {
        minHeap = new PriorityQueue<>();
        hs = new HashSet<>();
        for (int i = 0; i<maxNumbers; i++) {
            minHeap.offer(i);
        }
    }

    public static void main(String[] args) {
        PhoneDictionary directory = new PhoneDictionary(3);
        System.out.println(directory.get());
        System.out.println(directory.get());
        System.out.println(directory.check(2));
        System.out.println(directory.get());
        System.out.println(directory.check(2));
        directory.release(2);
        System.out.println(directory.check(2));
    }

    private int get() {
        int num = 0;
        if (!minHeap.isEmpty()) {
            num = minHeap.poll();
            hs.add(num);
        }

        return num;
    }

    private void release(int num) {
        if (hs.contains(num)) {
            minHeap.offer(num);
            hs.remove(num);
        }
    }

    private boolean check(int num) {
        return !hs.contains(num);
    }
}
