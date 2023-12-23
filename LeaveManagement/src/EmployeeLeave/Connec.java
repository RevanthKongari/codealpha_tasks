/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmployeeLeave;
import java.sql.*;

/**
 *
 * @author revanthkongari1507
 */
public class Connec {
    Connection con;
    Statement stm;
    Connec()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/TBS",
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
        new Connec();
        
    }
    
}