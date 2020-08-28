package com.pranay.interview.searching;

public class FindInMountainArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 5, 4, 1};
        int target = 4;

        int idx = findInMountainArray(A, target);
        System.out.println("idx : " + idx);
    }

    public static int findInMountainArray(int[] A, int target) {
        int n = A.length;

        int lo = 0;
        int hi = n - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] < A[mid + 1])
                lo = mid + 1;
            else
                hi = mid;
        }

        int peek = lo;

        lo = 0;
        hi = peek;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target)
                return mid;
            else if (A[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        lo = peek;
        hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target)
                return mid;
            else if (A[mid] > target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return -1;
    }
}
