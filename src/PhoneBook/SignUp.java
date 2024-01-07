package PhoneBook;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
/**
 *
 * @author Devanshu
 */
public class SignUp extends JFrame implements ActionListener{
    
    JLabel name_l,password_l;
    JButton submit_b;
    JTextField name_tf,password_tf;
    JButton login_b,create_account_b;
    JLabel existing_user,newUser,phone_l;
    JPanel welcome;
    
    Font f;
    
    SignUp(){
        
        // welcome-panel
        welcome = new JPanel();
        welcome.setVisible(true);
        welcome.setLayout(null);
        welcome.setBackground(Color.YELLOW);

        f = new Font("Aerial",Font.BOLD,30);
        phone_l = new JLabel("Phone-Book");
        phone_l.setFont(f);
        phone_l.setBounds(220,100,200,100);
        
        existing_user = new JLabel("Are you an existing user?");
        existing_user.setBounds(235,200,150,50);
        login_b = new JButton("Login");
        login_b.addActionListener(this);
        login_b.setBounds(260,250,80,50);

        newUser = new JLabel("New User?");
        newUser.setBounds(270,350,150,50);
        create_account_b = new JButton("Create an Account");
        create_account_b.addActionListener(this);
        create_account_b.setBounds(210,400,180,50);

        welcome.add(phone_l);
        welcome.add(existing_user);
        welcome.add(login_b);
        welcome.add(newUser);
        welcome.add(create_account_b);
        
        add(welcome);
        setResizable(false);
        setSize(630,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login_b){
            this.setVisible(false);
            new Login().setVisible(true);
        }
        if(ae.getSource() == create_account_b){
            this.setVisible(false);
            new CreateAccount().setVisible(true);
        }
 
    }
    
    public static void main(String[] args){
        new SignUp().setVisible(true);
    }
    
}
