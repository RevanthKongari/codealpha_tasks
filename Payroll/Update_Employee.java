package Payroll;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Update_Employee extends JFrame implements ActionListener 
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    Choice ch1,ch2;
    JButton bt1,bt2,bt3;
    JPanel p1,p2;
    Font f;
    
    Update_Employee()
    {
        super("Update Employee");
        setSize(740,447);
        setLocation(200,70);
        setResizable(false);
        
        f=new Font("Arial",Font.BOLD,14);
        l1 = new JLabel("Name");
        l2 = new JLabel("Gender");
        l3 = new JLabel("Address");
        l4 = new JLabel("State");
        l5 = new JLabel("City");
        l6 = new JLabel("Email");
        l7 = new JLabel("Phone");
        l9 = new JLabel("Employee Id");
        l = new JLabel("");
        ImageIcon img1 = new ImageIcon("C:\\Users\\revan\\Documents\\NetBeansProjects\\Payroll\\src\\Payroll\\login.png");
        Image image1 = img1.getImage().getScaledInstance(140,400,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(image1);
        l8 =new JLabel(img2);
        
        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);
        l7.setFont(f);
        l8.setFont(f);
        l9.setFont(f);
        l.setFont(f);
        
        
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();
        
        t1.setFont(f);
        t2.setFont(f);
        t3.setFont(f);
        t4.setFont(f);
        t5.setFont(f);
        t6.setFont(f);
        
        ch1=new Choice();
        ch1.add("Male");
        ch1.add("Female");
        
        ch1.setFont(f);
        
        ch2=new Choice();
        try{
            Connection_Class obj = new Connection_Class();
            String q ="Select Eid from new_employee";
            ResultSet rest =obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch2.add(rest.getString("Eid"));
            }
        }
        catch(SQLException ex)
        {
        }
        ch2.setFont(f);
        
        bt1=new JButton("Submit");
        bt2=new JButton("Close");
        bt3=new JButton("Confirm Eid");
        
        bt1.setFont(f);
        bt2.setFont(f);
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        bt3.setBackground(Color.WHITE);
        bt3.setForeground(Color.BLACK);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(11,2,10,10));
        p1.add(l9);
        p1.add(ch2);
        
        p1.add(l);
        p1.add(bt3);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(ch1);
  
        p1.add(l3);
        p1.add(t2);
        p1.add(l4);
        p1.add(t3);
        p1.add(l5);
        p1.add(t4);
        p1.add(l6);
        p1.add(t5);
        p1.add(l7);
        p1.add(t6);
        
        p1.add(bt1);
        p1.add(bt2);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.add(l8);
        
        setLayout(new BorderLayout(30,30));
        add(p1,"Center");
        add(p2,"West");
        
/*        try{
            int id=Integer.parseInt(ch2.getSelectedItem());
            
            Connection_class obj1 = new Connection_class();
            String q1 ="Select * from new_employee where Eid='"+id+"'";
            ResultSet rest1 =obj1.stm.executeQuery(q1);
            
            while(rest1.next())
            {
                t1.setText(rest1.getString("name"));
                ch1.add(rest1.getString("gender"));
                t2.setText(rest1.getString("address"));
                t3.setText(rest1.getString("state"));
                t4.setText(rest1.getString("city"));
                t5.setText(rest1.getString("email"));
                t6.setText(rest1.getString("phone"));
                
            }
        }
        catch(NumberFormatException | SQLException exx)
        {
        }*/
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            int id=Integer.parseInt(ch2.getSelectedItem());
            String name = t1.getText();
            String gender = ch1.getSelectedItem();
            String address = t2.getText();
            String state = t3.getText();
            String city = t4.getText();
            String email = t5.getText();
            int phone = Integer.parseInt(t6.getText());
            
            try
            {
                Connection_Class obj = new Connection_Class();
                String q ="update new_employee set name='"+name+"',gender='"+gender+"',address='"+address+"',state='"+state+"',city='"+city+"',email='"+email+"',phone='"+phone+"' where Eid='"+id+"'";           
                obj.stm.executeUpdate(q);                
                JOptionPane.showMessageDialog(null, "Record Updated");
                setVisible(false);
                setVisible(true);
            }
            catch(HeadlessException | SQLException ex)
            {
            }
        } 
        else if(e.getSource()==bt2)
        {
            
            JOptionPane.showMessageDialog(null, "areyou sure");
            setVisible(false);
        }
        else{
            try{
            int id=Integer.parseInt(ch2.getSelectedItem());
            
            Connection_Class obj1 = new Connection_Class();
            String q1 ="Select * from new_employee where Eid='"+id+"'";
            ResultSet rest1 =obj1.stm.executeQuery(q1);
            
            while(rest1.next())
            {
                t1.setText(rest1.getString("name"));
                ch1.add(rest1.getString("gender"));
                t2.setText(rest1.getString("address"));
                t3.setText(rest1.getString("state"));
                t4.setText(rest1.getString("city"));
                t5.setText(rest1.getString("email"));
                t6.setText(rest1.getString("phone"));
                
            }
        }
        catch(NumberFormatException | SQLException exx)
        {
        }
            
        }
    }
    public static void main(String args[])
    {
        new Update_Employee().setVisible(true);
    }    
}




















































