package com.pranay.Leetcode30days;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class FirstUnique {
    LinkedHashSet<Integer> uniques;
    HashSet<Integer> duplicates;

    public FirstUnique(int[] nums) {
        uniques = new LinkedHashSet<>();
        duplicates = new HashSet<>();
        for (int num: nums) {
            this.add(num);
        }
    }

    public int showFirstUnique() {
        if (uniques.isEmpty()) {
            return -1;
        }
        return uniques.iterator().next();
    }

    public void add(int value) {
        if (!duplicates.contains(value)) {
            if (uniques.contains(value)) {
                uniques.remove(value);
                duplicates.add(value);
            } else {
                uniques.add(value);
            }
        }
    }

    public static void main(String[] args) {
        FirstUnique firstUnique = new FirstUnique(new int[]{2,3,5});
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        System.out.println(firstUnique.showFirstUnique()); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique()); // return -1
    }
}
