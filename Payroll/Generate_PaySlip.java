package Payroll;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Generate_PaySlip extends JFrame implements ActionListener
{
    JLabel l2;
    JButton bt1;
    JTextArea ta;
    Choice ch;
    JPanel p1;;
    Font f;
    int attend;
    
    Generate_PaySlip()
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
        bt1=new JButton("Print");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.addActionListener(this);
        bt1.setFont(f);
        
        ta=new JTextArea();
        JScrollPane sp=new JScrollPane(ta);
        ta.setEditable(false);
        ta.setFont(f);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,3,10,10));
        
        p1.add(l2);
        p1.add(ch);
        p1.add(bt1);
        setLayout(new BorderLayout());
        add(sp,"Center");
        add(p1,"South");
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            ta.setText("----------------Pay Slip----------------");
            try
            {
                Connection_Class obj1 = new Connection_Class();
                int id=Integer.parseInt(ch.getSelectedItem());
                String q1= "select * from new_employee where Eid="+id+" ";
                ResultSet rest1=obj1.stm.executeQuery(q1);
                
                while(rest1.next())
                {
                    int a =Integer.parseInt(rest1.getString("Eid"));
                  
                    ta.append("\n\nEmployee Id  : "+a);
                    ta.append("\nEmployee Name : "+rest1.getString("name"));
                    ta.append("\n------------------------------------------\n\n");
                }
                String q3="select count(Eid) from attendance where first_half=\"present\" and Eid='"+id+"' ";
                ResultSet rest = obj1.stm.executeQuery(q3);
                while(rest.next())
                {
                    //attended days
                    attend = rest.getInt("count(Eid)");
                    
                    ta.append("\nNo of days present"+attend);
                    
                }
                String q4="select count(Eid) from attendance where Eid='"+id+"' ";
                ResultSet rest3 = obj1.stm.executeQuery(q4);
                while(rest3.next())
                {
                    //total working days
                    ta.append("\nOut of total working days : "+rest3.getString("count(Eid)"));
                    
                }
                Connection_Class obj=new Connection_Class();
                String q2="select * from salary where Eid='"+id+"' ";
                ResultSet rest2=obj.stm.executeQuery(q2);
                while(rest2.next())
                {
                    
                    float i = rest2.getFloat("basis");
                    float hra=rest2.getFloat("hra");
                    float da=rest2.getFloat("da");
                    float pf=rest2.getFloat("pf");
                    float mid=rest2.getFloat("mid");
                    float t=(i/360)*attend;
                    float hr=(hra%i);
                    float d=(da%i);
                    float p=(pf%i);
                    float m=(mid%i);
                    float total=t+hr+d+p+m;
                    double tax=(total*2.1)/100;
                    ta.append("\nTax 2.1% of salary : "+tax);
                    ta.append("\nHRA   : "+hr);
                    ta.append("\nDA  : "+d);
                    ta.append("\nMED : "+m);
                    ta.append("\nPF : "+p);
                    ta.append("\nSALARY TILL TODAY: "+t);
                    ta.append("\nBASIS SALARY : "+Float.parseFloat(rest2.getString("basis")));
                    
                    ta.append("\n----------------------------------------------------------\n\n");
                    ta.append("\nGross Salary : "+total);
                    ta.append("\nTotal : "+total);
                    
                }
                ta.print();
            }
            catch(NumberFormatException | SQLException exx)
            {
            } catch (PrinterException ex) {
                Logger.getLogger(Generate_PaySlip.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void main (String args[])
    {
        new Generate_PaySlip().setVisible(true);
    }
}





















































