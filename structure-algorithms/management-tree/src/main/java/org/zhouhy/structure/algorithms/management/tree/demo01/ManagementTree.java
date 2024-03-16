package org.zhouhy.structure.algorithms.management.tree.demo01;

import java.util.*;

public class ManagementTree {
    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(10, "Tom", 0));
        employeeList.add(new Employee(2, "Mickey", 10));
        employeeList.add(new Employee(3, "Jerry", 10));
        employeeList.add(new Employee(7, "John", 2));
        employeeList.add(new Employee(5, "Sarah", 10));    
        
//        for(Employee e: employeeList){
//            System.out.println(e.name);
//        }
        displayManagementTree(employeeList);
    }

    public static void displayManagementTree(List<Employee> employees) {
        Map<Integer, Set<Employee>> employeeMap = new HashMap<>();
        for(Employee employee:employees){
            employeeMap.putIfAbsent(employee.getManagerId(), new TreeSet<Employee>());
            Set<Employee> employeeSet = employeeMap.get(employee.getManagerId());
            employeeSet.add(employee);
        }
        print(employeeMap, "->", 0);
    }
    
    public static void print(Map<Integer, Set<Employee>> employeeMap, String prefix, int managerId){
        if (employeeMap.containsKey(managerId)) {
            for (Employee emp : employeeMap.get(managerId)) {
                System.out.println(prefix + emp.name);
                print(employeeMap, prefix + "->", emp.id);
            }
        }
    }
}
