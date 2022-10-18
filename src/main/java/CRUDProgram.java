import java.sql.SQLException;
import java.util.Scanner;

public class CRUDProgram {
    public static void Run() throws SQLException {
        Scanner sc = new Scanner(System.in);
        boolean programStatus = true;
        while (programStatus) {
            System.out.println("What would you like to do?  Please choose the appropriate number for the selection");
            System.out.println("1 - Create a person");
            System.out.println("2 - Read a person");
            System.out.println("3 - Update a person");
            System.out.println("4 - Delete a person");
            String userInput = sc.nextLine();
            switch (userInput) {
                case "1" ->
                    // CrudCreate;
                        System.out.println("You chose CREATE");
                case "2" ->
                    // CrudRead
                        System.out.println("You chose READ");
                case "3" ->
                    // CrudUpdate
                        System.out.println("You chose UPDATE");
                case "4" ->
                    // CrudDelete
                        System.out.println("You chose DELETE");
                case "0" -> {
                    System.out.println("You chose to exit, have a nice day!");
                    programStatus = false;
                }
                default -> System.out.println("Please choose an option from the menu.");
            }
        }
    }
}
