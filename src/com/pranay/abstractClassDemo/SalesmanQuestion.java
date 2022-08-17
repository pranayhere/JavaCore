package com.pranay.abstractClassDemo;

import java.util.*;

class Salesman {
    String name;
    int cost;

    public Salesman(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}

public class SalesmanQuestion {

    public static void main(String []args){
        List<Salesman> list = new ArrayList<>();
        list.add(new Salesman("R", 1));
        list.add(new Salesman("R", 1));
        list.add(new Salesman("R", 1));
        list.add(new Salesman("S", 1));
        list.add(new Salesman("R", 1));

        List<Salesman> ans = aggregate(list);
        System.out.println(ans);
    }

    public static List<Salesman> aggregate(List<Salesman> salesmans) {
        Stack<Map.Entry<String, Integer>> stk = new Stack<>();

        for (Salesman s: salesmans) {
            if (!stk.isEmpty() && stk.peek().getKey().equals(s.name)) {
                Map.Entry<String, Integer> curr = stk.pop();
                stk.push(new AbstractMap.SimpleEntry<>(curr.getKey(), curr.getValue() + s.cost));
            } else {
                stk.push(new AbstractMap.SimpleEntry<>(s.name, s.cost));
            }
        }


        LinkedList<Salesman> ans = new LinkedList<>();
        while (!stk.isEmpty()) {
            Map.Entry<String, Integer> curr = stk.pop();
            ans.addFirst(new Salesman(curr.getKey(), curr.getValue()));
        }

        return ans;
    }
}
