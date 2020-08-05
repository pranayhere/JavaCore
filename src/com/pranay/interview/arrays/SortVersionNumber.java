package com.pranay.interview.arrays;

import java.util.Arrays;

public class SortVersionNumber {
    public static void main(String[] args) {
        String[] versions = {"0.1", "1.1", "1.0.1", "1", "7.5.2.4", "7.5.3", "1.01", "1.001"};
        String[] sorted = sortVersions(versions);
        System.out.println("Sorted : " + Arrays.toString(sorted));
    }

    private static String[] sortVersions(String[] versions) {
        Arrays.sort(versions, (a, b) -> {
            String[] v1 = a.split("\\.");
            String[] v2 = b.split("\\.");

            for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
                int n1 = i >= v1.length ? 0 : Integer.parseInt(v1[i]);
                int n2 = i >= v2.length ? 0 : Integer.parseInt(v2[i]);

                if (n1 != n2)
                    return n1 > n2 ? 1 : -1;
            }
            return 0;
        });
        return versions;
    }
}
