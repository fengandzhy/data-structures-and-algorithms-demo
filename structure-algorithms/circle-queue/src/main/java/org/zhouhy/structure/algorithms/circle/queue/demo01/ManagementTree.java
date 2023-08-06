package org.zhouhy.structure.algorithms.circle.queue.demo01;

import java.util.*;
import java.util.stream.Collectors;

public class ManagementTree {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(10, "Tom", 0));
        employees.add(new Employee(2, "Mickey", 10));
        employees.add(new Employee(3, "Jerry", 10));
        employees.add(new Employee(7, "John", 2));
        employees.add(new Employee(5, "Sarah", 10));

        displayManagementTree(employees);
    }

    public static void displayManagementTree(List<Employee> employees) {
        Map<Integer, List<Employee>> managerToEmployees = new HashMap<>();

        // Populate managerToEmployees map
        for (Employee emp : employees) {
            managerToEmployees.putIfAbsent(emp.managerId, new ArrayList<>());
            managerToEmployees.get(emp.managerId).add(emp);            ;
            managerToEmployees.put(emp.managerId, managerToEmployees.get(emp.managerId).stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList()));
        }

        // Display management tree
        displaySubordinates(managerToEmployees, 0, "->");
    }

    private static void displaySubordinates(Map<Integer, List<Employee>> managerToEmployees, int managerId, String prefix) {
        if (managerToEmployees.containsKey(managerId)) {
            for (Employee emp : managerToEmployees.get(managerId)) {
                System.out.println(prefix + emp.name);
                displaySubordinates(managerToEmployees, emp.id, prefix + "->");
            }
        }
    }
}
