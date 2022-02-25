import java.sql.*;
import java.util.Scanner;

public class LibraryManagementSys {

    public static void insertIntoTable(int id, String name, String aname, String year, double price) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","tiger");
            Statement stmt=con.createStatement();
            stmt.executeUpdate("insert into library VALUES ("+id+", '"+name+"', '"+aname+"', '"+year+"', "+price+");");
            System.out.println("Record inserted");
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void showBook() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","tiger");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from library;");
            while(rs.next()) {

                String id= rs.getString(1);
                String name= rs.getString(2);
                String aname=rs.getString(3);
                String year=rs.getString(4);
                String cost=rs.getString(5);
                System.out.println(id + "   " + name + "   " + aname + "   " + year + "   " + cost);
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void updateTable(int id,String year) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","tiger");
            Statement stmt=con.createStatement();
            stmt.executeUpdate("UPDATE library SET publish_year = '"+year+"' WHERE book_id = "+id+";");
            System.out.println("Record updated");
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void updateTable(int id) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","tiger");
            Statement stmt=con.createStatement();
            stmt.executeUpdate("delete from library where book_id = "+id+";");
            System.out.println("Record deleted");
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("\nChoose option \n1.Insert\n2.Show\n3.Update\n4.Delete\n5.Exit");
            int n=sc.nextInt();
            switch(n) {
                case 1: System.out.println("Enter book id");
                        int id=sc.nextInt();
                        System.out.println("Enter book name");
                        String name=sc.next();
                        System.out.println("Enter author name");
                        String aname=sc.next();
                        System.out.println("Enter year of publish");
                        String year=sc.next();
                        System.out.println("Enter price");
                        int cost=sc.nextInt();
                        insertIntoTable(id,name,aname,year,cost);
                        break;
                case 2: showBook();
                        break;
                case 3: showBook();
                        System.out.println("Enter the id of which you want to Update");
                        id=sc.nextInt();
                        System.out.println("Enter year");
                        year=sc.next();
                        updateTable(id,year);
                        break;
                case 4: showBook();
                        System.out.println("Enter the id of which you want to delete");
                        id=sc.nextInt();
                        updateTable(id);
                        break;
                default: System.exit(0);
        }
        }
    }
}
