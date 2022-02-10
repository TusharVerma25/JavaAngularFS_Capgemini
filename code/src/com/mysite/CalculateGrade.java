package com.mysite;

class Student {

    private int id;
    private String name;
    private int chemistryMarks;
    private int physicsMarks;
    private int mathsMarks;

    public Student() {}

    public Student(int id, String name, int chemistryMarks, int physicsMarks, int mathsMarks) {
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

    public double getAverage() {
        return (physicsMarks+chemistryMarks+mathsMarks)/3.0;
    }

    public void getGrade() {
        double avg=this.getAverage();

        if(avg>=90)
            System.out.println("Grade A");
        else if(avg>=80)
            System.out.println("Grade B");
        else if(avg>=70)
            System.out.println("Grade C");
        else
            System.out.println("Average");
    }
}


public class CalculateGrade {

    public static  Student findStudentWithMaxPercent(Student[] st) {

        int n=st.length;
        int index=0;
        double max=st[index].getAverage();

        for(int i=1;i<n;i++)
        {
            if(max<st[i].getAverage())
            {
                index=i;
                max=st[i].getAverage();
            }
        }

        return st[index];
    }

    public static void main(String[] args) {

        Student[] stdArray= new Student[4];
        stdArray[0]=new Student(101,"Raj",95,85,97);
        stdArray[1]=new Student(102,"Rajesh",65,85,77);
        stdArray[2]=new Student(103,"Tom",70,55,87);
        stdArray[3]=new Student(104,"Suraj",85,85,67);

        Student std= findStudentWithMaxPercent(stdArray);
        System.out.println(std.getName());
        System.out.println(std.getAverage());
        std.getGrade();
    }
}
