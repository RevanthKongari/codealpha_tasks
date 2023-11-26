package Payroll;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Update_Salary extends JFrame implements ActionListener 
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5;
    Choice ch1;
    JButton bt1,bt2,bt3;
    JPanel p1,p2;
    Font f;
    Update_Salary()
    {
        super("Salary");
        setLocation(100,100);
        setSize(740,380);
        setResizable(false);
        
        f=new Font("Arial",Font.BOLD,14);
        
        l1 = new JLabel("Select ID");
        l2 = new JLabel("HRA");
        l3 = new JLabel("DA");
        l4 = new JLabel("MID");
        l5 = new JLabel("PF");
        l6 = new JLabel("Basic Salary");
        l8= new JLabel("");
        
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
            String q ="Select Eid from salary";
            ResultSet rest =obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch1.addItem(rest.getString("Eid"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
       
        
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        
        t1.setFont(f);
        t2.setFont(f);
        t3.setFont(f);
        t4.setFont(f);
        t5.setFont(f);
        
        ImageIcon img = new ImageIcon("C:\\Users\\revan\\Documents\\NetBeansProjects\\Payroll\\src\\Payroll\\login.png");
        Image image = img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(image);
        l7 =new JLabel(img2);
        
        bt1 = new JButton("Submit");
        bt2 = new JButton("Close");
        bt3 = new JButton("Confirm Employee ID");
        
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
        p1.setLayout(new GridLayout(8,2,10,10));
        p1.add(l1);
        p1.add(ch1);
        p1.add(l8);
        p1.add(bt3);
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
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.add(l7);
        
        setLayout(new BorderLayout(30,30));
        add(p1,"Center");
        add(p2,"West");
        
        //int id=Integer.parseInt(ch1.getSelectedItem());
        
/*        try
        {
            int id=Integer.parseInt(ch1.getSelectedItem());
            Connection_class obj1=new Connection_class();
            
            String q1="select * from salary where Eid='"+id+"'";
            ResultSet rest1=obj1.stm.executeQuery(q1);
            
            
            while(rest1.next())
            {
                t1.setText(rest1.getString("hra"));
                t2.setText(rest1.getString("da"));
                t3.setText(rest1.getString("mid"));
                t4.setText(rest1.getString("pf"));
                t5.setText(rest1.getString("basis"));
            }
        }
        catch(Exception exx){
            exx.printStackTrace();
        }  */     
    }
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource()==bt1)
        {
            int id=Integer.parseInt(ch1.getSelectedItem());
            float hra = Float.parseFloat(t1.getText());
            float da = Float.parseFloat(t2.getText());
            float mid = Float.parseFloat(t3.getText());
            float pf = Float.parseFloat(t4.getText());
            float basic= Float.parseFloat(t5.getText());
            try
            {
                Connection_Class obj = new Connection_Class();
                String q ="update salary set hra='"+hra+"',da='"+da+"',mid='"+mid+"',pf='"+pf+"',basis='"+basic+"'where Eid='"+id+"'";
                obj.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "data updated successfully");
                setVisible(false);
                setVisible(true);
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
        if(e.getSource()==bt3)
        {           
            try
            {
                int id=Integer.parseInt(ch1.getSelectedItem());
                Connection_Class obj1=new Connection_Class();
            
                String q1="select * from salary where Eid='"+id+"'";
                ResultSet rest1=obj1.stm.executeQuery(q1);
            
            
                while(rest1.next())
                {
                    t1.setText(rest1.getString("hra"));
                    t2.setText(rest1.getString("da"));
                    t3.setText(rest1.getString("mid"));
                    t4.setText(rest1.getString("pf"));
                    t5.setText(rest1.getString("basis"));
                }
            }
            catch(Exception exx){
                exx.printStackTrace();
            }
                        
        }
    }
    public static void main(String args[])
    {
        new Update_Salary().setVisible(true);
    }
}
    

