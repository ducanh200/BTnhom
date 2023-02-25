import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CheckController implements Initializable {



    public TextField txtNamekh;
    public TextField txtSdt;
    public static TextField stNamekh;
    public static TextField stSdt;
    public ObservableList<Check> listCheck = FXCollections.observableArrayList();
    public static Check editCheck;
    public TableView<Check> tbView;
    public TableColumn<Check,String> cNamekh;
    public TableColumn<Check,String> cSdt;
    public TableColumn<Check, Button> cAction;
    public TableColumn cNamesp;
    public TableColumn cGia;
    public TableColumn cId;

    public void Nhap(ActionEvent actionEvent) {
        try {
            String namekh = txtNamekh.getText();
            String sdt = txtSdt.getText();
            if (namekh.isEmpty() ||sdt.isEmpty()){
                throw new Exception("Vui lòng nhập đủ thông tin vào đây");
            }
            Database db = Database.getInstance();
            Statement stt = db.getStatement();
            String sql = "insert into kiemtra(namekh,Sdt) values('"+namekh+"','"+sdt+"')";
            stt.executeUpdate(sql);
            BackSanPham(null);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }

    }


    public void BackSanPham(ActionEvent actionEvent) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("sanpham.fxml"));
        HomeController.rootStage.setScene(new Scene(root,1000,800));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

            cId.setCellValueFactory(new PropertyValueFactory<>("id"));
            cNamekh.setCellValueFactory(new PropertyValueFactory<>("namekh"));
            cSdt.setCellValueFactory(new PropertyValueFactory<>("Sdt"));
            ObservableList <Check> list = FXCollections.observableArrayList();
            CheckDAO cd = new CheckDAO();
            ArrayList<Check> dslh = cd.getAll();
//        tbview.setItems(list);
            tbView.getItems().addAll(dslh);
            tbView.refresh();
    }
}
