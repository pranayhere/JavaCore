package com.pranay.interview.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 5 5
 * 2 5 5 0 2
 * 2 5 6 2 1
 *
 * 3
 */
public class RzStripes {
    public static void main(String[] args) throws IOException {
//        int[] A = {2, 5, 5, 0, 2, 3, 3, 6, 2, 0, 0, 1};
//        int[] B = {2, 5, 6, 2, 1, 2, 0, 1, 3, 1, 5};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        String[] arrStr = br.readLine().split(" ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(arrStr[i]);
        }

        String[] arrStr2 = br.readLine().split(" ");
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(arrStr2[i]);
        }

        int ans = getCount(A, B);
        System.out.println(ans);
    }

    private static int getCount(int[] A, int[] B) {
        Set<Integer> hs = new HashSet<>();

        List<Set<Integer>> ua = new ArrayList<>();
        List<Set<Integer>> ub = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            hs.add(A[i]);
            ua.add(new HashSet<>(hs));
        }

        hs.clear();
        for (int i = 0; i < B.length; i++) {
            hs.add(B[i]);
            ub.add(new HashSet<>(hs));
        }

        int count = 0;
        for (int i = 0; i < ua.size(); i++) {
            for (int j = 0; j < ub.size(); j++) {
                Set<Integer> l1 = ua.get(i);
                Set<Integer> l2 = ub.get(j);

                if (l1.size() == l2.size() && l1.equals(l2)) {
                    count++;
                }
            }
        }

        return count;
    }
}
