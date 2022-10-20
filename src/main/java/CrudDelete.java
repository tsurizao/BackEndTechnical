import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CrudDelete {
    Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/back_end_technical?allowPublicKeyRetrieval=true&useSSL=false",
            "root",
            "codeup"
    );

    public CrudDelete() throws SQLException {
    }

    public void Delete() throws SQLException {

    }
}
