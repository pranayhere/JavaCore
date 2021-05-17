package com.pranay.interview.arrays;

import java.util.Arrays;
import java.util.Stack;

public class RotateTheBox {
    public static void main(String[] args) {
        char[][] box = {
                {'#','.','*','.'},
                {'#','#','*','.'}
        };

        RotateTheBox rtb = new RotateTheBox();
        char[][] ans = rtb.rotateTheBox(box);

        for (char[] a: ans) {
            System.out.println(Arrays.toString(a));
        }
    }

    public char[][] rotateTheBox(char[][] box) {
        int nr = box.length;
        int nc = box[0].length;

        char[][] rotated = new char[box[0].length][box.length];

        for (int r = 0; r < box.length; r++) {
            char[] row = box[r];
            Stack<Character> stk = new Stack<>();

            for (int c = 0; c < row.length; c++) {
                char ch = row[c];
                if (ch == '#') {
                    stk.push(ch);
                } else if (ch == '*') {
                    rotated[c][nr - 1 - r] = '*';
                    for (int j = c - 1; j >= 0 && !stk.isEmpty(); j--) {
                        rotated[j][nr - 1 - r] = stk.pop();
                    }
                }
            }

            if (stk.isEmpty())
                continue;

            for (int j = rotated.length - 1; j >= 0 && !stk.isEmpty(); j--) {
                rotated[j][nr - 1 - r] = stk.pop();
            }
        }

        for (int r = 0; r < rotated.length; r++) {
            for (int c = 0; c < rotated[0].length; c++) {
                if (rotated[r][c] == 0)
                    rotated[r][c] = '.';
            }
        }

        return rotated;
    }
}
