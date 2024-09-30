
package jframe;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mohammed Asloof
 */
public class DbConnection {
    private static String url = "jdbc:mysql://localhost:3306/library_management_system";
    private static String usr= "root";
    private static String pwd = "";
    
    public static Connection getconnection(){
      
        try {
            return DriverManager.getConnection(url,usr,pwd);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
     
    }
}
