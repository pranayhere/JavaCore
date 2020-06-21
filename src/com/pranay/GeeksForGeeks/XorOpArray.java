package com.pranay.GeeksForGeeks;

public class XorOpArray {
    public static void main(String[] args) {
        int n = 4, start = 3;
        int val = xorOperation(n, start);
        System.out.println("Val : " + val);
    }

    public static int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i<n; i++) {
            ans ^= start + i * 2;
        }
        return ans;
    }
}
