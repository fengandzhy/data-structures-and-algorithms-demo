package org.zhouhy.structure.algorithms.management.tree.demo01;

public class Employee implements Comparable {
    int id;
    String name;
    int managerId;

    public Employee(int id, String name, int managerId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
    }

    @Override
    public int compareTo(Object o) {
        Employee anotherEmployee = (Employee) o;
        return this.name.compareTo(anotherEmployee.name);
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
}
