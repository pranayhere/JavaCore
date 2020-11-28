package com.pranay.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RemoveIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{0, 2}, {3, 4}, {5, 7}};
        int[] toBeRemoved = {1, 6};

        List<List<Integer>> ans = removeInterval(intervals, toBeRemoved);
        System.out.println(ans);
    }

    private static List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int start1 = interval[0];
            int end1 = Math.min(interval[1], toBeRemoved[0]);
            int start2 = Math.max(interval[0], toBeRemoved[1]);
            int end2 = interval[1];

            if (end1 - start1 >= 1)
                res.add(new ArrayList<>(Arrays.asList(start1, end1)));

            if (end2 - start2 >= 1)
                res.add(new ArrayList<>(Arrays.asList(start2, end2)));
        }
        return res;
    }


    // one test case failed intervals = [[0, 100]], toBeRemoved = [0, 50] expected ans = [50, 100]
    public List<List<Integer>> removeInterval2(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        Stack<int[]> stk = new Stack<>();
        for (int[] curr: intervals) {
            if (stk.isEmpty() || stk.peek()[1] < curr[1])
                stk.push(curr);
            else {
                int[] tos = stk.pop();
                stk.push(new int[] {curr[0], Math.max(curr[1], tos[1])});
            }
        }

        List<int[]> mergedIntervals = new ArrayList<>();
        while (!stk.isEmpty()) {
            mergedIntervals.add(0, stk.pop());
        }

        for (int i = 0; i < mergedIntervals.size(); i++) {
            int[] curr = mergedIntervals.get(i);

            if (curr[1] < toBeRemoved[0])
                stk.push(curr);
            else if (curr[0] > toBeRemoved[0] && curr[1] < toBeRemoved[1])
                continue;
            else if (curr[0] > toBeRemoved[1])
                stk.push(curr);
            else if (curr[0] < toBeRemoved[0] && curr[1] < toBeRemoved[1])
                stk.push(new int[]{curr[0], toBeRemoved[0]});
            else if (curr[0] > toBeRemoved[0] && curr[1] > toBeRemoved[1])
                stk.push(new int[]{toBeRemoved[1], curr[1]});
            else if (curr[0] <= toBeRemoved[0] && curr[1] >= toBeRemoved[1]) {
                stk.push(new int[] {curr[0], toBeRemoved[0]});
                stk.push(new int[] {toBeRemoved[1], curr[1]});
            }
        }

        while (!stk.isEmpty()) {
            int[] curr = stk.pop();
            res.add(0, Arrays.asList(curr[0], curr[1]));
        }

        return res;

    }
}
