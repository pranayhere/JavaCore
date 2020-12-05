package com.pranay.interview.arrays;

import java.util.ArrayList;
import java.util.List;

class FrontMiddleBackQueue {
    List<Integer> list;
    public FrontMiddleBackQueue() {
        list = new ArrayList<>();
    }

    public void pushFront(int val) {
        if (list.size() == 0)
            list.add(val);
        else
            list.add(0, val);
    }

    public void pushMiddle(int val) {
        if (list.size() == 0)
            list.add(val);
        else {
            int mid = list.size() / 2;
            list.add(mid, val);
        }
    }

    public void pushBack(int val) {
        if (list.size() == 0)
            list.add(val);
        else {
            list.add(list.size(), val);
        }
    }

    public int popFront() {
        if (list.size() == 0)
            return -1;
        int ans = list.get(0);
        list.remove(0);
        return ans;
    }

    public int popMiddle() {
        if (list.size() == 0)
            return -1;

        int mid = (list.size() - 1) / 2;
        int ans = list.get(mid);
        list.remove(mid);
        return ans;
    }

    public int popBack() {
        if (list.size() == 0)
            return -1;

        int ans = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return ans;
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        System.out.println(q.popFront());     // return 1 -> [4, 3, 2]
        System.out.println(q.popMiddle());    // return 3 -> [4, 2]
        System.out.println(q.popMiddle());    // return 4 -> [2]
        System.out.println(q.popBack());      // return 2 -> []
        System.out.println(q.popFront());     // return -1 -> [] (The queue is empty)
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */