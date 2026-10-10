package com.pranay.interview.design;

import java.util.Arrays;

public class ATM {
    int[] available;
    int[] currency = {20, 50, 100, 200, 500};

    public ATM() {
        available = new int[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            available[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] available = Arrays.copyOf(this.available, this.available.length);
        int[] notes = new int[5];
        int idx = 4;
        while (amount > 0 && idx >= 0) {
            if (available[idx] <= 0) {
                idx--;
                continue;
            }

            int curr = amount - currency[idx];
            if (curr < 0) {
                idx--;
                continue;
            }

            amount = curr;
            available[idx]--;
            notes[idx]++;
        }

        if (amount == 0) {
            this.available = available;
            return notes;
        }

        return new int[]{-1};
    }

    public static void main(String[] args) {
        ATM obj = new ATM();

        // ["ATM"]
        obj = new ATM();

        // ["deposit", [[0,0,1,2,1]]]
        obj.deposit(new int[]{0, 0, 1, 2, 1});

        // ["withdraw", [600]]
        System.out.println(Arrays.toString(obj.withdraw(600)));

        // ["deposit", [[0,1,0,1,1]]]
        obj.deposit(new int[]{0, 1, 0, 1, 1});

        // ["withdraw", [600]]
        System.out.println(Arrays.toString(obj.withdraw(600)));

        // ["withdraw", [550]]
        System.out.println(Arrays.toString(obj.withdraw(550)));
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */