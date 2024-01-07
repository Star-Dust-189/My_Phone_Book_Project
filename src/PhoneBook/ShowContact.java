package PhoneBook;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Devanshu
 */
public class ShowContact extends JFrame implements ActionListener{
    
    String x[] = {"ID","Name","Phone","Email","Address"};
    String y[][] = new String[20][5];
    int i=0,j=0;  
    JTable t;
    Font f;   
    JPanel p1;
    JButton b1;
    
    ShowContact(){
        super("Contact Information");
        setLocation(1,1);
        setSize(800,400);
        
        f = new Font("Aerial",Font.BOLD,14);
        try{
                
            ConnectionClass obj = new ConnectionClass();
            String g0 = "select * from addc_contact";
            ResultSet rest = obj.stm.executeQuery(g0);
                
            while(rest.next()){
                y[i][j++] = rest.getString("ID");
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("phone");
                y[i][j++] = rest.getString("email");
                y[i][j++] = rest.getString("address");
                i++;
                j = 0;
            }
            t = new JTable(y,x);
            t.setFont(f);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(t);
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.YELLOW);
        b1.addActionListener(this);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.setBackground(Color.YELLOW);
        p1.add(b1);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"South");
        add(sp,"Center");  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            this.setVisible(false);
            new Home().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new ShowContact().setVisible(true);
    }
}
