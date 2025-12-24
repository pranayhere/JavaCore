package com.pranay.interview.searching;

import java.util.ArrayList;
import java.util.List;

public class ReorderPowerOfTwo {
    public static void main(String[] args) {
        int n = 112;
        ReorderPowerOfTwo p = new ReorderPowerOfTwo();
        boolean ans = p.reorderPowerOf2(n);
        System.out.println(ans);
    }

    public boolean reorderPowerOf2(int n) {
        String S = Integer.toString(n);
        int[] A = new int[S.length()];

        for (int i = 0; i < S.length(); i++) {
            A[i] = S.charAt(i) - '0';
        }

        List<Integer> perm = new ArrayList<>();
        permutation(A, 0, perm);

        for (Integer num: perm) {
            System.out.println(num);
            if (isPowerOf2(num))
                return true;
        }

        return false;
    }

    private void permutation(int[] A, int start, List<Integer> perm) {
        if (start == A.length)
            perm.add(convert(A));

        for (int i = start; i < A.length; i++) {
            swap(A, start, i);
            permutation(A, start + 1, perm);
            swap(A, start, i);
        }
    }

    public int convert(int[] A) {
        int N = 0;

        for (int a: A) {
            N = 10 * N + a;
        }

        return N;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private boolean isPowerOf2(int A) {
        if (A == 1)
            return true;

        if (A == 0)
            return false;

        if (A % 2 == 0)
            return isPowerOf2(A / 2);

        return false;
    }
}
