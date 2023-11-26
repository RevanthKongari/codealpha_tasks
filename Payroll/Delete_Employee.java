package Payroll;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Delete_Employee extends JFrame implements ActionListener 
{
    JLabel l2;
    JButton bt1;
    
    Choice ch;
    JPanel p1;;
    Font f;
    
    Delete_Employee()
    {
        super("Generate Pay Slip");
        setSize(500,500);
        setLocation(100,100);        
        setResizable(false);
        
        f=new Font("Arial",Font.BOLD,16);
        l2=new JLabel("Employee ID ");
        l2.setFont(f);
        ch=new Choice();
        try
        {
            Connection_Class obj = new Connection_Class();
            String q ="select * from new_employee";
            ResultSet rest =obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch.add(rest.getString("Eid"));
            }
        }
        catch(SQLException ex)
        {
        } 
        bt1=new JButton("SUBMIT");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.addActionListener(this);
        bt1.setFont(f);
        
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,3,10,10));
        
        p1.add(l2);
        p1.add(ch);
        p1.add(bt1);
        setLayout(new BorderLayout());
        
        add(p1,"South");
    
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            try
            {
                int id=Integer.parseInt(ch.getSelectedItem());
                Connection_Class obj = new Connection_Class();
                String q ="delete from new_employee where Eid='"+id+"'";
                obj.stm.executeUpdate(q);
                
                String r ="delete from salary where Eid='"+id+"'";
                obj.stm.executeUpdate(r);
                
                
                String s ="delete from attendance where Eid='"+id+"'";
                obj.stm.executeUpdate(r);
                JOptionPane.showMessageDialog(null, "record deleted successfully");
                setVisible(false);
                setVisible(true);
            }
            catch(Exception exx)
            {
                exx.printStackTrace();
            }         
        }
    }

    public static void main (String args[])
    {
        new Delete_Employee().setVisible(true);
    }
}
