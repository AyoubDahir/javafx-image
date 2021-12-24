package Home.model;

import javafx.scene.image.Image;

import java.io.InputStream;

public class imageModel {


    private String img, name, phone;

    public imageModel(){}

    public imageModel(String img, String name, String phone) {
        this.img = img;
        this.name = name;
        this.phone = phone;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}