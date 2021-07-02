package com.pranay.interview.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1007. Minimum Domino Rotations For Equal Row
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 *
 * We find all possible number of rotations to make all the values in A are the same,
 * or all the values in B are the same, and then get the minimum among them.
 *
 * A[i] = A[i] if not swap OR B[i] if swap, B[i] = B[i] if not swap OR A[i] if swap.
 * When i = 0, A[0] can be either A[0] or B[0], B[0] can be either B[0] or A[0].
 * So the value must be either A[0] or B[0] if can be done.
 *
 * There are 4 possible cases:
 * make values in A equal to A[0]
 * make values in B equal to A[0]
 * make values in A equal to B[0]
 * make values in B equal to B[0]
 *
 * For each case we count rotations and we get the min rotations among them.
 */
public class MinimumDominoRotation {
    public static void main(String[] args) {

        int[] A = {1, 2, 1, 1, 1, 2, 2, 2};
        int[] B = {2, 1, 2, 2, 2, 2, 2, 2};
        //        int[] A = {2,1,2,4,2,2};
//        int[] B = {5,2,6,2,3,2};

        int count = minDominoRotations(A, B);
        System.out.println("Min rotations : " + count);
    }

    private static int minDominoRotations(int[] A, int[] B) {
        List<Integer> rotations = Arrays.asList(
                find(A[0], A, B),
                find(B[0], A, B),
                find(A[0], B, A),
                find(B[0], B, A)
        );

        int min = Collections.min(rotations);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static int find(int target, int[] A, int[] B) {
        int swaps = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                continue;
            } else if (A[i] != target && B[i] == target) {
                swaps++;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return swaps;
    }
}
