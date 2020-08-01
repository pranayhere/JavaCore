package com.pranay.interview.searching;

public class MountainSearchK {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 8, 4, 2};
        int peek = find(arr);
        System.out.println("Is Present : " + peek);
    }

    private static int find(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int M = arr[mid];

            if (M > arr[mid - 1])
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo - 1;
    }
}
