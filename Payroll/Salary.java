package Payroll;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Salary extends JFrame implements ActionListener 
{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6;
    Choice ch1;
    JButton bt1,bt2;
    JPanel p1,p2;
    Font f;
    Salary()
    {
        super("Salary");
        setLocation(100,100);
        setSize(740,380);
        setResizable(false);
        
        l1 = new JLabel("Employee ID");
        
        l2 = new JLabel("HRA");
        l3 = new JLabel("DA");
        l4 = new JLabel("MID");
        l5 = new JLabel("PF");
        l6 = new JLabel("basic Salary");
        
        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);
        
        ch1 = new Choice();
        try
        {
            Connection_Class obj = new Connection_Class();
            String q ="Select Eid from new_employee";
            ResultSet rest =obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch1.add(rest.getString("Eid"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        ch1.setFont(f);
        
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
        
        //ImageIcon img = new ImageIcon("C:\\Users\\revan\\Documents\\NetBeansProjects\\Payroll\\src\\Payroll\\login.png");
        //Image image = img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        //ImageIcon img2=new ImageIcon(image);
        //l7 =new JLabel(img2);
        
        bt1 = new JButton("Submit");
        bt2 = new JButton("Close");
        
        bt1.setFont(f);
        bt2.setFont(f);
        
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
         
        p1 = new JPanel();
        p1.setLayout(new GridLayout(8,2,10,10));
        
        p1.add(l1);
        p1.add(ch1);
        p1.add(l2);
        p1.add(t1);
        p1.add(l3);
        p1.add(t2);
        p1.add(l4);
        p1.add(t3);
        p1.add(l5);
        p1.add(t4);
        p1.add(l6);
        p1.add(t5);
        p1.add(bt1);
        p1.add(bt2);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,1,11,11));
        //p2.add(l7);
        
        setLayout(new BorderLayout(30,30));
        add(p1,"Center");
        add(p2,"West");
                    
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            
            int Eid=Integer.parseInt(ch1.getSelectedItem());
            float hra = Float.parseFloat(t1.getText());
            float da = Float.parseFloat(t2.getText());
            float mid = Float.parseFloat(t3.getText());
            float pf = Float.parseFloat(t4.getText());
            float basic= Float.parseFloat(t5.getText());
            try
            {
                Connection_Class obj1 = new Connection_Class();
                String q ="insert into salary values('"+Eid+"','"+hra+"','"+da+"','"+mid+"','"+pf+"','"+basic+"')";
                obj1.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "data insert successfully");
                setVisible(false);
            }
            catch(Exception exx)
            {
                exx.printStackTrace();
            }
         
        }
        if(e.getSource()==bt2)
        {
            JOptionPane.showMessageDialog(null, "Are you sure");
             setVisible(false);
        }
    }
    public static void main(String args[])
    {
        new Salary().setVisible(true);
    }
    
    
}
























