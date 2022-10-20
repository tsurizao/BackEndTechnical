import java.sql.*;
import java.util.Scanner;

public class CrudRead {
    Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/back_end_technical?allowPublicKeyRetrieval=true&useSSL=false",
            "root",
            "codeup"
    );

    public CrudRead() throws SQLException {
    }

    public void Read() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS persons (id INT UNSIGNED NOT NULL AUTO_INCREMENT, first_name VARCHAR(50) NOT NULL, last_name  VARCHAR(100) NOT NULL, age INT NOT NULL, date_joined DATE NOT NULL, date_updated DATE NOT NULL, PRIMARY KEY (id))");
        boolean loopState = true;
        while (loopState) {
            System.out.println("""
                    How would you like to search for a person? Choose a number option:
                    1 - by FIRST NAME
                    2 - by LAST NAME
                    3 - by AGE
                    4 - by DATE JOINED
                    5 - by DATE of information UPDATED
                    0 - Previous Menu"""
            );
            String userInput = sc.nextLine();
            switch (userInput) {
                case "1": {
                    System.out.println("Enter the FIRST NAME of the person: ");
                    userInput = sc.nextLine();
                    ResultSet rs = statement.executeQuery("SELECT * FROM persons WHERE first_name = '" + userInput + "'");
                    readResultSet(rs);
                    break;
                }
                case "2": {
                    System.out.println("Enter the LAST NAME of the person: ");
                    userInput = sc.nextLine();
                    ResultSet rs = statement.executeQuery("SELECT * FROM persons WHERE last_name = '" + userInput + "'");
                    readResultSet(rs);
                    break;
                }
                case "3": {
                    System.out.println("Enter the AGE of the person: ");
                    userInput = sc.nextLine();
                    ResultSet rs = statement.executeQuery("SELECT * FROM persons WHERE age = '" + Long.parseLong(userInput) + "'");
                    readResultSet(rs);
                    break;
                }
                case "4": {
                    System.out.println("Enter the DATE JOINED of the person: (Format YYYY-MM-DD)");
                    userInput = sc.nextLine();
                    ResultSet rs = statement.executeQuery("SELECT * FROM persons WHERE date_joined = '" + userInput + "'");
                    readResultSet(rs);
                    break;
                }
                case "5": {
                    System.out.println("Enter the DATE of information UPDATE: (Format YYYY-MM-DD)");
                    userInput = sc.nextLine();
                    ResultSet rs = statement.executeQuery("SELECT * FROM persons WHERE date_updated = '" + userInput + "'");
                    readResultSet(rs);
                    break;
                }
                case "0": {
                    loopState = false;
                    break;
                }
                default: {
                }
            }
        }
        connection.close();
    }

    // Used to reduce amount of code when reading result sets
    public void readResultSet(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println("##########");
            System.out.println("ID: " + rs.getLong("id"));
            System.out.println("Name: " + rs.getString("first_name") + " " + rs.getString("last_name"));
            System.out.println("Age: " + rs.getLong("age"));
            System.out.println("Date Joined: " + rs.getDate("date_joined"));
            System.out.println("Date of Information Update: " + rs.getDate("date_updated"));
            System.out.println("##########");
        }
    }
}
