
package Project;

import java.sql.*;

/**
 *
 * @author revanthkongari1507
 */
public class ConnectionProvider {
    Connection con;
    Statement stm;
    ConnectionProvider()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lms",
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
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
            
        }
    }
    public static void main(String[] args)
    {
        new ConnectionProvider();
        
    }
    
}
