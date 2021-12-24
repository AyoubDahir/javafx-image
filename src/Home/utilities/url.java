package Home.utilities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class url
{

    public static  void show(String title,String url) throws Exception
    {
        Stage stage = new Stage();
        stage.setTitle(title);
        Parent root= FXMLLoader.load(url.class.getResource(url));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();






    }
}
