package Payroll;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login_Page extends JFrame implements ActionListener 
{
    JLabel l1,l2,l3;
    JButton bt1,bt2;
    JTextField tf1;
    JPasswordField pf;
    JPanel p1;;
    Font f;
    
    Login_Page()
    {
        super("login page");
        setSize(600,200);
        setLocation(100,100);
        setResizable(false);
    //    setUndecorated(true);
        f = new Font("arial",Font.BOLD,14);
        l1 = new JLabel("UserName");
        l2 = new JLabel("Password");
        
        l1.setFont(f);
        l2.setFont(f);
        
        tf1 = new JTextField();
        tf1.setFont(f);
        
        pf = new JPasswordField();
        
        bt1 = new JButton("LOGIN");
        bt2 = new JButton();
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt1.setFont(f);
        bt2.setFont(f);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(3,2,10,10));
        
        p1.add(l1);
        p1.add(tf1);
        p1.add(l2);
        p1.add(pf);
        p1.add(bt1);
        
        ImageIcon img;
        img = new ImageIcon("C:\\Users\\revan\\Documents\\NetBeansProjects\\Payroll\\src\\Payroll\\login.png");
        Image image = img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imgl=new ImageIcon(image);
        l3 =new JLabel(imgl);
        add(l3,"West");
        add(p1,"Center");
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String u_name=tf1.getText();
            String p_name;
            p_name = pf.getText();
            try
            {
                Connection_Class obj=new Connection_Class();
                String q="select * from login where username='"+u_name+"' and password='"+p_name+"'";
                ResultSet res=obj.stm.executeQuery(q);
                if(res.next())
                {
                    new Home_Payroll().setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"invalid username or passsword");
                    this.setVisible(false);
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==bt2)
        {
            JOptionPane.showMessageDialog(null,"Are you sure");
            setVisible(false);
        }
    }
    public static void main(String args[])
    {
        new Login_Page().setVisible(true);
    }
    
}






