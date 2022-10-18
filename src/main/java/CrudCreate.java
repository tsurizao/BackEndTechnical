import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudCreate {
    Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/back_end_technical?allowPublicKeyRetrieval=true&useSSL=false",
            "root",
            "codeup"
    );

    public CrudCreate() throws SQLException {
    }

    public void Create(Person person) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS persons (id INT UNSIGNED NOT NULL AUTO_INCREMENT, first_name VARCHAR(50) NOT NULL, last_name  VARCHAR(100) NOT NULL, age INT UNSIGNED NOT NULL, date_joined DATE NOT NULL, date_updated DATE NOT NULL, PRIMARY KEY (id))");
        statement.execute("INSERT INTO persons (" + person.getFirstName() + ", " + person.getLastName() + ", " + person.getAge() + ", " + person.getDateJoined() + ", " + person.getDateUpdated() + ")");
    }
}