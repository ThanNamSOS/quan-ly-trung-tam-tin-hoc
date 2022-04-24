
package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class JDBC {
     private static String DB_URL = "jdbc:mysql://localhost:3306/FPT_DaoTao";
    private static String USER_NAME = "root";
    private static String PASSWORD = "123456";
    public static Connection getConnection(){
        try {
            DriverManager.deregisterDriver(new com.mysql.cj.jdbc.Driver());
            Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            return connection;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kết nối CSDL thất bại");
           
        }
        return null;
    }
    
    
    
}
