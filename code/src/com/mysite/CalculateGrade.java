package com.mysite;

import java.util.ArrayList;


interface StudentHireable {

    Student[] shortlistEligibleStudents(Student[] stdArray);
}

class FacebookHiringDepartment implements StudentHireable {

    ArrayList<Student> eligiblestudents = new ArrayList<>();

    @Override
    public Student[] shortlistEligibleStudents(Student[] stdArray) {

        int k=0,n= stdArray.length;
        Student[] eligibleStudents= new Student[stdArray.length];
        StudentUtility stdUtility=new StudentUtility();
        for(int i=0;i<n;i++)
        {
            if(stdUtility.getAverage(stdArray[i])>70.0 && stdArray[i].getMathsMarks()>80)
            {
                eligiblestudents.add(stdArray[i]);
                eligibleStudents[k++]=stdArray[i];
            }
        }
        return eligibleStudents;
    }

}

class AmazonHiringDepartment implements StudentHireable {

    ArrayList<Student> eligiblestudents = new ArrayList<>();

    @Override
    public Student[] shortlistEligibleStudents(Student[] stdArray) {

        int k=0,n= stdArray.length;
        Student[] eligibleStudents= new Student[stdArray.length];
        StudentUtility stdUtility=new StudentUtility();
        for(int i=0;i<n;i++)
        {
            if(stdUtility.getAverage(stdArray[i])>60.0 && stdArray[i].getMathsMarks()>70)
            {
                eligiblestudents.add(stdArray[i]);
                eligibleStudents[k++]=stdArray[i];
            }
        }

        return eligibleStudents;
    }

}

class GoogleHiringDepartment implements StudentHireable {

    ArrayList<Student> eligiblestudents = new ArrayList<>();

    @Override
    public Student[] shortlistEligibleStudents(Student[] stdArray) {

        int k=0,n= stdArray.length;
        Student[] eligibleStudents= new Student[stdArray.length];
        StudentUtility stdUtility=new StudentUtility();
        for(int i=0;i<n;i++)
        {
            if(stdUtility.getAverage(stdArray[i])>80.0 && stdArray[i].getMathsMarks()>75)
            {
                eligiblestudents.add(stdArray[i]);
                eligibleStudents[k++]=stdArray[i];
            }
        }

        return eligibleStudents;
    }

}

class FlipkartHiringDepartment implements StudentHireable {

    ArrayList<Student> eligiblestudents = new ArrayList<>();

    @Override
    public Student[] shortlistEligibleStudents(Student[] stdArray) {

        int k=0,n= stdArray.length;
        Student[] eligibleStudents= new Student[stdArray.length];
        StudentUtility stdUtility=new StudentUtility();
        for(int i=0;i<n;i++)
        {
            if(stdUtility.getAverage(stdArray[i])>65.0 && stdArray[i].getMathsMarks()>70)
            {
                eligiblestudents.add(stdArray[i]);
                eligibleStudents[k++]=stdArray[i];
            }
        }

        return eligibleStudents;
    }

}

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

    @Override
    public String toString() {
        return this.getId() + " " + this.getName();
    }
}

class StudentUtility {

    public double getAverage(Student std) {
        return (std.getPhysicsMarks()+std.getPhysicsMarks()+std.getMathsMarks())/3.0;
    }

    public void getGrade(Student std) {
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

    public Student findStudentWithMaxPercent(Student[] st) {

        int n=st.length;
        int index=0;
        double max=this.getAverage(st[0]);

        for(int i=1;i<n;i++)
        {
            if(max<this.getAverage(st[i]))
            {
                index=i;
                max=this.getAverage(st[i]);
            }
        }

        return st[index];
    }

    public void display(Student[] stdArray) {
        for(int i=0;i< stdArray.length;i++)
        {
            if(stdArray[i] == null)
                return;
            System.out.println(stdArray[i].getId() + " " + stdArray[i].getName());
        }
    }

    public void hiredBy(Student std, FacebookHiringDepartment fb, AmazonHiringDepartment amz, GoogleHiringDepartment google, FlipkartHiringDepartment fk) {
        String s=std.getName() + " is hired by ";

        if(fb.eligiblestudents.contains(std))
            s=s + "Facebook ";
        if(amz.eligiblestudents.contains(std))
            s=s + "Amazon ";
        if(google.eligiblestudents.contains(std))
            s=s + "Google ";
        if(fk.eligiblestudents.contains(std))
            s=s + "Flipkart ";

        System.out.println(s);
    }
}

public class CalculateGrade {

    public static void main(String[] args) {

        Student[] stdArray= new Student[5];
        stdArray[0]=new Student(101,"Raj",95,85,97);
        stdArray[1]=new Student(102,"Rajesh",65,85,77);
        stdArray[2]=new Student(103,"Tom",70,55,87);
        stdArray[3]=new Student(104,"Suraj",85,85,67);
        stdArray[4]=new Student(105,"Aman",77,85,73);

        Student[] eligibleStudents=new Student[stdArray.length];
        StudentUtility stdUtility=new StudentUtility();

        FacebookHiringDepartment fbHriring = new FacebookHiringDepartment();
        eligibleStudents=fbHriring.shortlistEligibleStudents(stdArray);
        System.out.println("Elegible Students for Facebook");
        stdUtility.display(eligibleStudents);

        AmazonHiringDepartment amazonHriring = new AmazonHiringDepartment();
        eligibleStudents=amazonHriring.shortlistEligibleStudents(stdArray);
//        System.out.println("Elegible Students for Amazon");
//        stdUtility.display(eligibleStudents);

        GoogleHiringDepartment googleHriring = new GoogleHiringDepartment();
        eligibleStudents=googleHriring.shortlistEligibleStudents(stdArray);
//        System.out.println("Elegible Students for Google");
//        stdUtility.display(eligibleStudents);

        FlipkartHiringDepartment filpkartHriring = new FlipkartHiringDepartment();
//        eligibleStudents=filpkartHriring.shortlistEligibleStudents(stdArray);/  System.out.println("Elegible Students for Flipkart");
//        stdUtility.display(eligibleStudents);

        stdUtility.hiredBy(stdArray[2],fbHriring,amazonHriring,googleHriring,filpkartHriring);

    }
}
