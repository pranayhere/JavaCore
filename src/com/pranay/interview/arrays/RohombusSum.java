package com.pranay.interview.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class RohombusSum {
    public static void main(String[] args) {
//        int[][] grid = {
//                {3,4,5,1,3},
//                {3,3,4,2,3},
//                {20,30,200,40,10},
//                {1,5,5,4,1},
//                {4,3,2,2,5}
//        };
        int[][] grid = {{7,7,7}};
        RohombusSum rs = new RohombusSum();
        int[] ans = rs.getBiggestThree(grid);
        System.out.println(Arrays.toString(ans));
    }

    public int[] getBiggestThree(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        TreeSet<Integer> pq = new TreeSet<Integer>((r1, r2) -> -Integer.compare(r1,r2));
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                pq.add(grid[r][c]);
                if (pq.size() > 3) {
                    pq.pollLast();
                }
            }
        }

        int k = 1;
        while (k < nr) {
            for (int r = k; r < nr - k; r++) {
                for (int c = k; c < nc - k; c++) {
                    pq.add(getSum(grid, r, c, k));
                    if (pq.size() > 3) {
                        pq.pollLast();
                    }
                }
            }
            k++;
        }

        int[] ans = new int[Math.min(pq.size(), 3)];
        int i = ans.length - 1;
        while (!pq.isEmpty()) {
            ans[i--] = pq.pollLast();
            if (i == 3)
                break;
        }

        return ans;
    }

    public int getSum(int[][] grid, int r, int c, int k) {
        int sum = 0;
        int row = r;
        int col = c - k;

        /*

		              down(r-k,c)
					 /           \
					/             \
		left(r,c-k)                right(r,c+k)
                    \             /
                     \           /
                       top(r+k,c)

		*/

        // left to down
        while (row > r - k && col < c) {
            sum += grid[row][col];
            row--;
            col++;
        }

        // down to right
        while (row < r && col < c + k) {
            sum += grid[row][col];
            row++;
            col++;
        }

        // right to top
        while (row < r + k && col > c) {
            sum += grid[row][col];
            row++;
            col--;
        }

        // top to left
        while (row > r && col > c - k) {
            sum += grid[row][col];
            row--;
            col--;
        }

        return sum;
    }
}
