package Payroll;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.*;
import java.sql.*;

public class List_Employee extends JFrame implements ActionListener  
{
    JTable tb;
    String x[]={"Eid","name","gender","address","state","city","email","phone"};
    String y[][]=new String[20][8];
    JButton bt1;
    int i=0;
    int j=0;
    Font f;
    
    List_Employee()
    {
        super("List Employee");
        setSize(900,400);
        setLocation(100,100);
        setResizable(false);
        f=new Font("Arial",Font.BOLD,14);
        try{
             Connection_Class obj= new Connection_Class();
                String q ="select * from new_employee";
                ResultSet rest=obj.stm.executeQuery(q);
                while(rest.next())
                {
                    y[i][j++]=rest.getString("Eid");
                    y[i][j++]=rest.getString("name");
                    y[i][j++]=rest.getString("gender");
                    y[i][j++]=rest.getString("address");
                    y[i][j++]=rest.getString("state");
                    y[i][j++]=rest.getString("city");
                    y[i][j++]=rest.getString("email");
                    y[i][j++]=rest.getString("phone");
                    i++;
                    j=0;
                }
                tb=new JTable(y,x);
                tb.setFont(f);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        JScrollPane js=new JScrollPane(tb);
        add(js);
        bt1=new JButton("print");
        add(bt1,"South");
        bt1.setBackground(Color.BLACK);
        bt1.setBackground(Color.WHITE);
        bt1.addActionListener(this);
        bt1.setFont(f);
        
        add(bt1,"South");                
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            try{
                tb.print();
            }
            catch(PrinterException exx)
            {
            }
        }
    }
    public static void main(String args[])
    {
        new List_Employee().setVisible(true);
    }
}































