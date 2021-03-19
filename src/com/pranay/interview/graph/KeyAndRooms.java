package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 841. Keys and Rooms
 * https://leetcode.com/problems/keys-and-rooms/solution/
 */
public class KeyAndRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1,3));
        rooms.add(Arrays.asList(3,0,1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));

        KeyAndRooms knr = new KeyAndRooms();
        boolean canVisit = knr.canVisitAllRooms(rooms);
        System.out.println("Ans : "  + canVisit);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> seen = new HashSet<>();
        dfs(rooms, 0, seen);

        return seen.size() == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, int curr, Set<Integer> seen) {
        if (seen.contains(curr))
            return;

        seen.add(curr);

        for (int roomId: rooms.get(curr))
            dfs(rooms, roomId, seen);
    }
}
