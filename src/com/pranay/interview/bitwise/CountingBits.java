package com.pranay.interview.bitwise;

import java.util.Arrays;
import java.util.LinkedList;

public class CountingBits {
    public static void main(String[] args) {
        int num = 1;
        int[] res = countBits(num);
        System.out.println(Arrays.toString(res));
    }

    private static int[] countBits(int num) {
        if (num == 0)
            return new int[]{0};


        int[] ans = new int[num + 1];
        int result = (int)(Math.log(num) / Math.log(2)) + 1;
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i<=result; i++) {
            int pow = (int) Math.pow(2, i);
            list.add(pow);
        }

        ans[0] = 0;
        int threshold = list.get(0);
        int currMinus = threshold;
        for (int i = 1; i <= num; i++) {
            if (i == threshold) {
                currMinus = threshold;
                list.removeFirst();
                threshold = list.getFirst();
            }
            ans[i] = ans[i - currMinus] + 1;
        }
        return ans;
    }
}
