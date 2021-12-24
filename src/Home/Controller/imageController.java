package Home.Controller;

import Home.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import Home.dao.*;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import Home.utilities.*;

public class imageController implements Serializable, Initializable
{
    @FXML
    private Button btnload;

    @FXML
    private Button btnopen;

    @FXML
    private ImageView imgview;

    @FXML
    private Button btninsert;


    @FXML
    private TextField txtphone;
    @FXML
    private TextField txtname;

    @FXML
    private TableView<imageModel> tblimage;
    @FXML
    private TableColumn<imageModel, String> colimg;

    @FXML
    private TableColumn<imageModel, String> colname;

    @FXML
    private TableColumn<imageModel, String> colphone;

    Connection con=db.connect();

    public imageController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    void insertFunction(ActionEvent event) throws FileNotFoundException, SQLException, ClassNotFoundException, NotSerializableException {
        imageModel imageobj=new imageModel();
        imageobj.setName(txtname.getText());
        imageobj.setPhone(txtphone.getText());
        imageobj.setImg(imgview.getImage().toString());

        //dao
        imageDAO imageDAOobj=new imageDAO();
        imageDAOobj.createimage(imageobj);

        imgTableShow();









    }






    public void initialize()
    {
        btnopen.setOnAction(e->{
            try {
                chooseFile();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

    }

    public void chooseFile() throws FileNotFoundException {
        System.out.println("open");

        FileChooser fileChooser = new FileChooser();
        File file=fileChooser.showOpenDialog(btnopen.getScene().getWindow());
        FileInputStream fis=new FileInputStream(file);
        Image image=new Image(fis);
        imgview.setImage(image);




    }


    public void imgTableShow()
    {
        colimg.setCellValueFactory(new PropertyValueFactory<>("img"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colphone.setCellValueFactory(new PropertyValueFactory<>("phone"));


        String sqyert="SELECT * FROM img";
        ObservableList<imageModel> patientlist= FXCollections.observableArrayList();
        try {
            PreparedStatement studentStatement=con.prepareStatement(sqyert);
            ResultSet rs7=studentStatement.executeQuery();
            while (rs7.next())
            {
                patientlist.add(new imageModel(


                       rs7.getString("im"),rs7.getString("name"),rs7.getString("phone")));

            }
            tblimage.setItems(patientlist);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        imgTableShow();

    }
}
