package com.pranay.interview.implementation;

import java.util.*;

// only 3 test cases passed
enum Category {
    InformationTechnologies,
    HumanResources,
    Accounting,
    Sales,
    Marketing,
    Legal
}

class CategoryNode {
    Category category;
    int totalPoint;

    public CategoryNode(Category category, int totalPoint) {
        this.category = category;
        this.totalPoint = totalPoint;
    }

    public Category getCategory() {
        return category;
    }

    public int getTotalPoint() {
        return totalPoint;
    }
}

class EmployeeNode {
    String employeeName;
    int totalPoint;

    public EmployeeNode(String employeeName, int totalPoint) {
        this.employeeName = employeeName;
        this.totalPoint = totalPoint;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getTotalPoint() {
        return totalPoint;
    }
}

class Employee {
    public String name;
    public int level;
    public Set<Category> categories;

    public Employee(String name, int level, Set<Category> categories) {
        this.name = name;
        this.level = level;
        this.categories = categories;
    }
}

class Ticket {
    public int id;
    public String name;
    public Category category;
    public int points;

    public Ticket(int id, String name, Category category, int points) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.points = points;
    }
}

interface IHelpDesk {
    void addTicket(Ticket ticket);
    void addEmployee(Employee employee);
    void completeTicket(String empName, int ticketId);
    int getWaitingTicketCount();
    int getCompletedTicketsTotalPoints();
    List<CategoryNode> getTicketsTotalPointByCategory();
    List<EmployeeNode> getTicketsTotalPointsByEmployee();
}

class HelpDesk implements IHelpDesk {
    Map<Integer, Ticket> tickets = new HashMap<>();
    Map<String, Employee> employees = new HashMap<>();
    int totalTickets = 0;
    int totalPoints = 0;
    Map<Category, Integer> pointsByCategory = new HashMap<>();
    Map<String, Integer> pointsByEmployee = new HashMap<>();

    @Override
    public void addTicket(Ticket ticket) {
        tickets.put(ticket.id, ticket);
        totalTickets++;
        pointsByCategory.put(ticket.category, pointsByCategory.getOrDefault(ticket.category, 0) + ticket.points);
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.put(employee.name, employee);
    }

    @Override
    public void completeTicket(String empName, int ticketId) {
        Employee emp = employees.get(empName);
        Ticket ticket = tickets.get(ticketId);

        if (!emp.categories.contains(ticket.category))
            return;

        if (emp.level < ticket.points)
            return;

        totalPoints += ticket.points;
        pointsByEmployee.put(emp.name, pointsByEmployee.getOrDefault(emp.name, 0) + ticket.points);
        tickets.remove(ticketId);
    }

    @Override
    public int getWaitingTicketCount() {
        return tickets.size();
    }

    @Override
    public int getCompletedTicketsTotalPoints() {
        return totalPoints;
    }

    @Override
    public List<CategoryNode> getTicketsTotalPointByCategory() {
        List<CategoryNode> nodes = new ArrayList<>();
        for (Category category: Category.values()) {
            nodes.add(new CategoryNode(category, pointsByCategory.getOrDefault(category, 0)));
        }

        return nodes;
    }

    @Override
    public List<EmployeeNode> getTicketsTotalPointsByEmployee() {
        List<EmployeeNode> nodes = new ArrayList<>();
        for (String empName: pointsByEmployee.keySet()) {
            nodes.add(new EmployeeNode(empName, pointsByEmployee.get(empName)));
        }

        return nodes;
    }
}

public class TicketSystem {
    public static void main(String[] args) {
    }
}
