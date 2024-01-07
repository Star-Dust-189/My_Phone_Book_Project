package PhoneBook;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Devanshu
 */
public class EntryData extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5;
    JButton b1,b2;
    JPanel p1,p2;
    JTextField tf1,tf2,tf3,tf4;
    Font f;

    EntryData(){
        
        super("Add Contact");
        setLocation(450,50);
        setSize(450,650);
        
        f = new Font("Aerial",Font.BOLD,20);
        l5 = new JLabel("Add Contact",JLabel.CENTER);
        l5.setFont(f);
        
        l1 = new JLabel("   Name :");
        l2 = new JLabel("   Phone NO. :");
        l3 = new JLabel("   Email Address :");
        l4 = new JLabel("   Home Address :");
        
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        
        b1 = new JButton("Add To Contact");
        b1.addActionListener(this);
        b2 = new JButton("Back");
        b2.addActionListener(this);
        
        p1 = new JPanel();
        p1.setBackground(Color.ORANGE);
        p1.setLayout(new GridLayout(5,2,10,10));
        p1.add(l1);
        p1.add(tf1);
        p1.add(l2);
        p1.add(tf2);
        p1.add(l3);
        p1.add(tf3);
        p1.add(l4);
        p1.add(tf4);

        p1.add(b1);
        p1.add(b2);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.setBackground(Color.YELLOW);
        p2.add(l5);
        
        setLayout(new BorderLayout(2,2));
        add(p1,"Center");
        add(p2,"North");
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String name = tf1.getText();
        String phone = tf2.getText();
        String email = tf3.getText();
        String address = tf4.getText();
        
        try{
            if(ae.getSource() == b1){
            ConnectionClass obj = new ConnectionClass();
            String g = "insert into addc_contact(name,phone,email,address) value('"+name+"','"+phone+"','"+email+"','"+address+"')";
            int aa = obj.stm.executeUpdate(g);
            if(aa == 1){
                JOptionPane.showMessageDialog(null, " Contact Successfully Added :) ");
                this.setVisible(false);
                new Home().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null," Please Fill the Contact Details Carefully !!! ");
            }
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        if(ae.getSource() == b2){
            this.setVisible(false);
            new Home().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new EntryData().setVisible(true);
    }
}
