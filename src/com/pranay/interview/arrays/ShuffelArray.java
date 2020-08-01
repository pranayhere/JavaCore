package com.pranay.interview.arrays;

import java.util.Arrays;

public class ShuffelArray {
    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        String str = restoreString(s, indices);
        System.out.println("Str : " + str);
    }

    private static String restoreString(String s, int[] indices) {
        char[] arr = new char[indices.length];

        for (int i = 0; i < indices.length; i++) {
            arr[indices[i]] = s.charAt(i);
        }
        System.out.println(Arrays.toString(arr));
        return String.valueOf(arr);
    }
}
