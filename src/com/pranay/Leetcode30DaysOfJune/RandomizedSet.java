package com.pranay.Leetcode30DaysOfJune;

//https://leetcode.com/problems/insert-delete-getrandom-o1/solution/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    Map<Integer, Integer> hm;
    List<Integer> list;
    Random rnd = new Random();

    public RandomizedSet() {
        hm = new HashMap<>();
        list = new ArrayList<>();
    }

    private int getRandom() {
        return list.get(rnd.nextInt(list.size()));
    }

    private boolean remove(int key) {
        if (!hm.containsKey(key)) {
            return false;
        }

        int lastElement = list.get(list.size() - 1);
        int idx = hm.get(key);

        list.set(idx, lastElement);
        hm.put(lastElement, idx);

        list.remove(list.size() - 1);
        hm.remove(key);
        return false;
    }

    private boolean insert(int key) {
        if (hm.containsKey(key)) {
            return false;
        }
        hm.put(key, list.size());
        list.add(list.size(), key);
        return false;
    }

    public static void main(String[] args) {
        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.remove(2));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
    }

}
