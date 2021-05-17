package com.pranay.interview.arrays;

public class SumOfFlooredPairs {
    public static void main(String[] args) {
        int[] nums = {2, 5, 9};
        int ans =  sumOfFlooredPairs(nums);
        System.out.println("Ans : " + ans);
    }

    static int N = (int) 10000;

    private static int sumOfFlooredPairs(int[] arr) {
        int n = arr.length;

        int freq[] = new int[N];
        int preFreq[] = new int[N];

        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }

        for (int i = 1; i < N; i++) {
            preFreq[i] = preFreq[i - 1] + freq[i];
        }

        int ans = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i; j < N; j += i) {
                int X = (preFreq[j - 1] - preFreq[Math.abs(j - i - 1)]);
                ans += X * (j / i - 1) * freq[i];
            }
        }
        return ans;
    }

}
