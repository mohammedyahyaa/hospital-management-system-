package database_conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase_Connection {

    private static Connection connect;
    
    
    

    public static Connection getconnection() {
        if (connect == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
 
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBase_Connection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataBase_Connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connect;
    }

    public static void disconnect() {
        if (connect != null) {

            connect = null;
        }

    }

    public static void main(String[] args) {
        new DataBase_Connection().getconnection();
         if (connect != null) {
        System.out.println("Connected");
    }
    }
}
