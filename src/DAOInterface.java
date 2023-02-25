import java.util.ArrayList;

public interface DAOInterface <S>{
    ArrayList<S> getALL();
    boolean create(S sanpham);
    boolean update(S sanpham);
    boolean delete(S sanpham);
    Check find(Integer id);


}
