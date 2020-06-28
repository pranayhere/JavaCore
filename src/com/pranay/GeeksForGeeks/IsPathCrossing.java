package com.pranay.GeeksForGeeks;


import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class IsPathCrossing {
    public static void main(String[] args) {
        String path = "NNSWWEWSSESSWENNW";
        boolean ans = isPathCrossing(path);
        System.out.println("Ans : " + ans);
    }

    private static boolean isPathCrossing(String path) {
        Pair<Integer, Integer> init = new Pair<>(0,  0);
        char[] dirs = path.toCharArray();
        Map<Pair<Integer, Integer>, Integer> hm = new HashMap<>();
        hm.put(init, 0);
        Pair<Integer, Integer> pair = init;
        for (char dir: dirs) {
            int x = pair.getKey();
            int y = pair.getValue();

            if (dir == 'E') {
                x += 1;
            } else if (dir == 'W') {
                x -= 1;
            } else if (dir == 'S') {
                y -= 1;
            } else if (dir == 'N') {
                y += 1;
            }
            pair = new Pair<>(x, y);
            System.out.println(pair);
            if (hm.containsKey(pair)) {
                return true;
            } else {
                hm.put(pair, 0);
            }
        }
        return false;
    }
}
