package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    public static String driver="oracle.jdbc.driver.OracleDriver";
    public static String url="jdbc:oracle:thin:@192.168.1.231:1521:orcl";
    public static String user="dkpps2";
    public static String pwd="dkpps";
    
    public static Connection getConnection(){
        try {
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url, user, pwd);
            return con;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static void close(Connection con,Statement stm,ResultSet rs){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(stm!=null){
            try {
                stm.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
