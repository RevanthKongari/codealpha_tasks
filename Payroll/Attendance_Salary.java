package Payroll;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.*;
import java.sql.*;
import java.util.Locale;

public class Attendance_Salary extends JFrame implements ActionListener 
{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4;
    Choice ch1;
    JButton bt1,bt2;
    JPanel p1,p2;
    Font f;
    int attend;
    Attendance_Salary()
    {
        super("List Attendance");
        setSize(740,380);
        setLocation(100,100);
        setResizable(false);
        f=new Font("Arial",Font.BOLD,14);
        
        l1 = new JLabel("Employee ID");
        l2 = new JLabel("");
        l3 = new JLabel("Total working days");
        l4=new JLabel("Attended days");
        l5 =new JLabel("No of leaves");
        l6=new  JLabel("Salary to be deposit");
        
        l1.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);
        ch1 = new Choice();
        try
        {
            Connection_Class obj= new Connection_Class();
                String q ="select distinct Eid from new_employee";
                ResultSet rest=obj.stm.executeQuery(q);
                while(rest.next())
                {
                    ch1.add(rest.getString("Eid"));
                }
        }
        catch(SQLException ex)
        {
        }
        
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        
        t1.setFont(f);
        t2.setFont(f);
        t3.setFont(f);
        t4.setFont(f);
        
        bt1 = new JButton("Confirm Emp Id");
        bt2 = new JButton("Close");
        //bt1=new JButton("print");
        
        bt1.setFont(f);
        bt2.setFont(f);
        
        bt1.setBackground(Color.BLACK);
        bt1.setBackground(Color.WHITE);
        bt2.setBackground(Color.WHITE);
        bt2.setForeground(Color.BLACK);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(8,2,10,10));
        p1.add(l1);
        p1.add(ch1);
        p1.add(l2);
        p1.add(bt1);
        p1.add(l4);
        p1.add(t1);
        p1.add(l5);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3); 
        p1.add(l6);
        p1.add(t4);
        p1.add(bt2);
        
        //p2 = new JPanel();
        //p2.setLayout(new GridLayout(1,1,10,10));
        
        setLayout(new BorderLayout(30,30));
        add(p1,"Center");
        add(bt2,"South");
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt2)
        {
            JOptionPane.showMessageDialog(null, "Are you sure");
             setVisible(false);
            
        }
        else
        {
            try
            {
                
                int id=Integer.parseInt(ch1.getSelectedItem());
                Connection_Class obj1=new Connection_Class();
                                
                String q2="select count(Eid) from attendance where first_half=\"present\" and Eid='"+id+"' ";
                ResultSet rest = obj1.stm.executeQuery(q2);
                while(rest.next())
                {
                    //attended days
                    attend = rest.getInt("count(Eid)");
                    
                    t1.setText(String.valueOf(attend));
                    
                }
                
                String q1="select count(Eid) from attendance where first_half=\"absent\" and Eid='"+id+"' ";
                ResultSet rest1=obj1.stm.executeQuery(q1);
                while(rest1.next())
                {
                    //no of leaves
                    
                    t2.setText(rest1.getString("count(Eid)"));
                    
                }
                
                String q3="select count(Eid) from attendance where Eid='"+id+"' ";
                ResultSet rest2 = obj1.stm.executeQuery(q3);
                while(rest2.next())
                {
                    //total working days
                    t3.setText(rest2.getString("count(Eid)"));
                    
                }
                //Connection_Class obj2=new Connection_Class();
                
                ResultSet rest4 = obj1.stm.executeQuery("select * from salary where Eid='"+id+"'");
                while(rest4.next())
                {
                    float i = rest4.getFloat("basis");
                    float hra=rest4.getFloat("hra");
                    float da=rest4.getFloat("da");
                    float pf=rest4.getFloat("pf");
                    float mid=rest4.getFloat("mid");
                   float t=(i/360)*attend;
                    float total=t+(hra%i)+(da%t)+(pf%t)+(mid%t);
                    String r="update attendance set sal='"+total+"'where Eid='"+id+"'";
                    obj1.stm.executeUpdate(r);                    
                    t4.setText(String.valueOf(total));
                    //String j=String.valueOf(i);
                    //t4.setText(j);
                    
                    
                }
                
            }
            catch(NumberFormatException | SQLException exx){
            }
        }
    }
    public static void main(String args[])
    {
        new Attendance_Salary().setVisible(true);
    }    
}
