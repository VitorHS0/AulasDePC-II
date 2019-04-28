package mysqlconnectiontest;
import java.sql.*;

public class JdbcUtil {
    private static Connection conn;
    private static String strConn = "jdbc:mysql://localhost:3306/bancojava?autoReconnect=true&useSSL=false"; 
    
    
    public static Connection getConnection() throws Exception{
    Class.forName("com.mysql.jdbc.Driver");
        if(JdbcUtil.conn != null){
            return JdbcUtil.conn;
        }
        else{
            JdbcUtil.conn = DriverManager.getConnection(strConn, "root", "");
            return JdbcUtil.conn;
        }
        
        }
    
}
