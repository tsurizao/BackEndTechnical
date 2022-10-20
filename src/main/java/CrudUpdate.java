import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CrudUpdate {
    Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/back_end_technical?allowPublicKeyRetrieval=true&useSSL=false",
            "root",
            "codeup"
    );

    public CrudUpdate() throws SQLException {
    }

    public void Update(){
        Scanner sc = new Scanner(System.in);

    }
    // Ensure any executed updates also updates the date_updated field
}
