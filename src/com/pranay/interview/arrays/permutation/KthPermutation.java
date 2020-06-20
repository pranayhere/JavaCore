package com.pranay.interview.arrays.permutation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KthPermutation {
    public static void main(String[] args) {
        String permutation = getPermutation(3, 3);
        System.out.println("Permutation : " + permutation);
    }

    public static String getPermutation(int n, int k) {
        // factorial calculation and store in array
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++)
            fact[i] = fact[i - 1] * i;

        // create list of numbers from 1 to n, can also doen using simple for loop
        List<Integer> numbers = IntStream.range(1, n + 1).mapToObj(x -> x).collect(Collectors.toList());

        // place the numbers according to the approach given above
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / fact[n - i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * fact[n - i];
        }

        return sb.toString();
    }
}
