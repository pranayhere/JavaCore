package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.List;

/**
 * 1535. Find the Winner of an Array Game
 * https://leetcode.com/problems/find-the-winner-of-an-array-game/
 */
public class FindTheWinner {
    public static void main(String[] args) {
        int[] arr = {2,1,3,5,4,6,7};
        int k = 2;
        int num = getWinner(arr, k);
        System.out.println("Winner : " + num);
    }

    private static int getWinner(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();

        for(int a: arr) {
            list.add(a);
        }

        int winner = 0;
        int count = 0;
        while (count != k && count < arr.length) {
            int fir = list.get(0);
            int sec = list.get(1);

            if (fir > sec) {
                list.remove(1);
                list.add(sec);
                if (winner == fir)
                    count++;
                else
                    count = 1;
                winner = fir;
            } else {
                list.remove(0);
                list.add(fir);
                if (winner == sec)
                    count++;
                else
                    count = 1;
                winner = sec;
            }

        }
        return winner;
    }


}
