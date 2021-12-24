package Home.dao;
import Home.utilities.*;

import java.io.NotSerializableException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Home.model.*;

import javax.sql.rowset.serial.SerialException;
import javax.swing.*;

public class imageDAO
{
    Connection con=db.connect();
    String query ;
    PreparedStatement statement ;


    public imageDAO() throws SQLException, ClassNotFoundException {
    }



    public void createimage(imageModel imageobj) throws SQLException, ClassNotFoundException, SerialException, NotSerializableException
    {
        query="INSERT INTO `img`(`im`, `name`, `phone`) VALUES (?,?,?)";
        statement=con.prepareStatement(query);
        statement.setString(1,imageobj.getImg());
        statement.setString(2,imageobj.getName());
        statement.setString(3,imageobj.getPhone());
        int result=statement.executeUpdate();

        if (result==1)
        {
            JOptionPane.showMessageDialog(null,"saved successfully");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"something went wrong");

        }



    }
}
