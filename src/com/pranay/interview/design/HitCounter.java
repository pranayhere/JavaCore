package com.pranay.interview.design;

import java.util.TreeMap;

public class HitCounter {

    private TreeMap<Integer, Integer> map;
    private int count;

    public HitCounter() {
        map = new TreeMap<>();
        map.put(0, 0);
        count = 0;
    }

    private void hit(int ts) {
        map.put(ts, ++count);
    }

    private int getHits(int ts) {
        int loKey = map.floorKey(Math.max(0, ts-300));
        int hiKey = map.floorKey(ts);
        return map.get(hiKey) - map.get(loKey);
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4));
        counter.hit(300);
        System.out.println(counter.getHits(300));
        System.out.println(counter.getHits(301));
    }
}
