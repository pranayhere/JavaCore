package com.pranay.interview.arrays;

import java.util.TreeMap;

public class MyCalendar {
    TreeMap<Integer, Integer> tm;

    public MyCalendar() {
        tm = new TreeMap<>();
    }

    public static void main(String[] args) {
        MyCalendar mc = new MyCalendar();
        System.out.println(mc.book(10, 20));
        System.out.println(mc.book(15, 25));
        System.out.println(mc.book(20, 30));
    }

    private boolean book(int start, int end) {
        Integer prev = tm.floorKey(start);
        Integer next = tm.ceilingKey(start);

        if ((prev == null || tm.get(prev) <= start) && (next == null || end <= next)) {
            tm.put(start, end);
            return true;
        }

        return false;
    }
}
