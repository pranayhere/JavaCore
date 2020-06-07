package com.pranay.GeeksForGeeks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class KStrongestValue {
    public static void main(String[] args) {
        int[] arr = {1,1,3,5,5};
        int k = 2;

        int[] kStrongest = getStrongest(arr, k);
        System.out.println(Arrays.toString(kStrongest));
    }

    private static int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];
        System.out.println(m);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Math.abs(a - m) == Math.abs(b - m) ? a - b : Math.abs(a - m) - Math.abs(b - m));
        for (int a : arr) {
            pq.offer(a);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.stream().mapToInt(i -> i).toArray();
    }
}
