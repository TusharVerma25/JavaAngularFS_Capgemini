package com.mysite;

import java.util.Arrays;

class Customer implements Comparable<Customer> {

    private int id;
    private String name;

    public Customer() {}

    public Customer(int id, String name) {
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
    public int compareTo(Customer c) {
        if (this.id != c.getId()) {
            return this.id - c.getId();
        }
        return this.name.compareTo(c.getName());
    }
}

class CustomerSorterUtility {

    public void sortBy(Customer[] custArray, int n, String sortby) {

        if (n == 1)
        {
            return;
        }

        for (int i = 0; i < n - 1; i++)
        {
            if(sortby.equalsIgnoreCase("id")) {
                if (custArray[i].getId() > custArray[i + 1].getId()) {
                        Customer cst = custArray[i];
                        custArray[i] = custArray[i + 1];
                        custArray[i + 1] = cst;
                }
            }
            else if(sortby.equalsIgnoreCase("name")) {
                if (custArray[i].getName().compareTo(custArray[i + 1].getName()) > 0) {
                        Customer cst = custArray[i];
                        custArray[i] = custArray[i + 1];
                        custArray[i + 1] = cst;
                }
            }

        }
        sortBy(custArray, n-1,sortby);
    }
}

public class SortingOfObjectArray {

    public static void main(String[] args) {

        Customer[] customerArray=new Customer[5];
        customerArray[0]= new Customer(101,"Suraj");
        customerArray[1]= new Customer(100,"Raj");
        customerArray[2]= new Customer(103,"Tom");
        customerArray[3]= new Customer(105,"Aman");
        customerArray[4]= new Customer(104,"Rajesh");

        CustomerSorterUtility sort=new CustomerSorterUtility();
        sort.sortBy(customerArray,customerArray.length,"id");
        System.out.println("Sorted by Id");
        System.out.println(Arrays.toString(customerArray));

        sort.sortBy(customerArray,customerArray.length,"name");
        System.out.println("Sorted by Name");
        System.out.println(Arrays.toString(customerArray));

        Arrays.sort(customerArray);
        System.out.println("Sorted by both(Id and Name)");
        System.out.println(Arrays.toString(customerArray));
    }
}
