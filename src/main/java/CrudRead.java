import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CrudRead {
    Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/back_end_technical?allowPublicKeyRetrieval=true&useSSL=false",
            "root",
            "codeup"
    );

    public CrudRead() throws SQLException {
    }

    public void Read(){
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        // by first name

        // by last name

        // by age

        // by date joined

        // by date updated
    }
}
