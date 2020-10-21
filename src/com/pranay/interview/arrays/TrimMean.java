package com.pranay.interview.arrays;

import java.util.Arrays;

public class TrimMean {
    public static void main(String[] args) {
        int[] arr = {6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0};
        TrimMean tm = new TrimMean();
        double ans = tm.trimMean(arr);
        System.out.println(ans);
    }

    public double trimMean(int[] arr) {
        int len = arr.length;
        int sum = 0;

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int num = (len * 5) / 100;

        double count = 0.0;
        for (int i = num; i < len - num; i++) {
            System.out.println("Adding : " + arr[i]);
            sum += arr[i];
            count++;
        }

        System.out.println(sum + " - " + count);
        return sum / count;
    }
}
