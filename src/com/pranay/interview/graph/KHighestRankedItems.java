package com.pranay.interview.graph;

import java.util.*;

public class KHighestRankedItems {
    public static void main(String[] args) {
        int[][] grid = {{1,2,0,1},{1,3,0,1},{0,2,5,1}};
        int[] pricing = {2,5};
        int[] start = {0,0};
        int k = 3;

        KHighestRankedItems khri = new KHighestRankedItems();
        List<List<Integer>> ans = khri.highestRankedKItems(grid, pricing, start, k);
        System.out.println("Ans : " + ans);
    }

    static class Item {
        int r, c, price, dist;

        public Item(int r, int c, int price, int dist) {
            this.r = r;
            this.c = c;
            this.price = price;
            this.dist = dist;
        }
    }

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Item> pq = new PriorityQueue<>((a, b) -> {
            if (a.dist != b.dist)
                return a.dist - b.dist;
            else if (a.price != b.price)
                return a.price - b.price;
            else if (a.r != b.r)
                return a.r - b.r;
            else
                return a.c - b.c;
        });


        bfs(grid, start[0], start[1], pricing[0], pricing[1], pq);
        while (--k >= 0 && !pq.isEmpty()) {
            Item item = pq.poll();
            ans.add(Arrays.asList(item.r, item.c));
        }

        return ans;
    }

    public void bfs(int[][] grid, int row, int col, int lo, int hi, PriorityQueue<Item> pq) {
        int nr = grid.length;
        int nc = grid[1].length;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row, col});

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1 , 0}};
        int dist = 0;
        boolean[][] seen = new boolean[nr][nc];

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                if (seen[r][c])
                    continue;

                seen[r][c] = true;

                if (grid[r][c] >= lo && grid[r][c] <= hi) {
                    pq.offer(new Item(r, c, grid[r][c], dist));
                }

                for (int[] dir: dirs) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    if (newR < 0 || newR >= nr || newC < 0 || newC >= nc || seen[newR][newC] || grid[newR][newC] == 0)
                        continue;

                    q.offer(new int[]{newR, newC});
                }
            }

            dist++;
        }
    }
}
