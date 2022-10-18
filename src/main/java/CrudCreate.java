import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CrudCreate {
    // Crud Sub Program

    Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/back_end_technical?allowPublicKeyRetrieval=true&useSSL=false",
            "root",
            "codeup"
    );

    public CrudCreate() throws SQLException {
    }

    public void Create() throws SQLException, ParseException {
        Scanner sc = new Scanner(System.in);
        Person person = new Person();
        while (person.getFirstName() == null && person.getLastName() == null && person.getAge() == 0 && person.getDateJoined() == null && person.getDateUpdated() == null) {
            while (person.getFirstName() == null || person.getFirstName().trim().equals("")) {
                System.out.println("Please enter the person's FIRST NAME: ");
                String userInput = sc.nextLine();
                person.setFirstName(userInput);
            }
            while (person.getLastName() == null || person.getLastName().trim().equals("")) {
                System.out.println("Please enter the person's LAST NAME: ");
                String userInput = sc.nextLine();
                person.setLastName(userInput);
            }
            while (person.getAge() <= 0) {
                System.out.println("Please enter the person's AGE: ");
                String userInput = sc.nextLine();
                person.setAge(Long.parseLong(userInput));

            }
            while (person.getDateJoined() == null) {
                System.out.println("Please enter the DATE the person joined (Format as YYYY-MM-DD): ");
                String userInput = sc.nextLine();
                person.setDateJoined(userInput);
            }
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date todaysDate = Calendar.getInstance().getTime();
            person.setDateUpdated(formatter.format(todaysDate));
        }
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS persons (id INT UNSIGNED NOT NULL AUTO_INCREMENT, first_name VARCHAR(50) NOT NULL, last_name  VARCHAR(100) NOT NULL, age INT NOT NULL, date_joined DATE NOT NULL, date_updated DATE NOT NULL, PRIMARY KEY (id))");
        statement.execute("INSERT INTO persons (first_name, last_name, age, date_joined, date_updated) VALUES ('" + person.getFirstName() + "', '" + person.getLastName() + "', '" + person.getAge() + "', '" + person.getDateJoined() + "', '" + person.getDateUpdated() + "')");
    }
}