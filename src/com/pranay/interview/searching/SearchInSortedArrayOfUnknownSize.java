package com.pranay.interview.searching;

import java.util.Arrays;
import java.util.List;

public class SearchInSortedArrayOfUnknownSize {
    public static void main(String[] args) {
        List<Integer> list = List.of(-1,0,3,5,9,12);
        int target = 9;

        int idx = search(list, target);
        System.out.println("Index : " + idx);
    }

    public static int search(List<Integer> reader, int target) {
        int lo = 0;
        int hi = 1;
        while (reader.get(hi) < target) {
            lo = hi;
            hi = 2 * hi;
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int M = reader.get(mid);
            if (M == target)
                return mid;

            if (M < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }
}
