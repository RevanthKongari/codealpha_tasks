package Payroll;
import java.sql.*;

public class Connection_Class 
{
    Connection con;
    Statement stm;
    Connection_Class()
    {
        try 
        
        {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/payroll",
                "root", "Itcareer@123");
            stm = con.createStatement();
            if(con.isClosed())
            {
                System.out.println("connection closed");
            }
            else
            {
                System.out.println("connection created");
            }
        }
        catch (Exception e) 
        {
            System.out.println(e);
            e.printStackTrace();
        }             
    }
    public static void main(String[] args)
    {
        new Connection_Class();
        
    }
    
}
