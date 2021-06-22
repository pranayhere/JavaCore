package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 721. Accounts Merge
 * https://leetcode.com/problems/accounts-merge/
 */

public class AccountMerge {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        accounts.add(Arrays.asList("Mary","mary@mail.com"));
        accounts.add(Arrays.asList("John","johnnybravo@mail.com"));

        List<List<String>> ans = accountsMerge(accounts);
        System.out.println("Merged : " + ans);
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>(); // edge between two emails in the accounts
        Map<String, String> name = new HashMap<>(); // <email, username>

        for (List<String> account: accounts) {
            String userName = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                name.put(account.get(i), userName);

                if (i == 1)
                    continue;

                graph.computeIfAbsent(account.get(i), k -> new HashSet<>()).add(account.get(i - 1));
                graph.computeIfAbsent(account.get(i - 1), k -> new HashSet<>()).add(account.get(i));
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> res = new LinkedList<>();

        for (String email: name.keySet()) {
            if (visited.contains(email))
                continue;

            List<String> list = new ArrayList<>();
            dfs(email, graph, list, visited);
            Collections.sort(list);
            list.add(0, name.get(email));
            res.add(list);
        }

        return res;
    }

    public static void dfs(String email, Map<String, Set<String>> graph, List<String> list, Set<String> visited) {
        if (visited.contains(email))
            return;

        list.add(email);
        visited.add(email);

        for (String neigh: graph.getOrDefault(email, new HashSet<>())) {
            dfs(neigh, graph, list, visited);
        }
    }
}
