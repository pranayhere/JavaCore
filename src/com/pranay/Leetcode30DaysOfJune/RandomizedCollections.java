package com.pranay.Leetcode30DaysOfJune;

// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomizedCollections {
    public static void main(String[] args) {
        RandomizedCollections collection = new RandomizedCollections();
        System.out.println("Insert 4 :" + collection.insert(4));
        collection.print();
        System.out.println("Insert 3 :" +collection.insert(3));
        collection.print();
        System.out.println("Insert 4 :" +collection.insert(4));
        collection.print();
        System.out.println("Insert 2 :" +collection.insert(2));
        collection.print();
        System.out.println("Insert 4 :" +collection.insert(4));
        collection.print();
        System.out.println("remove 4 : " + collection.remove(4));
        collection.print();
        System.out.println("remove 3 : " + collection.remove(3));
        collection.print();
        System.out.println("remove 4 : " + collection.remove(4));
        collection.print();
        System.out.println("remove 4 : " + collection.remove(4));
        collection.print();
        System.out.println("Get Random : " + collection.getRandom());
        collection.print();
    }

    ArrayList<Integer> lst;
    HashMap<Integer, Set<Integer>> idx;
    Random rand = new Random();

    public RandomizedCollections() {
        lst = new ArrayList<Integer>();
        idx = new HashMap<Integer, Set<Integer>>();
    }

    private boolean remove(int val) {
        if (!idx.containsKey(val) || idx.get(val).size() == 0)
            return false;

        int remove_idx = idx.get(val).iterator().next();
        idx.get(val).remove(remove_idx);
        int last = lst.get(lst.size() - 1);
        lst.set(remove_idx, last);

        idx.get(last).add(remove_idx);
        idx.get(last).remove(lst.size() - 1);
        lst.remove(lst.size() - 1);

        return true;
    }

    private int getRandom() {
        return lst.get(rand.nextInt(lst.size()));
    }

    public void print() {
        System.out.println("Map : " + idx);
        System.out.println("List : " + lst);
    }

    private boolean insert(int val) {
        if (!idx.containsKey(val))
            idx.put(val, new LinkedHashSet<>());
        idx.get(val).add(lst.size());
        lst.add(val);
        return idx.get(val).size() == 1;
    }
}
