package com.pranay.interview.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public static void main(String[] args) {
//        int[][] intervals = {{0, 30},{5, 10},{15, 20}};
//        int[][] intervals = {{7, 10},{2, 4}};
//        int[][] intervals = {{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}};
        int[][] intervals = {{13, 15}, {1, 13}};
        int count = minMeetingRooms(intervals);
        System.out.println("Min Meeting Rooms : " + count);
    }

    private static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] endingSoon = pq.peek();
            if (endingSoon[1] > intervals[i][0]) {
                pq.offer(intervals[i]);
            } else {
                pq.poll();
                pq.offer(intervals[i]);
            }
        }
        return pq.size();
    }

}
