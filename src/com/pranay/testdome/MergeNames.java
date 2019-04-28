package com.pranay.testdome;

import java.util.Arrays;
import java.util.HashSet;

public class MergeNames {
    
    public static String[] uniqueNames(String[] names1, String[] names2) {
    	HashSet<String> set = new HashSet<>();
        set.addAll(Arrays.asList(names1));
        set.addAll(Arrays.asList(names2));
        String[] union = {};
        return set.toArray(union);
    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}