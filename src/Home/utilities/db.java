package Home.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db
{

    private static String  driver ="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://localhost/image";
    private static String name="root";
    private static String password="";
    private static Connection con;

    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        con= DriverManager.getConnection(url,name,password);
        return con;
    }



}
