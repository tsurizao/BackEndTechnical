import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
                System.out.println("Person's FIRST NAME set to: " + person.getFirstName());
            }
            while (person.getLastName() == null || person.getLastName().trim().equals("")) {
                System.out.println("Please enter the person's LAST NAME: ");
                String userInput = sc.nextLine();
                person.setLastName(userInput);
                System.out.println("Person's LAST NAME set to: " + person.getLastName());
            }
            while (person.getAge() <= 0) {
                System.out.println("Please enter the person's AGE: ");
                String userInput = sc.nextLine();
                person.setAge(Long.parseLong(userInput));
                System.out.println("Person's AGE set to: " + person.getAge());
            }
            while (person.getDateJoined() == null){
                System.out.println("Please enter the DATE the person joined (Format as DD-MM-YYYY): ");
                String userInput = sc.nextLine();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date date = formatter.parse(userInput);
                person.setDateJoined(date);
            }
            while(true){
                LocalDate todaysDate = new LocalDate();

                break;
            }
        }
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS persons (id INT UNSIGNED NOT NULL AUTO_INCREMENT, first_name VARCHAR(50) NOT NULL, last_name  VARCHAR(100) NOT NULL, age INT UNSIGNED NOT NULL, date_joined DATE NOT NULL, date_updated DATE NOT NULL, PRIMARY KEY (id))");
        statement.execute("INSERT INTO persons (" + person.getFirstName() + ", " + person.getLastName() + ", " + person.getAge() + ", " + person.getDateJoined() + ", " + person.getDateUpdated() + ")");
    }
}