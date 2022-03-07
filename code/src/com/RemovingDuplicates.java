package com;

import java.util.*;
import java.util.stream.Collectors;

class Employee {

    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "<name: "+this.getName()+" salary: "+this.getSalary()+">";
    }

}

class EmployeeInfo{
    enum SortMethod {
        BYNAME,
        BYSALARY
    };

    public List<Employee> sort(List<Employee> emps, final SortMethod method) {
        List<Employee> sorted=new ArrayList<>();
            sorted= emps.stream().sorted (Comparator.comparing (Employee::getName)).collect(Collectors.toList());
        if(method.equals(SortMethod.BYSALARY))
            sorted= emps.stream().sorted (Comparator.comparing (Employee::getSalary)).collect(Collectors.toList());
        return sorted;
    }

    public boolean isCharacterPresentInAllNames(Collection<Employee> entities, String character) {
        return entities.stream().anyMatch(i -> i.getName().startsWith(character));
    }
}
public class RemovingDuplicates {

    public static void main(String[] args) {

        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("Mickey", 40000));
        emps.add(new Employee("Timmy", 50000));
        emps.add(new Employee("Annny", 40000));
        EmployeeInfo e=new EmployeeInfo();
        System.out.println(emps);
        System.out.println(e.sort(emps, EmployeeInfo.SortMethod.BYSALARY));
        System.out.println(e.isCharacterPresentInAllNames(emps,"Tim"));
        Set<Employee> uniqueEmployeeSet = emps.stream().distinct().collect(Collectors.toSet());
        System.out.println("\nEmployee list without duplicate addresses :");
        uniqueEmployeeSet.forEach(emp -> System.out.println(emp));
    }
}
