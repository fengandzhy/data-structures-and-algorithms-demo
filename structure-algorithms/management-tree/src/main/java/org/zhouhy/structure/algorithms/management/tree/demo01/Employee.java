package org.zhouhy.structure.algorithms.management.tree.demo01;

@SuppressWarnings("unused")
public class Employee implements Comparable<Employee> {
    int id;
    String name;
    int managerId;

    public Employee(int id, String name, int managerId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
    }  

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getManagerId() {
        return managerId;
    }

    @Override
    public int compareTo(Employee anotherEmployee) {
        return this.name.compareTo(anotherEmployee.name);
    }
}
