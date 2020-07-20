package com.pranay.interview.greedy;

public class DivideChocolates {
    public static void main(String[] args) {
        int[] sweetness = {1,2,3,4,5,6,7,8,9};
        int K = 5;
        int maxSweetness = maximizeSweetness(sweetness, K);
        System.out.println("Max sweetness : " + maxSweetness);
    }

    private static int maximizeSweetness(int[] sweetness, int k) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int sweet: sweetness) {
            min = Math.min(min, sweet);
            sum += sweet;
        }

        int left = min;
        int right = sum;

        while (left < right) {
            int targetSweetness = left + (right - left) / 2;
            int chunks = 0;
            int currentSweetness = 0;

            for (int chunk: sweetness) {
                currentSweetness += chunk;

                if (currentSweetness > targetSweetness) {
                    chunks++;
                    currentSweetness = 0;
                }
            }
            System.out.println(left + "-" + targetSweetness + " " + chunks);

            if (chunks >= k) {
                left = targetSweetness + 1;
            } else {
                right = targetSweetness;
            }
        }
        return left;
    }
}
