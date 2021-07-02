package com.pranay.interview.graph;

import java.util.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
};

public class EmployeeImportance {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        employees.add(new Employee(2, 3, new ArrayList<>()));
        employees.add(new Employee(3, 3, new ArrayList<>()));

        int id = 1;

        EmployeeImportance ei = new EmployeeImportance();
        int importance = ei.getImportance(employees, id);
        System.out.println("Importance : " + importance);
    }

    Map<Integer, Employee> emap = new HashMap<>();
    private int getImportance(List<Employee> employees, int id) {
        for (Employee e: employees) {
            emap.put(e.id, e);
        }

        return dfs(id);
    }

    public int dfs(int empId) {
        Employee curr = emap.get(empId);

        int imp = 0;

        for (Integer subordinate: curr.subordinates) {
            imp += dfs(subordinate);
        }

        return imp + curr.importance;
    }
}
