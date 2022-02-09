import java.util.Scanner;
class GradeChecker{
    int marks;

    GradeChecker(int marks)
    {
        this.marks=marks;
    }

    public void checkGrade()
    {
        if(marks>=90)
            System.out.println("A");
        else if(marks>=80)
            System.out.println("B");
        else if(marks>=70)
            System.out.println("C");
        else
            System.out.println("Average");
    }
}

public class CalcGrade{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int marks = sc.nextInt();
        GradeChecker obj1 = new GradeChecker(marks);
        obj1.checkGrade();
    }
}