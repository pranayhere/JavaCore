package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {
    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        paths.add(Arrays.asList("London","New York"));
        paths.add(Arrays.asList("New York","Lima"));
        paths.add(Arrays.asList("Lima","Sao Paulo"));
        String city = destCity(paths);
        System.out.println("City : " + city);
    }

    private static String destCity(List<List<String>> paths) {
        Set<String> hs = new HashSet<>();
        for (List<String> path: paths) {
            hs.add(path.get(1));
        }

        for (List<String> path: paths) {
            hs.remove(path.get(0));
        }
        return hs.iterator().next();
    }
}
