package com.pranay.GeeksForGeeks;

public class StudentsDoingHomework {
    public static void main(String[] args) {
        int[] startTime = {1};
        int[] endTime = {3};
        int queryTime = 4;

        int count = busyStudent(startTime, endTime, queryTime);
        System.out.println("count : " + count);
    }

    private static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i<startTime.length; i++) {
            int start = startTime[i];
            int end = endTime[i];

            if (start <= queryTime && end >= queryTime) {
                count++;
            }
        }
        return count;
    }
}
