import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CrudDelete {
    Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/back_end_technical?allowPublicKeyRetrieval=true&useSSL=false",
            "root",
            "codeup"
    );

    public CrudDelete() throws SQLException {
    }

    public void Delete() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                How would you like to search for the person to DELETE? Choose a number option:
                1 - by FIRST NAME
                2 - by LAST NAME
                0 - Previous Menu"""
        );
    }
}
