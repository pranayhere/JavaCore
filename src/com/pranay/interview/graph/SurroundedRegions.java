package com.pranay.interview.graph;

// https://leetcode.com/problems/surrounded-regions/solution/

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions {
    public static void main(String[] args) {
//        char[][] board = {
//                {'X','X','X','X','X','X'},
//                {'X','X','0','X','X','X'},
//                {'X','X','X','X','X','X'},
//                {'0','0','X','X','X','X'},
//                {'X','X','X','0','0','X'},
//                {'X','X','X','X','0','X'},
//        };
//
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', '0', '0', 'X'},
                {'X', 'X', '0', 'X'},
                {'X', '0', 'X', 'X'},
        };

        char[][] ans = solve(board);
        for (char[] arr : ans) {
            System.out.println(arr);
        }
    }

    private static char[][] solve(char[][] board) {
        int nr = board.length;
        int nc = board[0].length;
        List<Pair<Integer, Integer>> list = new ArrayList<>();

        for (int i = 0; i < nr; i++) {
            if (board[i][0] == '0') {
                list.add(new Pair<>(i, 0));
            }

            if (board[i][nc - 1] == '0') {
                list.add(new Pair<>(i, nc - 1));
            }
        }

        for (int i = 0; i < nc; i++) {
            if (board[0][i] == '0') {
                list.add(new Pair<>(0, i));
            }

            if (board[nr - 1][i] == '0') {
                list.add(new Pair<>(nr - 1, i));
            }
        }

        for (Pair<Integer, Integer> pair : list) {
            dfs(board, pair.getKey(), pair.getValue());
        }

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (board[r][c] == '0') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'E') {
                    board[r][c] = '0';
                }
            }
        }

        return board;
    }

    private static void dfs(char[][] board, int r, int c) {
        int nr = board.length;
        int nc = board[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || board[r][c] != '0') {
            return;
        }

        board[r][c] = 'E';
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }

}
