package PhoneBook;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Devanshu
 */
public class Home extends JFrame implements ActionListener{
    
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b0;
    JPanel p1,p2;
    
    Font font1,font2;
    
    Home(){
        
        super("Home Section");
        setLocation(450,250);
        setSize(450,400);
        
        font1 = new Font("Aerial",Font.BOLD,20);
        font2 = new Font("Aerial",Font.BOLD,15);
        
        l1 = new JLabel("Phone-Book",JLabel.CENTER);
        l1.setForeground(Color.BLUE);
        
        b0 = new JButton("Show Contacts");
        b1 = new JButton("Add Contact");
        b2 = new JButton("Search");
        b3 = new JButton("Delete");
        b4 = new JButton("Edit");
        b5 = new JButton("Exit");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b0.addActionListener(this);
        
        l1.setFont(font1);
        b0.setFont(font2);
        b1.setFont(font2);
        b2.setFont(font2);
        b3.setFont(font2);
        b4.setFont(font2);
        b5.setFont(font2);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(6,1,10,10));
        p1.add(b0);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.setBackground(Color.YELLOW);
        p2.add(l1);
        
        setLayout(new BorderLayout(2,2));
        add(p2,"North");
        add(p1,"Center");
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b0){
            new ShowContact().setVisible(true);
        }
        
        if(ae.getSource() == b1){
            this.setVisible(false);
            new EntryData().setVisible(true);
        }
        
        if(ae.getSource() == b2){
            this.setVisible(false);
            new SearchData().setVisible(true);
        }
        
        if(ae.getSource() == b3){
            this.setVisible(false);
            new DeleteContact().setVisible(true);
        }
        
        if(ae.getSource() == b4){
            this.setVisible(false);
            new SearchNameForEdit().setVisible(true);
        }
        
        if(ae.getSource() == b5){
            System.exit(0);   
        }
    }
    

    
    public static void main(String[] args){
        new Home().setVisible(true);
    }
    
}
