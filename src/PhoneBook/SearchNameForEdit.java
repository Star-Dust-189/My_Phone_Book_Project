package PhoneBook;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Devanshu
 */
public class SearchNameForEdit extends JFrame implements ActionListener{
    
    JLabel l1,l2;
    JTextField tf;
    JButton b1,b2;
    Font f1,f2;
    JPanel p1,p2;
    
    SearchNameForEdit(){
        
        super("Search-Contact-To-Edit");
        setLocation(450,50);
        setSize(500,200);
        
        f1 = new Font("Aerial",Font.BOLD,25);
        f2 = new Font("Aerial",Font.BOLD,15);
        
        l1 = new JLabel("Search Contact To Edit");
        l2 = new JLabel("Enter Name :");
        
        tf = new JTextField();
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        b1 = new JButton("Search Contact");
        b1.addActionListener(this);
        b2 = new JButton("Back");
        b2.addActionListener(this);
        
        l1.setFont(f1);
        l2.setFont(f2);
        tf.setFont(f2);
        b1.setFont(f2);
        b2.setFont(f2);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.setBackground(Color.YELLOW);
        p1.add(l1);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(2,2,10,10));
        p2.add(l2);
        p2.add(tf);
        p2.add(b1);
        p2.add(b2);
        
        setLayout(new BorderLayout(10,20));
        add(p1,"North");
        add(p2,"Center");
    }
    
    
    
    public void actionPerformed(ActionEvent ae){
        String name = tf.getText();
        if(ae.getSource() == b1){
            try{
                
                ConnectionClass obj = new ConnectionClass();
                String g = "select name from addc_contact where name ='"+name+"'";
                ResultSet rest = obj.stm.executeQuery(g);
                
                if(rest.next()){
                    String name1 = rest.getString("name");
                    new SearchDataTableForEdit(name1).setVisible(true);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null," Contact Not Found :( ");
                    this.setVisible(false);
                    this.setVisible(true);
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
        new SearchNameForEdit().setVisible(true);
    }
    
}
