import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo {

    public static boolean saveEmployeeDetails(int id, String name, String address, double price) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb","root","tiger");
            Statement stmt=con.createStatement();
            stmt.executeUpdate("insert into employee VALUES ("+id+", '"+name+"', '"+address+"', "+price+");");
            con.close();
            return true;
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    public static void main(String[] args) {
        if(saveEmployeeDetails(101,"Raj","Vijayawada",50000))
            System.out.println("Record inserted");
    }
}
