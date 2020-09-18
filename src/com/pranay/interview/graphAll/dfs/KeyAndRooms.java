package com.pranay.interview.graphAll.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 841. Keys and Rooms
 * https://leetcode.com/problems/keys-and-rooms/
 */
public class KeyAndRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1, 3));
        rooms.add(List.of(3, 0, 1));
        rooms.add(List.of(2));
        rooms.add(List.of(0));

//        rooms.add(List.of(1));
//        rooms.add(List.of(2));
//        rooms.add(List.of(3));
//        rooms.add(new ArrayList<>());

        KeyAndRooms kr = new KeyAndRooms();
        boolean ans = kr.canVisitAllRooms(rooms);
        System.out.println("Ans : " + ans);
    }

    HashSet<Integer> enteredRooms = new HashSet<>();

    private boolean canVisitAllRooms(List<List<Integer>> rooms) {
        dfs(rooms, 0);
        return enteredRooms.size() == rooms.size();
    }

    public void dfs(List<List<Integer>> rooms, int currRoom) {
        enteredRooms.add(currRoom);

        for (int roomKey: rooms.get(currRoom)) {
            if (!enteredRooms.contains(roomKey)) {
                dfs(rooms, roomKey);
            }
        }
    }
}
