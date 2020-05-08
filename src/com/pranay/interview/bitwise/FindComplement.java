package com.pranay.interview.bitwise;

// https://leetcode.com/problems/complement-of-base-10-integer/solution/
public class FindComplement {
    public static void main(String[] args) {
        int N = 5;
        int complement = findComplement(N);
        System.out.println("Complement : " + complement);
    }

    private static int findComplement(int N) {
        if (N == 0)
            return 1;
        int todo = N;
        int bit = 1;

        while (todo != 0) {
            N = N ^ bit;
            bit = bit << 1;
            todo = todo >> 1;
            System.out.println("N : " + Integer.toBinaryString(N) + " Bit : " + Integer.toBinaryString(bit) + " Todo : " + Integer.toBinaryString(todo));
        }
        return N;
    }
}
