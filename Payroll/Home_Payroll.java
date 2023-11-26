package Payroll;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Home_Payroll extends JFrame implements ActionListener 
{
    JLabel ll;
    Font f;
    Home_Payroll()
    {
        super("Home Page");
        setSize(1600,690);
        setLocation(1,1);
        f = new Font("arial",Font.BOLD,14);
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Employee");
        JMenu m2 = new JMenu("Update");
        JMenu m3 = new JMenu("Attendance");
        JMenu m4 = new JMenu("Exit");
        
        m1.setFont(f);
        m2.setFont(f);
        m3.setFont(f);
        m4.setFont(f);
        
        JMenuItem mt1 = new JMenuItem("New Employee");
        ImageIcon img1 = new ImageIcon("C:\\Users\\revan\\Documents\\NetBeansProjects\\Payroll\\src\\Payroll\\home.jpeg");
        Image image = img1.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(image);
        mt1.setIcon(img2);
        mt1.setMnemonic('Y');
        mt1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
        mt1.addActionListener(this);
        
        JMenuItem mt2 = new JMenuItem("Salary");
        ImageIcon img3 = new ImageIcon("C:\\Users\\revan\\Documents\\NetBeansProjects\\Payroll\\src\\Payroll\\home.jpeg");
        Image image1 = img3.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon img4 = new ImageIcon(image1);
        mt2.setIcon(img4);
        mt2.setMnemonic('S');
        mt2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
        mt2.addActionListener(this);
        
        JMenuItem mt3 = new JMenuItem("List Employee");
        ImageIcon img5 = new ImageIcon("C:\\Users\\revan\\Documents\\NetBeansProjects\\Payroll\\src\\Payroll\\home.jpeg");
        Image image3 = img5.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon img6 = new ImageIcon(image3);
        mt3.setIcon(img6);
        mt3.setMnemonic('I');
        mt3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
        mt3.addActionListener(this);
        //Update Menu
        JMenuItem mt4 = new JMenuItem("Update Employee");
        ImageIcon img7 = new ImageIcon("C:\\Users\\revan\\Documents\\NetBeansProjects\\Payroll\\src\\Payroll\\home.jpeg");
        Image image4 = img7.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon img8 = new ImageIcon(image4);
        mt4.setIcon(img8);
        mt4.setMnemonic('U');
        mt4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
        mt4.addActionListener(this);
        
        JMenuItem mt5 = new JMenuItem("Update Salary");
        ImageIcon img9 = new ImageIcon("C:\\Users\\revan\\Documents\\NetBeansProjects\\Payroll\\src\\Payroll\\home.jpeg");
        Image image5 = img9.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon img10 = new ImageIcon(image5);
        mt5.setIcon(img10);
        mt5.setMnemonic('Y');
        mt5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
        mt5.addActionListener(this);
        //attendance Menu.......
        JMenuItem mt6 = new JMenuItem("Take Attendance");
        ImageIcon img11 = new ImageIcon("C:\\Users\\revan\\Documents\\NetBeansProjects\\Payroll\\src\\Payroll\\home.jpeg");
        Image image6 = img11.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon img12 = new ImageIcon(image6);
        mt6.setIcon(img12);
        mt6.setMnemonic('A');
        mt6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
        mt6.addActionListener(this);
        
        JMenuItem mt7 = new JMenuItem("Attendance Review");
        ImageIcon img13 = new ImageIcon("C:\\Users\\revan\\Documents\\NetBeansProjects\\Payroll\\src\\Payroll\\home.jpeg");
        Image image7 = img13.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon img14 = new ImageIcon(image7);
        mt7.setIcon(img14);
        mt7.setMnemonic('T');
        mt7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
        mt7.addActionListener(this);
        
        JMenuItem mt8 = new JMenuItem("Generate PaySlip");
        ImageIcon img15 = new ImageIcon("C:\\Users\\revan\\Documents\\NetBeansProjects\\Payroll\\src\\Payroll\\home.jpeg");
        Image image8 = img15.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon img16 = new ImageIcon(image8);
        mt8.setIcon(img16);
        mt8.setMnemonic('G');
        mt8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
        mt8.addActionListener(this);
        
        JMenuItem mt9 = new JMenuItem("Exit");
        ImageIcon img17 = new ImageIcon("C:\\Users\\revan\\Documents\\NetBeansProjects\\Payroll\\src\\Payroll\\home.jpeg");
        Image image9 = img17.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon img18 = new ImageIcon(image9);
        mt9.setIcon(img18);
        mt9.setMnemonic('X');
        mt9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
        mt9.addActionListener(this);
        
        JMenuItem mt10 = new JMenuItem("Delete Employee");
        ImageIcon img22 = new ImageIcon("C:\\Users\\revan\\Documents\\NetBeansProjects\\Payroll\\src\\Payroll\\home.jpeg");
        Image image11 = img22.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon img21 = new ImageIcon(image11);
        mt10.setIcon(img21);
        mt10.setMnemonic('A');
        mt10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
        mt10.addActionListener(this);
        
        mt1.setFont(f);
        mt2.setFont(f);
        mt3.setFont(f);
        mt4.setFont(f);
        mt5.setFont(f);
        mt6.setFont(f);
        mt7.setFont(f);
        mt8.setFont(f);
        mt9.setFont(f);
        
        m1.add(mt1);
        m1.add(mt2);
        m1.add(mt3);
        //m1.add(mt8);
        
        
        m2.add(mt4);
        m2.add(mt5);
        m2.add(mt10);
        
        m3.add(mt6);
        m3.add(mt7);
        m3.add(mt8);
        
        m4.add(mt9);
        
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        
        ImageIcon img19 = new ImageIcon("C:\\Users\\revan\\Documents\\NetBeansProjects\\Payroll\\src\\Payroll\\home.jpeg");
        Image image10 = img19.getImage().getScaledInstance(1600,690,Image.SCALE_DEFAULT);
        ImageIcon img20 = new ImageIcon(image10);
        ll = new JLabel(img20);
        
        setJMenuBar(mb);
        add(ll);
    }
    public void actionPerformed(ActionEvent e)
    {
        String comnd = e.getActionCommand();
        switch (comnd) {
            case "New Employee":
                new New_Employee().setVisible(true);
                break;
            case "Salary":
                new Salary().setVisible(true);
                break;
            case "List Employee":
                new List_Employee().setVisible(true);
                break;
            case "Update Employee":
                new Update_Employee().setVisible(true);
                break;
            case "Update Salary":
                new Update_Salary().setVisible(true);
                break;
            case "Delete Employee":
                new Delete_Employee().setVisible(true);
                break;
            case "Take Attendance":
                new Take_Attendance().setVisible(true);
                break;
            case "Generate Payslip":
                new Generate_PaySlip().setVisible(true);
                break;
            case "Attendance Review":
                new Attendance_Salary().setVisible(true);
                break;
            
            case "Exit":
                System.exit(0);
            default:
                new Generate_PaySlip().setVisible(true);
                
                setVisible(false);
                break;
        }
    }
    public static void main(String args[])
    {
        new Home_Payroll().setVisible(true);
    }
    
}






















