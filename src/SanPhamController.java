import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

public class SanPhamController implements Initializable {
    public TextField txtNamesp;
    public TextField txtMota;
    public TextField txtGiatien;
    public static TextField stNamesp;
    public static TextField stMota;
    public static TextField stGiatien;
    public ObservableList<SanPham> listSanPham = FXCollections.observableArrayList();
    public static SanPham editSanPham;
    public TableColumn<SanPham,String> cNamesp;
    public TableColumn<SanPham,Double> cGia;
    public TableColumn<SanPham,String> cMota;

    public TableColumn<SanPham, Button> cAction;
    public TableView<SanPham> tbview;
    public TableColumn cId;


    void clearInput(){
        txtNamesp.clear();;
        txtGiatien.clear();
        txtMota.clear();
    }
    public void edit(MouseEvent mouseEvent){
        txtNamesp.setText(editSanPham.getName());
        txtGiatien.setText(editSanPham.getGia());
        txtMota.setText(editSanPham.getMota());
    }

    public void BackHome(ActionEvent actionEvent) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        HomeController.rootStage.setScene(new Scene(root,1000,600));

    }

    public void goToKiemTra(ActionEvent actionEvent) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("Check.fxml"));
        HomeController.rootStage.setScene(new Scene(root,887,756));

    }
    public void Mua(ActionEvent actionEvent) throws Exception
    {
        try {
            String name = txtNamesp.getText();
            String gia = txtGiatien.getText();
            String mota = txtMota.getText();
            if (name.isEmpty() ||gia.isEmpty() ||mota.isEmpty()){
                throw new Exception("Vui lòng nhập đủ thông tin vào đây");
            }
            Database db = Database.getInstance();
            Statement stt = db.getStatement();
            String sql = "insert into sanpham(namekh,Sdt,gia) values('"+name+"','"+gia+"','"+mota+"')";
            stt.executeUpdate(sql);
            BackHome(null);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
        Parent root = FXMLLoader.load(getClass().getResource("Check.fxml"));
        HomeController.rootStage.setScene(new Scene(root,887,756));
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cNamesp.setCellValueFactory(new PropertyValueFactory<>("Name"));
        cGia.setCellValueFactory(new PropertyValueFactory<>("Gia"));
        cMota.setCellValueFactory(new PropertyValueFactory<>("Mota"));


        stNamesp = txtNamesp;
        stGiatien = txtGiatien;
        stMota = txtMota;


    }


}
