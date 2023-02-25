import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {
    public static Stage rootStage;
    public void goToSanPham(ActionEvent actionEvent) throws Exception
    {
    Parent root = FXMLLoader.load(getClass().getResource("sanpham.fxml"));
        HomeController.rootStage.setScene(new Scene(root,1000,800));
}

    public void goToKiemTra(ActionEvent actionEvent) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("Check.fxml"));
        HomeController.rootStage.setScene(new Scene(root,887,756));
    }
}
