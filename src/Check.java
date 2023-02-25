import java.awt.*;
import javafx.scene.control.Button;
public class Check {
    Integer Id;
    String Name;
    String Sdt;


    public Check(Integer id, String name, String sdt) {
        Id = id;
        Name = name;
        Sdt = sdt;


    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
