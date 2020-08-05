package com.pranay.interview.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation details of Segment Tree
 * https://www.youtube.com/watch?v=Oq2E2yGadnU
 */
public class SegmentTree {

    private List<Integer> data;
    private int n;

    public SegmentTree(List<Integer> list) {
        n = list.size();
        data = new ArrayList<>(2 * n);

        for (int idx = 0; idx < n; idx++)
            data.add(0);

        for (int idx = 0; idx < n; idx++)
            data.add(list.get(idx));

        for (int idx = n - 1; idx > 0; idx--)
            data.set(idx, Math.min(data.get(2 * idx), data.get(2 * idx + 1)));
    }

    public void update(int idx, int value) {
        idx += n;
        data.set(idx, value);

        while (idx > 1) {
            idx = idx / 2;
            data.set(idx, Math.min(data.get(2 * idx), data.get(2 * idx + 1)));
        }
    }

    public int minimum(int left, int right) {
        left += n;
        right += n;
        int min = Integer.MAX_VALUE;

        while (left < right) {
            if (left % 2 == 1) {
                min = Math.min(min, data.get(left));
                left++;
            }

            if (right % 2 == 1) {
                right--;
                min = Math.min(min, data.get(right));
            }

            left = left / 2;
            right = right / 2;
        }

        return min;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 2, 3, 1);
        SegmentTree st = new SegmentTree(list);
        System.out.println(st.data);
        st.update(3, 7);
        System.out.println(st.data);
        System.out.println(st.minimum(1, 3));
    }
}
