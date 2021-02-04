package com.pranay.interview.greedy;

import java.util.Arrays;

public class SmallestStringWithGivenNumericValues {
    public static void main(String[] args) {
        int n = 3, k = 27;
        String ans = getSmallestString(n, k);
        System.out.println("Ans : " + ans);
    }

    public static String getSmallestString(int n, int k) {
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');

        for (int i = n - 1; i >=0; i--) {
            k -= i;

            if (k < 0)
                break;
            else if (k >= 26) {
                arr[i] = 'z';
                k -= 26;
            } else {
                arr[i] = (char) (k + 'a' - 1);
                k -= (k + 'a' - 1);
            }

            k += i;
        }
        return String.valueOf(arr);
    }
}
