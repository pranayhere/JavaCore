package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class ArrayPairDivisibleByK {
    public static void main(String[] args) {
        int[] arr = {5, 9, 36, 74, 52, 31, 42};
        int k = 3;
        boolean ans = canArrange(arr, k);
        System.out.println("Ans : " + ans);
    }

    private static boolean canArrange(int[] a, int k) {
        int[] f = new int[k];
        for(int v : a){
            v %= k;
            if(v < 0)
                v += k;
            f[v]++;
        }

        System.out.println(Arrays.toString(f));
        for(int i = 1;i < k;i++){
            if(f[i] != f[k-i])
                return false;
        }
        return f[0] % 2 == 0;
    }
}
