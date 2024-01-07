package PhoneBook;

        
import java.sql.*;
/**
 *
 * @author Devanshu
 */
public class ConnectionClass {

    Connection con;
    Statement stm;

    public ConnectionClass(){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PhoneBook","root","");
             stm = con.createStatement();
         }catch(Exception ex){
             ex.printStackTrace();
         }
    }

    public static void main(String args[]){
        new ConnectionClass();
    }

}
