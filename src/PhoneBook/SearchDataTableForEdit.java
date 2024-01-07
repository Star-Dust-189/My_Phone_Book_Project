package PhoneBook;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author Devanshu
 */
public class SearchDataTableForEdit extends JFrame implements ActionListener{
    
    String x[] = {"ID","Name","Phone","Email","Address"};
    String y[][] = new String[20][5];
    
    int i=0,j=0;
    
    JTable t;
    Font f;
    
    JLabel l1;
    JTextField tf;
    JButton b1;
    JPanel p1;
    
    SearchDataTableForEdit(){
        
    }
    
    SearchDataTableForEdit(String name1){
        super("Update Contact Information");
        setLocation(1,1);
        setSize(800,400);
        
        f = new Font("Aerial",Font.BOLD,14);
        try{
                
            ConnectionClass obj = new ConnectionClass();
            String g = "select * from addc_contact where name ='"+name1+"'";
            ResultSet rest = obj.stm.executeQuery(g);
                
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
        
        l1 = new JLabel("Enter Contact ID : ");
        
        tf = new JTextField();
        
        b1 = new JButton("Edit");
        b1.addActionListener(this);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,3,10,10));
        p1.setBackground(Color.YELLOW);
        p1.add(l1);
        p1.add(tf);
        p1.add(b1);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"South");
        add(sp,"Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        int idnum = Integer.parseInt(tf.getText());
        if(ae.getSource() == b1){
            new EditContact(idnum).setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new SearchDataTableForEdit().setVisible(true);
    }
    
}
