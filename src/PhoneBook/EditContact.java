package PhoneBook;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Devanshu
 */
public class EditContact extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6;
    JButton b1,b2;
    JPanel p1,p2;
    JTextField tf1,tf2,tf3,tf4,tf5;
    Font f,f1;
    
    EditContact(){
        
    }
    
    EditContact(int idnum){
        
        super("Edit Contact");
        setLocation(450,50);
        setSize(450,650);
        
        f = new Font("Aerial",Font.BOLD,25);
        f1 = new Font("Aerial",Font.BOLD,15);
        
        l1 = new JLabel(" Name :");
        l2 = new JLabel(" Phone NO. :");
        l3 = new JLabel(" Email Address :");
        l4 = new JLabel(" Home Address :");
        l6 = new JLabel(" ID :");
    
        
        l5 = new JLabel("Update Contact");
        l5.setFont(f);
        l5.setHorizontalAlignment(JLabel.CENTER);
        
        l1.setFont(f1);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l6.setFont(f1);
            
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf5.setEditable(false);
        
        b1 = new JButton("Update Contact");
        b1.addActionListener(this);
        b2 = new JButton("Back");
        b2.addActionListener(this);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.setBackground(Color.YELLOW);
        p1.add(l5);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(6,2,10,10));
        p2.setBackground(Color.ORANGE);
        p2.add(l6);
        p2.add(tf5);
        p2.add(l1);
        p2.add(tf1);
        p2.add(l2);
        p2.add(tf2);
        p2.add(l3);
        p2.add(tf3);
        p2.add(l4);
        p2.add(tf4);
        p2.add(b1);
        p2.add(b2);
        
        try{
            ConnectionClass obj1 = new ConnectionClass();
            String g1 = "select * from addc_contact where ID='"+idnum+"'";
            ResultSet rest1 = obj1.stm.executeQuery(g1);
            while(rest1.next()){
                tf5.setText(rest1.getString("ID"));
                tf1.setText(rest1.getString("name"));
                tf2.setText(rest1.getString("phone"));
                tf3.setText(rest1.getString("email"));
                tf4.setText(rest1.getString("address"));  
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        //tf5.setEditable(false);
        setLayout(new BorderLayout(3,3));
        add(p1,"North");
        add(p2,"Center");
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1){
            
            int cid = Integer.parseInt(tf5.getText());
            String name = tf1.getText();
            String phone = tf2.getText();
            String email = tf3.getText();
            String address = tf4.getText();
            
            try{
                if(ae.getSource() == b1){
                    ConnectionClass obj2 = new ConnectionClass();
                    String g2 = "update addc_contact set name='"+name+"', phone='"+phone+"', email='"+email+"', address='"+address+"' where ID='"+cid+"' ";
                    int aa = obj2.stm.executeUpdate(g2);
                    if(aa == 1){
                        JOptionPane.showMessageDialog(null, " Contact Successfully Updated :) ");
                        this.setVisible(false);
                        //new SearchDataTableForEdit(name).setVisible(true);
                        new ShowContact().setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null," *Please Fill the Contact Details Carefully !!! ");
                    }
                }   
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
        if(ae.getSource() == b2){
            this.setVisible(false);
            new Home().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new EditContact().setVisible(true);
    }
    
}
