import java.io.DataInputStream;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    private static Database instance;
    private Statement statement;

    private Database() throws Exception
    {

        Class.forName("com.mysql,jdbc.Driver");
        String connectionString = "jdbc:mysql://localhost:3306/team3";
        String user = "root";
        String pwd = " ";
        Connection conn = DriverManager.getConnection(connectionString, user, pwd);
        this.statement = conn.createStatement();
    }

    public static Database getInstance() throws Exception{
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }
    public Statement getStatement() {

        return statement;
    }
}
