package com.pranay.interview.arrays;

public class SpecialPositionInBinaryMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}
        };

        SpecialPositionInBinaryMatrix spbm = new SpecialPositionInBinaryMatrix();
        int count = spbm.numSpecial(mat);
        System.out.println("Ans : " + count);
    }

    public int numSpecial(int[][] mat) {
        int nr = mat.length;
        int nc = mat[0].length;

        int count = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (mat[i][j] == 1 && isSpecial(i, j, mat)) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isSpecial(int r, int c, int[][] mat) {
        int nr = mat.length;
        int nc = mat[0].length;

        int countOnes = 0;
        for (int i = 0; i < nr; i++) {
            if (mat[i][c] == 1 && i != r)
                countOnes++;
        }

        for (int i = 0; i < nc; i++) {
            if (mat[r][i] == 1 && i != c)
                countOnes++;
        }

        return countOnes == 0;
    }
}
