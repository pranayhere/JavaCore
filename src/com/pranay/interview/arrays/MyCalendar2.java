package com.pranay.interview.arrays;

import java.util.TreeMap;

public class MyCalendar2 {
    TreeMap<Integer, Integer> delta;

    public MyCalendar2() {
        delta = new TreeMap<>();
    }

    public static void main(String[] args) {
        MyCalendar2 mc = new MyCalendar2();
        System.out.println(mc.book(10, 20)); // returns true
        System.out.println(mc.book(50, 60)); // returns true
        System.out.println(mc.book(10, 40)); // returns true
        System.out.println(mc.book(5, 15)); // returns false
        System.out.println(mc.book(5, 10)); // returns true
        System.out.println(mc.book(25, 55)); // returns true
    }

    private boolean book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0;

        for (int d: delta.values()) {
            active += d;

            if (active >= 3) {
                delta.put(start, delta.getOrDefault(start, 0) - 1);
                delta.put(end, delta.getOrDefault(end, 0) + 1);

                return false;
            }
        }

        return true;
    }
}
