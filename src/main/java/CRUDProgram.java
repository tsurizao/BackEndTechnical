import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class CRUDProgram {
    public static void Run() throws SQLException, ParseException {
        Scanner sc = new Scanner(System.in);
        boolean programStatus = true;

        //Loop will serve as the program running as long as user does not choose to exit with entering 0 (zero)
        while (programStatus) {

            // Printing main menu
            System.out.println("What would you like to do?  Please choose the appropriate number for the selection");
            System.out.println("1 - Create a person");
            System.out.println("2 - Read a person");
            System.out.println("3 - Update a person");
            System.out.println("4 - Delete a person");
            System.out.println("0 - Exit Program");
            String userInput = sc.nextLine();

            // Used Switch instead of if/else statements
            switch (userInput) {
                case "1" -> {
                    System.out.println("CREATE");
                    // CrudCreate is a standalone class that handles the C part of CRUD
                    CrudCreate create = new CrudCreate();
                    create.Create();
                }
                case "2" -> {
                    System.out.println("READ");
                }
                case "3" -> {
                    System.out.println("UPDATE");
                }
                case "4" -> {
                    System.out.println("DELETE");
                }
                case "0" -> {
                    programStatus = false;
                    System.out.println("Have a nice day!");
                }
            }
        }
    }
}
