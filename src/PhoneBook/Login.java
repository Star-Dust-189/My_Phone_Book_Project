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
public class Login extends JFrame implements ActionListener{
    
    Scanner scanner = new Scanner(System.in);

    // Panels
    JPanel login,p;

    // login-panel_Elements
    JLabel name_l,password_l,login_label;
    JButton submit_b;
    JTextField name_tf,password_tf;
    Font f;

    Login(){

        //login - panel
        login = new JPanel();
        login.setLayout(null);
        login.setBackground(Color.YELLOW);
        
        f = new Font("Aerial",Font.BOLD,30);
        login_label = new JLabel("LOGIN");
        login.setForeground(Color.red);
        login_label.setFont(f);
        login_label.setBounds(250,100,100,60);
        
        name_l = new JLabel("Enter Your Username : ");
        //name_l.setForeground(Color.red);
        name_l.setBounds(130,210,150,30);

        name_tf = new JTextField();
        name_tf.setBounds(280,210,200,30);

        password_l = new JLabel("Enter Your Password : ");
        password_l.setBounds(130,280,150,30);
        //password_l.setForeground(Color.red);

        password_tf = new JTextField();
        password_tf.setBounds(280,280,200,30);

        submit_b = new JButton("SUBMIT");
        submit_b.setBounds(230,380,100,50);
        submit_b.addActionListener(this);

        login.add(name_l);
        login.add(name_tf);
        login.add(password_l);
        login.add(password_tf);
        login.add(submit_b);
        login.add(login_label);
        
        setSize(630,600);
        add(login);
    }

    public void actionPerformed(ActionEvent ae){
        
        String username = name_tf.getText();
        String password = password_tf.getText();
        
        if(ae.getSource() == submit_b){
            try{
                
                ConnectionClass obj = new ConnectionClass();
                String g = "select * from login where Username ='"+username+"'and password = '"+password+"'";
                ResultSet rest = obj.stm.executeQuery(g);
                
                if(rest.next()){
                    new Home().setVisible(true);
                    login.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Your Credentials does not match with the record!!!");
                }
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
