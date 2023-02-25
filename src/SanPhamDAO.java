import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SanPhamDAO {

        private static SanPhamDAO instance;

        public Statement statement;
private SanPhamDAO() {
}
        public ArrayList<SanPham> getAll() {
            ArrayList<SanPham> list = new ArrayList<>();
            try {
                Database db = Database.getInstance();
                Statement stt = db.getStatement();
                String sql = "select * from sanpham";
                ResultSet rs = stt.executeQuery(sql);
                while (rs.next()) {
                    Integer id = rs.getInt("id");
                    String name = rs.getString("name");
                    String gia = rs.getString("gia");
                    String mota = rs.getString("mota");
                    String room = rs.getString("room");
                    SanPham c = new SanPham(id, name, gia, mota);
                    list.add(c);
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(e.getMessage());
                alert.show();


            }
            return list;
        }




        public boolean create(SanPham sanPham) {
            try {

                Database db = Database.getInstance();
                Statement stt = db.getStatement();
                String sql = "insert into  sanpham(name,gia,mota) values('" + sanPham.getName() + "','" + sanPham.getGia() + "','" + sanPham.getMota() + "')";
                if (stt.executeUpdate(sql) > 0) {
                    return true;
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(e.getMessage());
                alert.show();
            }
            return false;
        }

        public boolean update(SanPham sanPham) {
            try {
                Database db = Database.getInstance();
                Statement stt = db.getStatement();
                String sql = " update sanpham  set name = '" + sanPham.getName() + "', room = '" + sanPham.getGia() + "',mota='" + sanPham.getMota() + "' where id = " + sanPham.getId();
                if (stt.executeUpdate(sql) > 0) {
                    return true;
                }
            } catch (Exception e) {
            }
            return false;
        }

        public boolean delete(SanPham sanPham) {
            try {
                Database db = Database.getInstance();
                Statement stt = db.getStatement();
                String sql = " delete sanpham   where id = " + sanPham.getId();
                if (stt.executeUpdate(sql) > 0) {
                    return true;
                }
            } catch (Exception e) {
            }
            return false;
        }



        //generic method
        public <N> SanPham findOne(N id) {//khi su dung gia tri truyen vao se  la kieu du lieu
            return null;
        }

        public static SanPhamDAO getInstance() throws Exception {
            if (instance == null) {
                instance = new SanPhamDAO();
            }
            return instance;
        }

        public Statement getStatement() {

            return statement;
        }
    }


