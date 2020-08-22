package com.pranay.interview.graph;

public class TheMazeDFS {
    public static void main(String[] args) {
        int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[] start = {0,4};
        int[] dest = {4,4};

        TheMazeDFS tm = new TheMazeDFS();
        boolean ans = tm.hasPath(maze, start, dest);
        System.out.println("Has Path ? " + ans);
    }

    int[] dest;
    boolean ans;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        dest = destination;

        int nr = maze.length;
        int nc = maze[0].length;

        return dfs(maze, start[0], start[1], new boolean[nr][nc]);
    }

    public boolean dfs(int[][] maze, int r, int c, boolean[][] seen) {
        int nr = maze.length;
        int nc = maze[0].length;

        if (r == dest[0] && c == dest[1])
            return true;

        if (r < 0 || r >= nr || c < 0 || c >= nc || seen[r][c] || maze[r][c] == 1)
            return false;

        seen[r][c] = true;

        return dfs(maze, r + 1, c, seen)
                || dfs(maze, r - 1, c, seen)
                || dfs(maze, r, c + 1, seen)
                || dfs(maze, r, c - 1, seen);
    }
}
