import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CrudUpdate {
    Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/back_end_technical?allowPublicKeyRetrieval=true&useSSL=false",
            "root",
            "codeup"
    );

    public CrudUpdate() throws SQLException {
    }

    public void Update() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                How would you like to search for the person to UPDATE? Choose a number option:
                1 - by FIRST NAME
                2 - by LAST NAME
                0 - Previous Menu"""
        );
        String userInput = sc.nextLine();

        switch (userInput) {
            case "1" -> {
                System.out.println("Enter the FIRST NAME of the person you want to UPDATE");
                userInput = sc.nextLine();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM persons WHERE first_name = '" + userInput + "'");
                ReadResults(rs, userInput, sc, statement);
            }
            case "2" -> {
                System.out.println("Enter the LAST NAME of the person you want to UPDATE");
                userInput = sc.nextLine();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM persons WHERE last_name = '" + userInput + "'");
                ReadResults(rs, userInput, sc, statement);
                break;
            }
            case "0" -> {
                break;
            }
            default -> {
            }
        }
    }

    public void ReadResults(ResultSet rs, String userInput, Scanner sc, Statement statement) throws SQLException {
        while (rs.next()) {
            System.out.println("##########");
            System.out.println("ID: " + rs.getLong("id"));
            System.out.println("Name: " + rs.getString("first_name") + " " + rs.getString("last_name"));
            System.out.println("Age: " + rs.getLong("age"));
            System.out.println("Date Joined: " + rs.getDate("date_joined"));
            System.out.println("Date of Information Update: " + rs.getDate("date_updated"));
            System.out.println("##########");
            System.out.println("Is this the person you're updating?: y/n");
            userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
                Person person = new Person(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getLong("age"), rs.getString("date_joined"), rs.getString("date_updated"));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date todaysDate = Calendar.getInstance().getTime();
                person.setDateUpdated(formatter.format(todaysDate));
                System.out.println("""
                        Which field would you like to update? Please choose a number
                        1 - FIRST NAME
                        2 - LAST NAME
                        3 - AGE
                        4 - DATE JOINED
                        0 - Previous Menu
                        """
                );
                userInput = sc.nextLine();
                switch (userInput) {
                    case "1" -> {
                        System.out.println("Enter the new FIRST NAME of person");
                        userInput = sc.nextLine();
                        statement.execute("UPDATE persons SET first_name = '" + userInput + "', date_updated = '" + person.getDateUpdated() + "' WHERE id = " + person.getId() + "");
                    }
                    case "2" -> {
                        System.out.println("Enter the new LAST NAME of person");
                        userInput = sc.nextLine();
                        statement.execute("UPDATE persons SET last_name = '" + userInput + "', date_updated = '" + person.getDateUpdated() + "' WHERE id = " + person.getId() + "");
                    }
                    case "3" -> {
                        System.out.println("Enter the new AGE of person");
                        userInput = sc.nextLine();
                        statement.execute("UPDATE persons SET age = '" + userInput + "', date_updated = '" + person.getDateUpdated() + "' WHERE id = " + person.getId() + "");
                    }
                    case "4" -> {
                        System.out.println("Enter the new DATE JOINED of person (User format yyyy-mm-dd");
                        userInput = sc.nextLine();
                        statement.execute("UPDATE persons SET date_joined = '" + userInput + "', date_updated = '" + person.getDateUpdated() + "' WHERE id = " + person.getId() + "");

                    }
                    default -> {
                    }
                }
                break;
            }
        }
    }
    // Ensure any executed updates also updates the date_updated field
}
