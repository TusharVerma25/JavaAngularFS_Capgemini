import java.sql.*;
public class jdbcDemo {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","tiger");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from customer;");
            while(rs.next()) {

                String id= rs.getString("custid");
                String name= rs.getString("fname") + " " + rs.getString("ltname");
                System.out.println("Id " + id + " Name " + name);
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

}