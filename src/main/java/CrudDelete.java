import java.awt.font.ImageGraphicAttribute;
import java.sql.*;
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
        String userInput = sc.nextLine();
        if (userInput.equals("1")) {
            System.out.println("Enter the FIRST NAME of the person you want to DELETE");
            userInput = sc.nextLine();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM persons WHERE first_name = '" + userInput + "'");
            ReadResults(rs, sc, statement);
        } else if (userInput.equals("2")) {
            System.out.println("Enter the LAST NAME of the person you want to UPDATE");
            userInput = sc.nextLine();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM persons WHERE last_name = '" + userInput + "'");
            ReadResults(rs, sc, statement);
        } else {
            System.out.println("Returning to previous menu.");
        }
    }

    public void ReadResults(ResultSet rs, Scanner sc, Statement statement) throws SQLException {
        while (rs.next()) {
            System.out.println("##########");
            System.out.println("ID: " + rs.getLong("id"));
            System.out.println("Name: " + rs.getString("first_name") + " " + rs.getString("last_name"));
            System.out.println("Age: " + rs.getLong("age"));
            System.out.println("Date Joined: " + rs.getDate("date_joined"));
            System.out.println("Date of Information Update: " + rs.getDate("date_updated"));
            System.out.println("##########");
            System.out.println("Is this the person you're DELETING?: y/n");
            String userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
                System.out.println("This process is PERMANENT, enter the word 'DELETE' to confirm then press ENTER.  To cancel press ENTER.");
                userInput = sc.nextLine();
                if (userInput.equals("DELETE")) {
                    statement.execute("DELETE FROM persons WHERE id = '" + rs.getLong("id") + "'");
                    System.out.println("Person has been removed from database.");
                    break;
                } else {
                    System.out.println("Deletion canceled.");
                }
            }
        }
    }
}