package com.pranay.userHierarchy;

import java.util.*;

class Emp {
    public Integer id;
    public List<Emp> bossTo;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", bossTo=" + bossTo +
                '}';
    }
}

public class UserHierarchy {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> hm = new HashMap<>();
        hm.put(1, Arrays.asList(100));
        hm.put(100, Arrays.asList(111, 222, 333, 400));
        hm.put(400, Arrays.asList(445,446,447));

        Emp emp = GetHierarchy(100, hm);

        System.out.println(emp);
    }

    private static Emp GetHierarchy(int employee, Map<Integer, List<Integer>> hm) {
        Emp emp = new Emp();
        emp.id = employee;

        Queue<Emp> q = new ArrayDeque<>();
        q.offer(emp);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Emp curr = q.poll();
                curr.bossTo = new ArrayList<>();

                List<Integer> emps = hm.getOrDefault(curr.id, new ArrayList<>());

                for (int e: emps) {
                    Emp emp1 = new Emp();
                    emp1.id = e;
                    curr.bossTo.add(emp1);
                    q.offer(emp1);
                }
            }
        }

        return emp;
    }
}
