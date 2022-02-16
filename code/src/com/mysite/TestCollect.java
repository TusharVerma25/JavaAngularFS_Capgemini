package com.mysite;

import java.util.ArrayList;

class Student1 {

    private int id;
    private String name;
    private int chemistryMarks;
    private int physicsMarks;
    private int mathsMarks;

    public Student1() {}

    public Student1(int id, String name, int chemistryMarks, int physicsMarks, int mathsMarks) {
        this.id=id;
        this.name=name;
        this.chemistryMarks = chemistryMarks;
        this.physicsMarks = physicsMarks;
        this.mathsMarks = mathsMarks;
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

    public int getChemistryMarks() {
        return chemistryMarks;
    }

    public void setChemistryMarks(int chemistryMarks) {
        this.chemistryMarks = chemistryMarks;
    }

    public int getPhysicsMarks() {
        return physicsMarks;
    }

    public void setPhysicsMarks(int physicsMarks) {
        this.physicsMarks = physicsMarks;
    }

    public int getMathsMarks() {
        return mathsMarks;
    }

    public void setMathsMarks(int mathsMarks) {
        this.mathsMarks = mathsMarks;
    }

    @Override
    public String toString() {
        return this.getId() + " " + this.getName();
    }
}

class StudentUtility1 {

    public double getAverage(Student1 std) {
        return (std.getChemistryMarks()+std.getPhysicsMarks()+std.getMathsMarks())/3.0;
    }

    public void getGrade(Student1 std) {
        double avg=this.getAverage(std);

        if(avg>=90)
            System.out.println("Grade A");
        else if(avg>=80)
            System.out.println("Grade B");
        else if(avg>=70)
            System.out.println("Grade C");
        else
            System.out.println("Average");
    }


    public void display(ArrayList<Student1> stdList) {
            System.out.println(stdList);
    }

}

public class TestCollect {

    public static void main(String[] args) {

         ArrayList<Student1> stdList = new ArrayList<>();

        stdList.add(new Student1(101,"Raj",95,85,97));
        stdList.add(new Student1(102,"Rajesh",65,85,77));
        stdList.add(new Student1(103,"Tom",81,85,87));
        stdList.add(new Student1(104,"Suraj",85,85,67));
        stdList.add(new Student1(105,"Aman",82,85,83));

        StudentUtility1 stdUtility = new StudentUtility1();

        stdUtility.display(stdList);
        for(Student1 std:stdList)
            stdUtility.getGrade(std);
    }
}
