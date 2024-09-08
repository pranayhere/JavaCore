package com.pranay.interview.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms3 {
    public static void main(String[] args) {
//        int n = 2;
//        int[][] meetings = {{0,10},{1,5},{2,7},{3,4}};

        int n = 3;
        int[][] meetings = {{1,20},{2,10},{3,5},{4,9},{6,8}};
        MeetingRooms3 mr = new MeetingRooms3();
        int ans = mr.mostBooked(n, meetings);
        System.out.println("Ans: " + ans);
    }

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        // {endTime, room}
        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> a[0] == b[0] ? (int) (a[1] - b[1]) : (int) (a[0] - b[0]));
        int[] roomCount = new int[n];
        int res = 0;

        for (int i = 0; i < n; i++)
            q.add(new long[]{0, i});

        for (int[] item: meetings) {
            int time = item[0]; // new meeting start time

            while (q.peek()[0] < time) { // order all available room by room index
                q.offer(new long[]{time, q.poll()[1]});
            }

            long[] curr = q.poll();
            int currRoom = (int) curr[1];

            long meetingEndTime = curr[0] + (item[1] - item[0]); // current room endTime + this meeting time
            roomCount[currRoom]++;

            if (roomCount[currRoom] > roomCount[res]) {
                res = currRoom;
            } else if (roomCount[currRoom] == roomCount[res]) {
                res = Math.min(res, currRoom);
            }

            q.add(new long[]{meetingEndTime, currRoom});
        }

        return res;
    }
}
