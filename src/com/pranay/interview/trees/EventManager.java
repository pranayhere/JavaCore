package com.pranay.interview.trees;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class EventManager {
    TreeMap<Integer, TreeSet<Integer>> tm; // <priority, TS<eventID>>
    Map<Integer, Integer> hm; // <eventId, priority>

    public EventManager(int[][] events) {
        tm = new TreeMap<>();
        hm = new HashMap<>();

        for (int[] e: events) {
            hm.put(e[0], e[1]);
            tm.computeIfAbsent(e[1], k -> new TreeSet<>()).add(e[0]);
        }
    }

    public void updatePriority(int eventId, int newPriority) {
        int currPriority = hm.get(eventId);
        // remove first
        TreeSet<Integer> ts = tm.get(currPriority);
        ts.remove(eventId);
        if (ts.isEmpty())
            tm.remove(currPriority);

        // add later

        hm.put(eventId, newPriority);
        tm.computeIfAbsent(newPriority, k -> new TreeSet<>()).add(eventId);
    }

    public int pollHighest() {
        if (tm.isEmpty())
            return -1;

        Integer highestPriority = tm.lastKey();
        TreeSet<Integer> eventIds = tm.get(highestPriority);
        int ans = eventIds.first();

        eventIds.remove(ans);

        if (eventIds.isEmpty()) {
            tm.remove(highestPriority);
        } else {
            tm.put(highestPriority, eventIds);
        }

        return ans;
    }

    public static void main(String[] args) {
        EventManager em = new EventManager(new int[][]{{9,4}, {13, 8}, {11, 6}});
        em.updatePriority(13, 5);
        em.pollHighest();
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */
