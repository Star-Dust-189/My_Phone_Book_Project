package PhoneBook;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Scanner;
/**
 *
 * @author Devanshu
 */
public class CreateAccount extends JFrame implements ActionListener{
    
    Scanner scanner = new Scanner(System.in);
    
    JPanel create_account_panel;
    JLabel name_l,password_l,create_account_panel_label;
    JButton create_account_b;
    JTextField name_tf,password_tf;
    Font f;
    
    CreateAccount(){
        //create_account_panel
       create_account_panel= new JPanel();
       create_account_panel.setLayout(null);
       create_account_panel.setBackground(Color.YELLOW);  
       f = new Font("Aerial",Font.BOLD,30);
       create_account_panel_label = new JLabel("Create Account");
       create_account_panel.setForeground(Color.red);
       create_account_panel_label.setFont(f);
       create_account_panel_label.setBounds(190,100,250,60);
        
        name_l = new JLabel("Set User Name : ");
        //name_l.setForeground(Color.red);
        name_l.setBounds(130,210,150,30);

        name_tf = new JTextField();
        name_tf.setBounds(280,210,200,30);

        password_l = new JLabel("Set Your Password : ");
        password_l.setBounds(130,280,150,30);
        //password_l.setForeground(Color.red);

        password_tf = new JTextField();
        password_tf.setBounds(280,280,200,30);

        create_account_b = new JButton("Create");
        create_account_b.setBounds(230,380,100,50);
        create_account_b.addActionListener(this);

       create_account_panel.add(name_l);
       create_account_panel.add(name_tf);
       create_account_panel.add(password_l);
       create_account_panel.add(password_tf);
       create_account_panel.add(create_account_b);
       create_account_panel.add(create_account_panel_label);
        
        setSize(630,600);
        add(create_account_panel);
    }
    
    public void actionPerformed(ActionEvent ae){
        String username = name_tf.getText();
        String password = password_tf.getText();
        //createAccount class code
        if(ae.getSource() == create_account_b){
            try{
                ConnectionClass obj = new ConnectionClass();
                String gh = "insert into login(username,password) value('"+username+"','"+password+"')";
                int aa = obj.stm.executeUpdate(gh);
                if(aa == 1){
                    JOptionPane.showMessageDialog(null, " Successfully Signed UP :) ");
                    this.setVisible(false);
                    new Login().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null," Failed!,To Sign UP :( ");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            this.setVisible(false);
        }    
    }
    
    public static void main(String[] args){
        new CreateAccount().setVisible(true);
    }
}
