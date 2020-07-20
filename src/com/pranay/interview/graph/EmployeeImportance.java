package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        employees.add(new Employee(1, 5, List.of(2, 3)));
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

    private int dfs(int id) {
        Employee emp = emap.get(id);
        int ans = emp.importance;

        for (Integer next: emp.subordinates)
            ans += dfs(next);
        return ans;
    }
}
