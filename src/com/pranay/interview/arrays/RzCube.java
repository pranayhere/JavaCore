package com.pranay.interview.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 6 3
 * 1 1 2 2 1 3
 * 2 6
 * 1 6
 * 2 5
 *
 *
 * 3 2
 * 1 2 1
 * 1 2
 * 1 3
 */
public class RzCube {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int Q = Integer.parseInt(line[1]);

        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        int[][] queries = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            String[] que = br.readLine().split(" ");
            int L = Integer.parseInt(que[0]);
            int R = Integer.parseInt(que[1]);

            queries[i][0] = L;
            queries[i][1] = R;
        }


//        int[] arr = {1, 1, 2, 2, 1, 3};
//        int[][] queries = {{2, 6}, {1, 6}, {2, 5}};
//
////        int[] arr = {1, 2, 1};
////        int[][] queries = {{1, 2}, {1, 3}};
        findCube(arr, queries);
    }

    private static void findCube(int[] arr, int[][] queries) {
        for (int[] q: queries) {
            int L = q[0] - 1;
            int R = q[1] - 1;

            Map<Integer, Integer> hm = new HashMap<>();
            for (int i = L; i <= R; i++) {
                hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            }

//            System.out.println(hm);

            int ans = 0;
            for (int key: hm.keySet()) {
                ans += Math.pow(key * hm.get(key), 3);
            }

            System.out.println(ans);
        }
    }
}
