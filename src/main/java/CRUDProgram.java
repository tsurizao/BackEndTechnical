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
            System.out.println("""
                    What would you like to do?  Choose a number option:
                    1 - Create a person
                    2 - Read a person
                    3 - Update a person
                    4 - Delete a person
                    0 - Exit Program"""
            );

            String userInput = sc.nextLine();

            // Used Switch instead of if/else statements
            switch (userInput) {
                case "1" -> {
                    System.out.println("CREATE");
                    CrudCreate create = new CrudCreate();
                    create.Create();
                }
                case "2" -> {
                    System.out.println("READ");
                    CrudRead read = new CrudRead();
                    read.Read();
                }
                case "3" -> {
                    System.out.println("UPDATE");
                    CrudUpdate update = new CrudUpdate();
                    update.Update();
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
