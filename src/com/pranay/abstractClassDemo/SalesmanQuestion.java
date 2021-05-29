package com.pranay.abstractClassDemo;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
        Stack<Pair<String, Integer>> stk = new Stack<>();

        for (Salesman s: salesmans) {
            if (!stk.isEmpty() && stk.peek().getKey().equals(s.name)) {
                Pair<String, Integer> curr = stk.pop();
                stk.push(new Pair<>(curr.getKey(), curr.getValue() + s.cost));
            } else {
                stk.push(new Pair<>(s.name, s.cost));
            }
        }


        LinkedList<Salesman> ans = new LinkedList<>();
        while (!stk.isEmpty()) {
            Pair<String, Integer> curr = stk.pop();
            ans.addFirst(new Salesman(curr.getKey(), curr.getValue()));
        }

        return ans;
    }
}
