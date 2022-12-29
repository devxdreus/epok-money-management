package connect;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author User
 */
public class Koneksi {
    private static Connection connection;
    public static Connection GetConnection()throws SQLException{
            if (connection == null) {
          // koneksi ke database MySQL
          String host = "jdbc:mysql://localhost:3306/epok";
          String username = "root";
          String password = "";

          try {
            connection = DriverManager.getConnection(host, username, password);
          } catch (SQLException e) {
            System.out.println("Koneksi gagal dibuat: " + e.getMessage());
          }
        }
        return connection;
    }
}
