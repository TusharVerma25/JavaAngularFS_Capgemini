package com.mysite;

import java.util.Arrays;

class Customer1 implements Comparable<Customer1> {

    private int id;
    private String name;

    public Customer1() {}

    public Customer1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name;
    }

    @Override
    public int compareTo(Customer1 c) {
        return this.name.compareTo(c.getName());
    }
}

public class SortingOfObject {

    public static void main(String[] args) {

        Customer1[] customerArray=new Customer1[5];
        customerArray[0]= new Customer1(101,"Suraj");
        customerArray[1]= new Customer1(100,"Raj");
        customerArray[2]= new Customer1(103,"Tom");
        customerArray[3]= new Customer1(105,"Aman");
        customerArray[4]= new Customer1(104,"Rajesh");

        CustomerSorterUtility sort=new CustomerSorterUtility();

        System.out.println(Arrays.toString(customerArray));
        Arrays.sort(customerArray);
        System.out.println("Sorted by Name");
        System.out.println(Arrays.toString(customerArray));
    }
}
