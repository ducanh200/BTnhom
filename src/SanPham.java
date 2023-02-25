import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;

public class SanPham  {
    Integer Id;

    String Name;
    String Gia;
    String Mota;



    public SanPham(Integer id, String name, String gia, String mota) {
        this.Id =id;
        this.Name = name;
        this.Gia = gia;
        this.Mota = mota;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
