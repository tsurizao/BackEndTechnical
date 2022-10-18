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
            System.out.println("0 - Exit Program");
            String userInput = sc.nextLine();
            if (userInput.equals("1")) {
                boolean optionStatus = true;
                System.out.println("CREATE");
                while (optionStatus) {
                    CrudCreate create = new CrudCreate();
                    create.Create();
                    optionStatus = false;
                }
            } else if (userInput.equals("2")) {
                System.out.println("READ");
            } else if (userInput.equals("3")) {
                System.out.println("UPDATE");
            } else if (userInput.equals("4")) {
                System.out.println("DELETE");
            } else if (userInput.equals("0")) {
                programStatus = false;
                System.out.println("Have a nice day!");
            }
        }
    }
}
