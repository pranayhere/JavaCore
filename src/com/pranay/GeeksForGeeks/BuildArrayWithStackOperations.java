package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.List;

public class BuildArrayWithStackOperations {
    public static void main(String[] args) {
        int[] target = {1, 2};
        int n = 4;
        List<String> ops = buildArray(target, n);
        System.out.println(ops);
    }

    private static List<String> buildArray(int[] target, int n) {
        List<String> ops = new ArrayList<>();
        int ptr = 0;
        for (int i = 1; i<=n && ptr < target.length; i++) {
            if (target[ptr] == i) {
                ops.add("Push");
                ptr++;
            } else {
                ops.add("Push");
                ops.add("Pop");
            }
        }
        return ops;
    }
}
