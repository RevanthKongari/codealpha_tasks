package Payroll;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Take_Attendance extends JFrame implements ActionListener 
{
    JLabel l1,l3;
    Choice ch1,ch3;
    JButton bt1;
    JPanel p1;
    Font f;
    Take_Attendance()
    {
        super("Take Attendance"); 
        setSize(290,290);
        setLocation(100,100);
        setResizable(false);
        
        f=new Font("Arial",Font.BOLD,14);
        l1 = new JLabel("First Half");
        
        l3 = new JLabel("Employee ID");
        
        
        l1.setFont(f);
        
        l3.setFont(f);
      
         
        ch1=new Choice();
        ch1.add("Present");
        ch1.add("Absent");        
        ch1.setFont(f);
        
        
        
        ch3=new Choice();
        try{
            Connection_Class obj = new Connection_Class();
            String q2 ="Select Eid from new_employee";
            ResultSet rest2 =obj.stm.executeQuery(q2);
            while(rest2.next())
            {
                ch3.add(rest2.getString("Eid"));
            }
        }
        catch(SQLException ex)
        {
        }
        ch3.setFont(f);
        
        bt1=new JButton("Submit");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.addActionListener(this);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(3,2,10,10));
        p1.add(l3);
        p1.add(ch3);
        p1.add(l1);
        p1.add(ch1);
        
        
        setLayout(new BorderLayout(30,30));
        add(p1,"Center");
        add(bt1,"South");        
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            try
            {
                int id=Integer.parseInt(ch3.getSelectedItem());
                String first_half=ch1.getSelectedItem();
                
                String dt =new java.util.Date().toString();   
                int i=0;
               
                Connection_Class obj=new Connection_Class();
                String q="insert into attendance values ('"+id+"','"+first_half+"','"+dt+"','"+i+"')";
                obj.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Attendace taken"+ id);
            }
            catch(HeadlessException | NumberFormatException  ex)
            {
                
            } catch (SQLException ex) {
                Logger.getLogger(Take_Attendance.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    public static void main(String args[])
    {
        new Take_Attendance().setVisible(true);
    }

    
}










































